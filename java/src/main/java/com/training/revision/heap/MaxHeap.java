package com.training.revision.heap;

import java.util.Arrays;

public class MaxHeap {

    private int capacity;
    private int size;
    private int[] arr;

    public MaxHeap() {
        this.capacity = 10;
        arr = new int[capacity];
    }

    public static void main(String[] args) {
        MaxHeap mh = new MaxHeap();
        mh.add(1);
        mh.add(2);
        mh.add(12);
        int size = mh.size;
        for (int i = 0; i < size; i++) {
            System.out.println(mh.pop());
        }
    }

    public void add(int val) {
        ensureCapacity();
        arr[size] = val;
        size++;
        heapifyUp();
    }

    private void heapifyUp() {
        int i = size - 1;
        while (hasParent(i) && parent(i) < arr[i]) {
            swap(i, parentIdx(i));
            i = parentIdx(i);
        }
    }

    private void heapifyDown() {
        int i = 0;
        while (hasLeftChild(i)) {
            int bigChildIdx = leftChildIdx(i);
            if (hasRightChild(i) && arr[bigChildIdx] < rightChildIdx(i)) {
                bigChildIdx = rightChildIdx(i);
            }
            if (arr[i] > arr[bigChildIdx]) {
                break;
            } else {
                swap(i, bigChildIdx);
            }
            i = bigChildIdx;
        }

    }

    private void swap(int s, int d) {
        int temp = arr[s];
        arr[s] = arr[d];
        arr[d] = temp;
    }

    public int pop() {
        if (size == 0) {
            throw new IllegalArgumentException("heap is empty");
        }
        int temp = arr[0];
        arr[0] = arr[size - 1];
        size--;
        heapifyDown();
        return temp;
    }

    public int peek() {
        if (size == 0) {
            throw new IllegalArgumentException("heap is empty");
        }
        return arr[0];
    }

    private void ensureCapacity() {
        if (capacity == size) {
            arr = Arrays.copyOf(arr, capacity * 2);
            capacity = 2 * capacity;
        }
    }

    private int parent(int i) {
        return arr[parentIdx(i)];
    }

    private int rightChild(int i) {
        return arr[rightChildIdx(i)];
    }

    private int leftChild(int i) {
        return arr[leftChildIdx(i)];
    }

    private int parentIdx(int i) {
        return (i - 2) / 2;
    }

    private int leftChildIdx(int i) {
        return 2 * i + 1;
    }

    private int rightChildIdx(int i) {
        return 2 * i + 2;
    }

    private boolean hasParent(int i) {
        return parentIdx(i) >= 0;
    }

    private boolean hasLeftChild(int i) {
        return leftChildIdx(i) < size;
    }

    private boolean hasRightChild(int i) {
        return rightChildIdx(i) < size;
    }

}
