package com.training.array.easy;

public class MaximumConsecutiveNumber {

    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 1, 3, 4, 5};
        System.out.println(maxConsecutiveNumber(arr, arr.length, 5));
    }

    private static int maxConsecutiveNumber(int[] arr, int size, int n) {
        int count = 0;
        int maxCount = Integer.MIN_VALUE;
        for (int i = 0; i < size; i++) {
            if (arr[i] == n) {
                count++;
            } else {
                count = 0;
            }
            maxCount = Math.max(count, maxCount);
        }
        return maxCount;
    }
}
