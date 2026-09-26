package arrays

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func TestLongestConsequtiveArray(t *testing.T) {
	arr := []int{1, 2, 3, 4}
	l := longestConsequtiveArrays(arr)
	assert.Equal(t, 4, l)
	println(l)
}

func TestLongestConsequtiveArraysWithInt(t *testing.T) {
	arr := []int{-1, 0, 1, 2, 3, 4}
	l := longestConsequtiveArrays(arr)
	assert.Equal(t, 6, l)
	println(l)
}

func TestNoSequence(t *testing.T) {
	arr := []int{-1, 1, 3, 5, 7}
	l := longestConsequtiveArrays(arr)
	assert.Equal(t, 1, l)
	println(l)
}
