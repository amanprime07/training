package com.training.array.easy;

public class IsSorted {

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 4, 5};
        long start = System.nanoTime();
        boolean sorted = bruteForce(arr);
        long timeTaken = System.nanoTime() - start;
        System.out.println("timeTaken " + timeTaken);
        System.out.println(sorted);
        start = System.nanoTime();
        sorted = betterApproach(arr);
        timeTaken = System.nanoTime() - start;
        System.out.println("timeTaken " + timeTaken);
        System.out.println(sorted);
        start = System.nanoTime();
        sorted = optimized(arr);
        timeTaken = System.nanoTime() - start;
        System.out.println(sorted);
        System.out.println("timeTaken " + timeTaken);
    }

    private static boolean bruteForce(int[] arr) {
        boolean isSorted = true;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    isSorted = false;
                    break;
                }
            }
        }
        return isSorted;
    }

    private static boolean betterApproach(int[] arr) {
        boolean isSorted = true;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                isSorted = false;
                break;
            }
        }
        return isSorted;
    }

    private static boolean optimized(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        boolean isSorted = true;
        while (start < end) {
            if (arr[start] > arr[start + 1] || arr[end] < arr[end - 1]) {
                isSorted = false;
                break;
            }
            start++;
            end--;
        }
        return isSorted;
    }
}
