package arrays

import (
	"fmt"
	"sort"
	"testing"

	"github.com/stretchr/testify/assert"
)

func TestGroupAnagrams_HappyPath(t *testing.T) {
	arr := []string{"eat", "tea", "tan", "ate", "nat", "bat"}
	ans := groupAnagrams(arr)
	expected := [][]string{
		{"eat", "tea", "ate"},
		{"tan", "nat"},
		{"bat"},
	}
	for i := range ans {
		sort.Strings(ans[i])
	}
	for i := range expected {
		sort.Strings(expected[i])
	}
	assert.ElementsMatch(t, expected, ans)
	fmt.Println(ans)
}

func TestGroupAnagrams_EmptyArr(t *testing.T) {
	arr := []string{}
	ans := groupAnagrams(arr)
	assert.ElementsMatch(t, ans, arr)
	fmt.Println(ans)
}
