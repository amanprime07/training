package rules

import (
	"context"
	"survey-distribution/domain"
)

type FrequencyRule struct{}

func (f *FrequencyRule) IsEligible(ctx context.Context, survey domain.Survey, user domain.User) (bool, error) {
	// check if user got any survey in last 24 hrs
	return true, nil
}
