package com.training.dynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class ClimbingStairs {

    private static Map<Integer, Integer> memo = new HashMap<>();

    public static void main(String[] args) {
        int n = 5;
        System.out.println(bruteForce(n)); // 1,2,3,5,8
        System.out.println(topDownDp(n));
        System.out.println(bottomUpDp(n));
        System.out.println(bottomUp(n));
        System.out.println(bruteForce(3)); // 1,2,3
        System.out.println(topDownDp(3));
        System.out.println(bottomUpDp(3));
        System.out.println(bottomUp(3));
    }

    private static int bruteForce(int n) {
        if (n <= 2) {
            return n;
        }
        return bruteForce(n - 1) + bruteForce(n - 2);
    }

    // tabulation
    private static int bottomUpDp(int n) {
        if (n <= 2) {
            return n;
        }

        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n - 1];
    }

    // memoization
    private static int topDownDp(int n) {
        if (n <= 2) {
            return n;
        }

        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        int v = topDownDp(n - 1) + topDownDp(n - 2);
        memo.put(n, v);
        return v;
    }

    private static int bottomUp(int n) {
        if (n <= 2) {
            return n;
        }

        int oneBack = 2;
        int twoBack = 1;
        int t;
        for (int i = 2; i < n; i++) {
            t = oneBack + twoBack;
            twoBack = oneBack;
            oneBack = t;
        }

        return oneBack;
    }
}
