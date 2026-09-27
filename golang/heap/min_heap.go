package heap

type MinHeap struct {
	arr []int
}

func NewMinHeap() *MinHeap {
	return &MinHeap{}
}

func (h *MinHeap) Pop() (int, bool) {
	if h.size() == 0 {
		return 0, false

	}
	v := h.arr[0]
	lastIdx := h.size() - 1
	h.arr[0] = h.arr[lastIdx]
	h.arr = h.arr[:lastIdx]
	if h.size() > 0 {
		h.heapifyDown()
	}
	return v, true
}

func (h *MinHeap) Push(v int) {
	h.arr = append(h.arr, v)
	h.heapifyUp(len(h.arr) - 1)
}

func (h *MinHeap) heapifyUp(i int) {
	for h.hasParent(i) && h.arr[parentIdx(i)] > h.arr[i] {
		h.swap(i, parentIdx(i))
		i = parentIdx(i)
	}
}

func (h *MinHeap) heapifyDown() {
	i := 0
	for h.hasLeftChild(i) {
		smallChildIdx := leftChildIdx(i)
		if h.hasRightChild(i) && h.arr[rightChildIdx(i)] < h.arr[leftChildIdx(i)] {
			smallChildIdx = rightChildIdx(i)
		}
		if h.arr[i] <= h.arr[smallChildIdx] {
			break
		}
		h.swap(i, smallChildIdx)
		i = smallChildIdx
	}
}

func (h *MinHeap) hasLeftChild(i int) bool {
	return leftChildIdx(i) < h.size()
}

func (h *MinHeap) hasRightChild(i int) bool {
	return rightChildIdx(i) < h.size()
}

func (h *MinHeap) swap(i int, j int) {
	h.arr[i], h.arr[j] = h.arr[j], h.arr[i]
}

func (h *MinHeap) hasParent(i int) bool {
	return i > 0
}

func (h *MinHeap) size() int {
	return len(h.arr)
}

func parentIdx(i int) int {
	return (i - 1) / 2
}

func leftChildIdx(i int) int {
	return 2*i + 1
}

func rightChildIdx(i int) int {
	return 2*i + 2
}
