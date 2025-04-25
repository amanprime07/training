package com.training.dynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class HouseRobber {

    private static Map<Integer, Integer> memo = new HashMap<>();

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 1};
        System.out.println(rob(arr));
        System.out.println(memoization(arr));
        System.out.println(tabulation(arr));
        System.out.println(bottomUp(arr));

        arr = new int[]{2, 7, 9, 3, 1};
        System.out.println(rob(arr));
        System.out.println(memoization(arr));
        System.out.println(tabulation(arr));
        System.out.println(bottomUp(arr));

        arr = new int[]{1};
        System.out.println(rob(arr));
        System.out.println(memoization(arr));
        System.out.println(tabulation(arr));
        System.out.println(bottomUp(arr));

    }

    private static int rob(int[] nums) {
        return rob(nums, nums.length - 1);
    }

    private static int rob(int[] nums, int i) {
        if (i == 0) {
            return nums[0];
        }

        if (i == 1) {
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(rob(nums, i - 1), nums[i] + rob(nums, i - 2));
    }

    private static int memoization(int[] arr) {
        return memoization(arr, arr.length - 1);
    }

    private static int memoization(int[] nums, int i) {
        if (i == 0) {
            return nums[0];
        }

        if (i == 1) {
            return Math.max(nums[0], nums[1]);
        }
        if (memo.containsKey(i)) {
            return memo.get(i);
        }
        int v = Math.max(rob(nums, i - 1), nums[i] + rob(nums, i - 2));
        memo.put(i, v);
        return v;
    }

    // bottom up with O(n) space
    private static int tabulation(int[] nums) {
        int l = nums.length;
        if (l == 1) {
            return nums[0];
        }
        if (l == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] dp = new int[l];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < l; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
        }
        return dp[l - 1];
    }

    // Bottom up O(1) space
    private static int bottomUp(int[] nums) {
        int l = nums.length;
        if (l == 1) {
            return nums[0];
        }
        if (l == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int twoBack = nums[0];
        int oneBack = Math.max(nums[0], nums[1]);
        int t = 0;
        for (int i = 2; i < l; i++) {
            t = Math.max(oneBack, nums[i] + twoBack);
            twoBack = oneBack;
            oneBack = t;
        }
        return oneBack;
    }
}
