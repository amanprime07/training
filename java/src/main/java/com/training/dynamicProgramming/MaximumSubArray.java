package com.training.dynamicProgramming;

public class MaximumSubArray {

    public static void main(String[] args) {
        int[] arr = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(bruteForce(arr));
        System.out.println(kadaneAlgo(arr));
        arr = new int[]{1};
        System.out.println(bruteForce(arr));
        System.out.println(kadaneAlgo(arr));
        arr = new int[]{};
        System.out.println(bruteForce(arr));
        System.out.println(kadaneAlgo(arr));
    }

    private static int bruteForce(int[] arr) {
        int sum = 0;
        return bruteForce(arr, arr.length - 1, sum);
    }

    private static int bruteForce(int[] arr, int i, int sum) {
        if (i < 0) {
            return 0;
        }
        int s = Math.max(0, arr[i] + sum);
        int t = bruteForce(arr, i - 1, s);

        return Math.max(t, s);
    }

    private static int kadaneAlgo(int[] arr) {
        int sum = 0;
        int maxSum = 0;
        for (int i : arr) {
            if (sum < 0) {
                sum = 0;
            }
            sum += i;
            if (maxSum < sum) {
                maxSum = sum;
            }
        }
        return maxSum;
    }

}
