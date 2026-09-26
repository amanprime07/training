package arrays

import "fmt"

func twoSum(arr []int, sum int) bool {
	seen := make(map[int]bool)
	for _, v := range arr {
		rem := sum - v
		if seen[rem] {
			return true
		}
		seen[v] = true
	}
	return false
}

func main1() {
	arr := []int{1, 2, 3, 4}
	fmt.Println(twoSum(arr, 7))
}
