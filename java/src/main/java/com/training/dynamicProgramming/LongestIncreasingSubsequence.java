package com.training.dynamicProgramming;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        int[] arr = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(longestIncreasingSubsequence(arr));
        arr = new int[]{0, 1, 0, 3, 2, 3};
        System.out.println(longestIncreasingSubsequence(arr));
    }

    private static int longestIncreasingSubsequence(int[] arr) {
        int length = arr.length;
        int[] dp = new int[length];
        Arrays.fill(dp, 1);
        int max = 0;

        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                    max = Math.max(max, dp[i]);
                }
            }
        }
        return max;
    }
}
