package main

import (
	"context"
	"survey-distribution/distribution"
	"survey-distribution/domain"
	"survey-distribution/repository"
	"survey-distribution/rules"
	"time"
)

func main() {
	println("Survery distribution system")
	userRepo := &repository.PgUserRepository{}
	rules := make([]rules.TargetingRule, 0)
	ds := distribution.NewDistritbutionService(userRepo, rules)
	ctx, cancel := context.WithTimeout(context.Background(), 2*time.Minute)
	defer cancel()
	survey := &domain.Survey{}
	ds.Distrubute(ctx, *survey)
}
