package com.training.dynamicProgramming;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class UniquePaths {

    private static Map<Pair, Integer> memo = new HashMap<>();

    public static void main(String[] args) {
        int m = 3, n = 7;
        System.out.println(bruteForce(m, n));
        System.out.println(topDown(m, n));
        System.out.println(tabulation(m, n));

        memo.clear();
        m = 3;
        n = 2;
        System.out.println(bruteForce(m, n));
        System.out.println(topDown(m, n));
        System.out.println(tabulation(m, n));
    }

    private static int bruteForce(int m, int n) {
        return bruteForceHelper(m - 1, n - 1); // 0 indexed matrix
    }

    private static int bruteForceHelper(int m, int n) {
        if (m < 0 || n < 0) {
            return 0;
        }

        if (m == 0 && n == 0) {
            return 1;
        }

        return bruteForceHelper(m, n - 1) + bruteForceHelper(m - 1, n);
    }

    private static int topDown(int m, int n) {
        return topDownHelper(m - 1, n - 1);
    }

    private static int topDownHelper(int m, int n) {
        if (m == 0 && n == 0) {
            return 1;
        }

        if (m < 0 || n < 0) {
            return 0;
        }
        Pair p = new Pair(m, n);
        if (memo.containsKey(p)) {
            return memo.get(p);
        }
        int v = topDownHelper(m - 1, n) + topDownHelper(m, n - 1);
        memo.put(p, v);
        return v;
    }

    private static int tabulation(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                int v = 0;
                if (i > 0) {
                    v = v + dp[i - 1][j];
                }
                if (j > 0) {
                    v = v + dp[i][j - 1];
                }
                dp[i][j] = v;
            }
        }
        return dp[m - 1][n - 1];
    }

    private static class Pair {
        int r;
        int c;

        Pair(int i, int j) {
            r = i;
            c = j;
        }

        @Override
        public String toString() {
            return
                     r +
                            ", " + c;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return r == pair.r && c == pair.c;
        }

        @Override
        public int hashCode() {
            return Objects.hash(r, c);
        }
    }
}
