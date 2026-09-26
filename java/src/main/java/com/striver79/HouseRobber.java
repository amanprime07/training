package com.striver79;

import java.util.HashMap;
import java.util.Map;

public class HouseRobber {

    private static Map<Integer, Integer> cache = new HashMap<>();

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 1};
        System.out.println(rob(arr));
        System.out.println(topDownDp(arr));
        System.out.println(memoization(arr));
        System.out.println(topDown(arr));

        cache.clear();
        arr = new int[]{2, 7, 9, 3, 1};
        System.out.println(rob(arr));
        System.out.println(memoization(arr));
        System.out.println(topDownDp(arr));
        System.out.println(topDown(arr));


    }

    private static int rob(int[] nums) {
        return rob(nums, nums.length - 1);
    }

    private static int memoization(int[] nums) {
        return memoization(nums, nums.length - 1);
    }

    private static int rob(int[] nums, int i) {
        if (i == 0) {
            return nums[0];
        }

        if (i == 1) {
            return Math.max(nums[0], nums[1]);
        }

        int oneBack = rob(nums, i - 1);
        int twoBack = rob(nums, i - 2);

        return Math.max(oneBack, twoBack + nums[i]);
    }

    private static int memoization(int[] nums, int i) {
        if (i == 0) {
            return nums[0];
        }

        if (i == 1) {
            return Math.max(nums[0], nums[1]);
        }
        if (cache.containsKey(i)) {
            return cache.get(i);
        }
        int v = Math.max(memoization(nums, i - 1), nums[i] + memoization(nums, i - 2));
        cache.put(i, v);
        return v;
    }

    private static int topDownDp(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        if (n == 2) {
            return Math.max(nums[1], nums[0]);
        }
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[1], nums[0]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
        }

        return dp[n - 1];
    }

    private static int topDown(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        if (n == 2) {
            return Math.max(nums[1], nums[0]);
        }
        int oneBack = Math.max(nums[1], nums[0]);
        int twoBack = nums[0];

        for (int i = 2; i < n; i++) {
            int t = Math.max(nums[i] + twoBack, oneBack);
            twoBack = oneBack;
            oneBack = t;
        }

        return oneBack;
    }
}
