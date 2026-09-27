package heap

import (
	"container/heap"
	"fmt"
	"testing"

	"github.com/stretchr/testify/assert"
)

func Test_MinCHeap(t *testing.T) {
	h := &MinCHeap{}
	heap.Init(h)
	heap.Push(h, 10)
	heap.Push(h, 220)
	v := heap.Pop(h)
	fmt.Println(v)
	assert.Equal(t, 10, v)
}
