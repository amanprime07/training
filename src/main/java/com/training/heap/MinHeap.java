package com.training.heap;

import java.util.Arrays;

public class MinHeap {

    private int capacity = 10;
    private int[] arr = new int[capacity];
    private int size = 0;

    public void add(int x) {
        ensureCapacity();
        arr[size] = x;
        size++;
        heapifyUp();
    }

    public int peek() {
        if (size == 0) {
            throw new IllegalArgumentException("Heap is empty");
        }
        return arr[0];
    }

    public int pop() {
        if (size == 0) {
            throw new IllegalArgumentException("Heap is empty");
        }
        int i = arr[0];
        arr[0] = arr[size - 1];
        size--;
        heapifyDown();
        return i;
    }

    private void heapifyUp() {
        int idx = size - 1;
        while (hasParent(idx) && parent(idx) > arr[idx]) {
            swap(parentIdx(idx), idx);
            idx = parentIdx(idx);
        }
    }

    private void heapifyDown() {
        int idx = 0;
        while (hasLeftChild(idx)) {
            int smallChildIdx = leftChildIdx(idx);
            if (hasRightChild(idx) && arr[smallChildIdx] > arr[rightChildIdx(idx)]) {
                smallChildIdx = rightChildIdx(idx);
            }

            if (arr[idx] < arr[smallChildIdx]) {
                break;
            } else {
                swap(idx, smallChildIdx);
            }
            idx = smallChildIdx;
        }
    }

    private void swap(int s, int d) {
        int temp = arr[s];
        arr[s] = arr[d];
        arr[d] = temp;
    }

    private void ensureCapacity() {
        if (capacity == size) {
            arr = Arrays.copyOf(arr, capacity * 2);
            capacity = capacity * 2;
        }
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

    private int parent(int idx) {
        return arr[parentIdx(idx)];
    }

    private int leftChild(int idx) {
        return arr[leftChildIdx(idx)];
    }

    private int rightChild(int idx) {
        return arr[rightChildIdx(idx)];
    }

    private int parentIdx(int idx) {
        return (idx - 2) / 2;
    }

    private int leftChildIdx(int idx) {
        return (idx + 1);
    }

    private int rightChildIdx(int idx) {
        return idx + 2;
    }


    public static void main(String[] args) {
        MinHeap mh = new MinHeap();
        mh.add(10);
        mh.add(20);
        mh.add(25);
        System.out.println(mh.peek());
        System.out.println(mh.pop());
        System.out.println(mh.peek());
        System.out.println(mh.pop());
        System.out.println(mh.peek());
        System.out.println(mh.pop());
        mh.add(30);
        mh.add(10);
        mh.add(20);
        mh.add(25);
        mh.add(10);
        mh.add(20);
        mh.add(25);
        System.out.println();
        System.out.println(mh.peek());
        System.out.println(mh.pop());
        System.out.println(mh.peek());
        System.out.println(mh.pop());
        System.out.println(mh.pop());

    }
}
