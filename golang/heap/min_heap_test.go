package heap

import (
	"fmt"
	"testing"

	"github.com/stretchr/testify/assert"
)

func TestMinHeap(t *testing.T) {
	h := NewMinHeap()
	h.Push(10)
	h.Push(20)
	h.Push(30)
	v, _ := h.Pop()
	fmt.Println(v)
	assert.Equal(t, 10, v)

	v, _ = h.Pop()
	fmt.Println(v)
	assert.Equal(t, 20, v)

	v, _ = h.Pop()
	fmt.Println(v)
	assert.Equal(t, 30, v)
}
