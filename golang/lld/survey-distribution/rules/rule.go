package rules

import (
	"context"
	"survey-distribution/domain"
)

type TargetingRule interface {
	IsEligible(ctx context.Context, survey domain.Survey, user domain.User) (bool, error)
}
