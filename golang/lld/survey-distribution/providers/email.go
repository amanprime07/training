package providers

import (
	"context"
	"fmt"
	"survey-distribution/domain"
)

type EmailProvider struct{}

func (e *EmailProvider) Send(ctx context.Context, survey domain.Survey, user domain.User) error {
	// Simulated email sending logic
	fmt.Printf("Email sent to %s for survey %d\n", user.Email, survey.ID)

	return nil
}

func (e *EmailProvider) ChannelType() string {
	return "EMAIL"
}
