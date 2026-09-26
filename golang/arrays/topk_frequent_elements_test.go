package arrays

import (
	"fmt"
	"testing"

	"github.com/stretchr/testify/assert"
)

func TestTopKFrequentElements(t *testing.T) {
	arr := []int{1, 2, 2, 3, 3, 3, 3, 4, 4}
	ans := topKFrequent(arr, 3)
	fmt.Println(ans)

	expected := []int{3, 4, 2}
	assert.ElementsMatch(t, expected, ans)
}

func TestTopKFrequentElementsMultipleInSameBucket(t *testing.T) {
	arr := []int{1, 2, 3, 3, 4, 4}
	ans := topKFrequent(arr, 4)
	fmt.Println(ans)

	expected := []int{3, 4, 1, 2}
	assert.ElementsMatch(t, expected, ans)
}

func TestClash(t *testing.T) {
	arr := []int{1, 2, 3, 3, 4}
	ans := topKFrequent(arr, 3)
	fmt.Println(ans)

	expected := []int{3, 4, 1}
	assert.ElementsMatch(t, expected, ans)
}

func TestSingleElement(t *testing.T) {
	arr := []int{1}
	ans := topKFrequent(arr, 1)
	fmt.Println(ans)
	expected := []int{1}
	assert.ElementsMatch(t, expected, ans)
}

func Test_test2(t *testing.T) {
	arr := []int{1, 1, 2}
	ans := topKFrequent(arr, 2)
	fmt.Println(ans)
	expected := []int{1, 2}
	assert.ElementsMatch(t, expected, ans)
}
