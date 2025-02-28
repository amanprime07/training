package com.training.array.medium;

public class MaximumSumSubArray {

    public static void main(String[] args) {
//        int[] arr = { 1, 2, 7, -4, 3, 2, -10, 9, 1};
        int[] arr = {-1, -2, -3};
//        int[] arr = {1, -1, 1, -1, 3};
        long start = System.nanoTime();
        int[] pos = bruteForce(arr, arr.length);
        System.out.println("Time taken: " + (System.nanoTime() - start) / 1000);
        print(arr, pos[0], pos[1]);
        System.out.println();
        start = System.nanoTime();
        pos = kadaneApproach(arr, arr.length);
        System.out.println("Time taken: " + (System.nanoTime() - start) / 1000);
        print(arr, pos[0], pos[1]);
        System.out.println();
        start = System.nanoTime();
        pos = kadaneApproach2(arr, arr.length);
        System.out.println("Time taken: " + (System.nanoTime() - start) / 1000);
        print(arr, pos[0], pos[1]);
    }

    private static void print(int[] arr, int start, int end) {
        for (int i = start; i <= end; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private static int[] bruteForce(int[] arr, int size) {
        int[] pos = {0, 0};
        int maxSum = 0;
        for (int i = 0; i < size; i++) {
            int sum = 0;
            for (int j = i; j < size; j++) {
                sum += arr[j];
                if (maxSum < sum) {
                    maxSum = sum;
                    pos[0] = i;
                    pos[1] = j;
                }
            }
        }
        return pos;
    }

    private static int[] kadaneApproach(int[] arr, int size) {
        int start = 0;
        int end = 0;
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < size; i++) {
            sum += arr[i];
            if (maxSum < sum) {
                maxSum = sum;
                end = i;
            }
            if (sum < 0) {
                sum = 0;
                start = i;
            }
        }
        return new int[]{start, end};
    }

    private static int[] kadaneApproach2(int[] arr, int size) {
        int maxSum = Integer.MIN_VALUE;
        int res = Integer.MIN_VALUE;
        int sum = 0;
        int start = 0, end = 0;
        for (int i = 0; i < size; i++) {
            sum += arr[i];
            if (maxSum < sum) {
                maxSum = sum;
            } else if (arr[i] > sum) {
                sum = arr[i];
                start = i;
            }
            if (res < maxSum) {
                res = maxSum;
                end = i;
            }
        }
        return new int[]{start, end};
    }
}
