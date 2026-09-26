package arrays

import "fmt"

func productExceptSelf(arr []int) []int {
	left := 1
	right := 1
	ans := make([]int, len(arr))
	for i := range len(arr) {
		ans[i] = 1
	}
	for i, v := range arr {
		ans[i] = ans[i] * left
		left = left * v
	}

	for i := len(arr) - 1; i >= 0; i-- {
		ans[i] = ans[i] * right
		right = right * arr[i]
	}
	return ans
}

func main() {
	arr := []int{1, 2, 3, 4}
	fmt.Println(productExceptSelf(arr))
	arr = []int{1, 0, 1, 1}
	fmt.Println(productExceptSelf(arr))
	arr = []int{1, 0, 2, 0}
	fmt.Println(productExceptSelf(arr))
}
