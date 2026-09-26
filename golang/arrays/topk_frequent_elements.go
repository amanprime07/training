package arrays

// bucket algorithm
func topKFrequent(arr []int, k int) []int {
	store := make(map[int]int)
	for _, v := range arr {
		store[v] += 1
	}
	ans := make([]int, 0, k)
	bucket := make([][]int, len(arr)+1)
	for num, count := range store {
		bucket[count] = append(bucket[count], num)
	}

	for i := len(bucket) - 1; i >= 0; i-- {
		for _, v := range bucket[i] {
			ans = append(ans, v)
			if len(ans) == k {
				return ans
			}
		}
	}

	return ans
}
