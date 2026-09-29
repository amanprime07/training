package providers

import (
	"context"
	"survey-distribution/domain"
)

type PushProvider struct{}

func (p *PushProvider) Send(ctx context.Context, survey domain.Survey, user domain.User) error {
	return nil
}

func (p *PushProvider) ChannelType() string {
	return "PUSH"
}
