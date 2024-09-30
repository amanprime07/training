package com.training.array.medium;

import java.util.HashMap;
import java.util.Map;

public class MaximumSubArraySum {

    public static void main(String[] args) {
        int[] arr = {-5, 1, 2, -1, -1, 1, -10};
        long start = System.nanoTime();
        int sum = bruteForce(arr, arr.length);
        System.out.println("Time taken: " + (System.nanoTime() - start) / 1000);
        System.out.println(sum);
        start = System.nanoTime();
        sum = maxSubArraySum(arr, arr.length);
        System.out.println("Time taken: " + (System.nanoTime() - start) / 1000);
        System.out.println(sum);
    }

    private static int bruteForce(int[] arr, int size) {
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < size; i++) {
            int sum = 0;
            for (int j = i; j < size; j++) {
                sum += arr[j];
                if (sum >= maxSum) {
                    maxSum = sum;
                }
            }
        }
        return maxSum;
    }

    /*
    -5,1,2,-1,-1,1,-10
    * */
    private static int maxSubArraySum(int[] arr, int size) {
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += arr[i];
            if (maxSum < sum) {
                maxSum = sum;
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        return maxSum;
    }
}
