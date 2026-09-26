package arrays

func longestConsequtiveArrays(arr []int) int {
	ans := make(map[int]bool)
	for _, v := range arr {
		ans[v] = true
	}

	maxCount := 0
	for _, v := range arr {
		if !ans[v-1] {
			//start of sequqnce
			count := 0
			x := v
			for ans[x] {
				x++
				count++
			}
			if count > maxCount {
				maxCount = count
			}
		}
	}
	return maxCount

}
