// Package repository helps maintain all db assocaited works
package repository

import (
	"context"
	"survey-distribution/domain"
)

type UserFilter struct {
	Region   string
	MinAge   int
	SurveyID int64
}

type UserRepository interface {
	QueryUsers(ctx context.Context, filter UserFilter, batchSize int64, callback func(users []domain.User) error) error
}
