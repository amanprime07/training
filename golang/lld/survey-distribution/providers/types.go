package providers

import (
	"context"
	"survey-distribution/domain"
)

type NotificationProvider interface {
	Send(ctx context.Context, survey domain.Survey, user domain.User) error
	ChannelType() string // ["EMAIL", "SMS"]
}
