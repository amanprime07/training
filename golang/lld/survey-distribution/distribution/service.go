// Package distribution provides distribution service
package distribution

import (
	"context"
	"fmt"
	"survey-distribution/domain"
	"survey-distribution/providers"
	"survey-distribution/repository"
	"survey-distribution/rules"
	"sync"
)

type DistributionService struct {
	userRepo  repository.UserRepository
	providers map[string]providers.NotificationProvider
	rules     []rules.TargetingRule
	mu        *sync.RWMutex
}

func NewDistritbutionService(userRepo repository.UserRepository, rules []rules.TargetingRule) *DistributionService {
	return &DistributionService{
		userRepo:  userRepo,
		rules:     rules,
		providers: make(map[string]providers.NotificationProvider),
	}
}

func (d *DistributionService) RegisterProvider(p providers.NotificationProvider) {
	d.mu.Lock()
	defer d.mu.Unlock()
	d.providers[p.ChannelType()] = p
}

func (d *DistributionService) Distrubute(ctx context.Context, survey domain.Survey) error {
	filter := repository.UserFilter{
		Region:   survey.Region,
		SurveyID: survey.ID,
		MinAge:   survey.MinAge,
	}
	batchSize := 500
	err := d.userRepo.QueryUsers(ctx, filter, int64(batchSize), func(users []domain.User) error {
		for _, user := range users {
			eligible := true
			for _, rule := range d.rules {
				if ok, _ := rule.IsEligible(ctx, survey, user); !ok {
					eligible = false
					break
				}
			}

			if !eligible {
				continue
			}

			//Send notifications
			d.sendToAllChannels(ctx, survey, user)
		}
		return nil
	})
	return err
}

func (d *DistributionService) sendToAllChannels(ctx context.Context, survey domain.Survey, user domain.User) {
	for _, name := range survey.Channels {
		provider := d.providers[name]
		fmt.Printf("Sending notifcation to user %d via provider %s", user.ID, name)
		if err := provider.Send(ctx, survey, user); err != nil {
			fmt.Println("Error: ", err)
		}
	}
}
