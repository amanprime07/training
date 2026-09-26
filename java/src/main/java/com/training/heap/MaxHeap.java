package com.training.heap;

import java.util.Arrays;

public class MaxHeap {

    public static void main(String[] args) {
        MaxHeap mh = new MaxHeap();
        mh.add(10);
        mh.add(20);
        mh.add(25);
        System.out.println(mh.peek());
        System.out.println(mh.pop());
        System.out.println(mh.peek());
        System.out.println(mh.pop());
        System.out.println(mh.peek());
        System.out.println(mh.pop());
        mh.add(1);
        System.out.println(mh.peek());
        System.out.println(mh.pop());
    }

    int capacity = 10;
    int size = 0;
    int[] arr = new int[capacity];


    public void add(int i) {
        ensureCapacity();
        arr[size] = i;
        size++;
        heapifyUp();
    }

    public int pop() {
        if (size == 0) {
            throw new IllegalArgumentException("heap is empty");
        }
        int i = arr[0];
        arr[0] = arr[size - 1];
        size--;
        heapifyDown();
        return i;
    }

    public int peek() {
        if (size == 0) {
            throw new IllegalArgumentException("heap is empty");
        }
        return arr[0];
    }

    private void heapifyDown() {
        int idx = 0;
        while (hasLeftChild(idx)) {
            int smallChildIdx = leftChildIdx(idx);
            if (hasRightChild(idx) && rightChild(idx) < leftChild(idx)) {
                smallChildIdx = rightChildIdx(idx);
            }

            if (arr[idx] > arr[smallChildIdx]) {
                break;
            } else {
                swap(idx, smallChildIdx);
            }
            idx = smallChildIdx;
        }
    }

    private int rightChild(int idx) {
        return arr[rightChildIdx(idx)];
    }

    private int leftChild(int idx) {
        return arr[leftChildIdx(idx)];
    }

    private int parent(int idx) {
        return arr[parentIdx(idx)];
    }

    private void heapifyUp() {
        int idx = size - 1;
        while (hasParent(idx) && arr[idx] > parent(idx)) {
            swap(idx, parentIdx(idx));
            idx = parentIdx(idx);
        }
    }

    private void ensureCapacity() {
        if (capacity == size) {
            arr = Arrays.copyOf(arr, capacity * 2);
            capacity *= 2;
        }
    }

    private int leftChildIdx(int idx) {
        return idx + 1;
    }

    private int rightChildIdx(int idx) {
        return idx + 1;
    }

    private int parentIdx(int idx) {
        return (idx - 2) / 2;
    }

    private boolean hasParent(int idx) {
        return parentIdx(idx) >= 0;
    }

    private boolean hasLeftChild(int idx) {
        return leftChildIdx(idx) < size;
    }

    private boolean hasRightChild(int idx) {
        return rightChildIdx(idx) < size;
    }

    private void swap(int s, int d) {
        int t = arr[s];
        arr[s] = arr[d];
        arr[d] = t;
    }
}
