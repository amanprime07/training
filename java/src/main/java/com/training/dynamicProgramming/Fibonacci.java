package com.training.dynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

    private static Map<Integer, Integer> memo = new HashMap<>();

    public static void main(String[] args) {
        int n = 15;
        iterative(n);
        System.out.println();
        printWithRecursion(n);
        System.out.println();
        System.out.println(memoization(n - 1));
        System.out.println(tabulation(n));
    }

    private static void iterative(int n) {
        int prev = 0;
        int current = 1;
        int temp;
        System.out.print(prev + " ");
        System.out.print(current + " ");
        for (int i = 2; i < n; i++) {
            temp = prev + current;
            prev = current;
            current = temp;
            System.out.print(current + " ");
        }
    }

    private static void printWithRecursion(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(recursive(i) + " ");
        }
    }

    private static int recursive(int n) {
        if (n <= 1) {
            return n;
        }
        return recursive(n - 1) + recursive(n - 2);
    }

    private static int memoization(int n) {
        if (n <= 1) {
            return n;
        }
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        int v = memoization(n - 1) + memoization(n - 2);
        memo.put(n, v);
        return v;
    }

    private static int tabulation(int n) {
        if (n <= 1) {
            return n;
        }
        int[] dp = new int[n];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n - 1];
    }
}
