package heap

type MinCHeap []int

func (h MinCHeap) Less(i int, j int) bool {
	return h[i] < h[j]
}

func (h MinCHeap) Len() int {
	return len(h)
}

func (h MinCHeap) Swap(i, j int) {
	h[i], h[j] = h[j], h[i]
}

func (h *MinCHeap) Push(x any) {
	*h = append(*h, x.(int))
}

func (h *MinCHeap) Pop() any {
	old := *h
	n := len(old)
	x := old[n-1]
	*h = old[0 : n-1]
	return x
}
