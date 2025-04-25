package com.training.dynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class MinCostClimbingStairs {

    private static Map<Integer, Integer> memo = new HashMap<>();

    public static void main(String[] args) {
        int[] arr = new int[]{10, 15, 20};
        System.out.println(bruteForce(arr));
        System.out.println(memoization(arr));
        System.out.println(tabulation(arr));
        System.out.println(bottomUp(arr));

        memo.clear(); // to clear cache for test case
        arr = new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(bruteForce(arr));
        System.out.println(memoization(arr));
        System.out.println(tabulation(arr));
        System.out.println(bottomUp(arr));
    }

    private static int bottomUp(int[] cost) {
        int l = cost.length;
        if (l < 2) {
            return 0;
        }

        int oneBack = 0;
        int twoBack = 0;
        for (int i = 2; i <= cost.length; i++) {
            int t = Math.min(cost[i - 2] + twoBack, cost[i - 1] + oneBack);
            twoBack = oneBack;
            oneBack = t;
        }
        return oneBack;
    }

    private static int tabulation(int[] cost) {
        if (cost.length < 2) {
            return 0;
        }
        int[] dp = new int[cost.length + 1];
        for (int i = 2; i <= cost.length; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }

        return dp[cost.length];
    }

    private static int memoization(int[] cost) {
        return memoization(cost, cost.length);
    }

    private static int bruteForce(int[] cost) {
        return bruteForce(cost, cost.length);
    }

    private static int bruteForce(int[] cost, int i) {
        if (i < 2) {
            return 0;
        }

        return Math.min(cost[i - 2] + bruteForce(cost, i - 2), cost[i - 1] + bruteForce(cost, i - 1));
    }

    private static int memoization(int[] cost, int i) {
        if (i < 2) {
            return 0;
        }
        if (memo.containsKey(i)) {
            return memo.get(i);
        }
        int v = Math.min(cost[i - 2] + memoization(cost, i - 2), cost[i - 1] + memoization(cost, i - 1));
        memo.put(i, v);
        return v;
    }
}
