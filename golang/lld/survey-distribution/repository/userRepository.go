package repository

import (
	"context"
	"fmt"
	"survey-distribution/domain"
)

type PgUserRepository struct {
	//db connection
}

func (r *PgUserRepository) QueryUsers(ctx context.Context, filter UserFilter, batchSize int64, callback func(users []domain.User) error) error {
	var lastID int64 = 0
	for {
		var sql = "select * from user where user.age > {filter.MinAge} and user.region in (filter.TargetedReion) and id > lastId order by id asc limit {batchSize}"
		fmt.Println(lastID, sql)
		var batch = []domain.User{}
		if len(batch) == 0 {
			break
		}
		if err := callback(batch); err != nil {
			fmt.Println("error: ", err)
			return err
		}
		lastID = batch[len(batch)-1].ID
	}
	return nil
}
