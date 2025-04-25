package com.training.dynamicProgramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CoinChange {

    private static Map<Integer, Integer> memo = new HashMap<>();

    public static void main(String[] args) {
        int[] coins = new int[]{1, 2, 5};
        System.out.println(bruteForce(coins, 11));
        System.out.println(topDown(coins, 11));
        System.out.println(tabulation(coins, 11));
        coins = new int[]{2};
        memo.clear(); // clear cache for new test
        System.out.println(bruteForce(coins, 3));
        System.out.println(topDown(coins, 3));
        System.out.println(tabulation(coins, 3));
    }

    private static int bruteForce(int[] coins, int target) {
        Arrays.sort(coins);
        int i = bruteForceHelper(coins, target);
        return i == 10001 ? -1 : i;
    }

    private static int bruteForceHelper(int[] coins, int target) {
        if (target == 0) {
            return 0;
        }
        int min = 10001;
        for (int c : coins) {
            int diff = target - c;
            if (diff < 0) {
                break;
            }
            min = Math.min(min, 1 + topDownDp(coins, diff));
        }
        return min;
    }

    private static int topDown(int[] coins, int target) {
        Arrays.sort(coins);
        int i = topDownDp(coins, target);
        return i == 10001 ? -1 : i;
    }

    private static int topDownDp(int[] coins, int target) {
        if (target == 0) {
            return 0;
        }

        if (memo.containsKey(target)) {
            return memo.get(target);
        }
        int min = 10001;
        for (int c : coins) {
            int diff = target - c;
            if (diff < 0) {
                break;
            }
            min = Math.min(min, 1 + topDownDp(coins, diff));
        }
        memo.put(target, min);
        return min;
    }

    private static int tabulation(int[] coins, int target) {
        Arrays.sort(coins);
        int[] dp = new int[target + 1];
        dp[0] = 0;
        for (int i = 1; i <= target; i++) {
            int min = Integer.MAX_VALUE;
            for (int c : coins) {
                int diff = i - c;
                if (diff < 0) {
                    break;
                }
                min = Math.min(min, 1 + dp[diff]);
            }
            dp[i] = min;

        }
        if (dp[target] == Integer.MIN_VALUE) {
            return -1;
        }
        return dp[target];
    }
}
