package com.training.heap;

import java.util.PriorityQueue;
import java.util.Queue;

/*
* 215. Kth Largest Element in an Array
Given an integer array nums and an integer k, return the kth largest element in the array.

Note that it is the kth largest element in the sorted order, not the kth distinct element.

Can you solve it without sorting?
* */
public class KthLargestElement {

    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 5, 6, 4};
        int k = 2;
        System.out.println(kLargest(arr, k));

        k = 4;
        System.out.println(kLargest(arr, k));
    }

    private static int kLargest(int[] nums, int k) {
        Queue<Integer> q = new PriorityQueue<>();
        for (int i : nums) {
            q.add(i);
            if (q.size() > k) {
                q.poll();
            }
        }
        return q.peek();
    }
}
