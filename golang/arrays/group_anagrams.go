package arrays

func groupAnagrams(arr []string) [][]string {
	ans := make([][]string, 0)
	store := make(map[[26]int][]string)
	for _, s := range arr {
		hashValue := hashedString(s)
		store[hashValue] = append(store[hashValue], s)
	}

	for _, v := range store {
		ans = append(ans, v)
	}

	return ans
}

func hashedString(str string) [26]int {
	var hash [26]int

	for _, v := range str {
		i := v - 'a'
		hash[i] = hash[i] + 1
	}
	return hash
}
