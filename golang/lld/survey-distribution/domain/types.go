// Package domain contains all domain type
package domain

// Survey represnet content to distribute
type Survey struct {
	ID       int64
	Name     string   // survey name
	Channels []string // eg: ["Email", "SMS"], etc
	Region   string
	MinAge   int
}

// User represents target recipient
type User struct {
	ID         int64
	Name       string
	Email      string
	Phone      string
	Attributes map[string]interface{} // for targeting rules.
}
