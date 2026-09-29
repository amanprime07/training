// Package providers contains all Communication Providers
package providers

import (
	"context"
	"survey-distribution/domain"
)

type SmsProvider struct{}

func (s *SmsProvider) Send(ctx context.Context, survey domain.Survey, user domain.User) error {
	return nil
}

func (s *SmsProvider) ChannelType() string {
	return "SMS"
}
