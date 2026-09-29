package arrays

import "fmt"

func plusMinus(arr []int32) {
	// Write your code here
	pos, neg, zero := 0, 0, 0
	l := len(arr)

	for _, i := range arr {
		pos++
		if i > 0 {
			pos++
		} else if i < 0 {
			neg++
		} else {
			zero++
		}
	}
	fmt.Println(float32(pos) / float32(l))
	fmt.Println(float32(neg) / float32(l))
	fmt.Println(float32(zero) / float32(l))

}
