package com.training.dynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class LongestCommonSubsequence {

    public static void main(String[] args) {
        String t1 = "abcde", t2 = "ace";
        long start = System.nanoTime();
        int ans = bruteForce(t1, t2);
        long timeTaken = System.nanoTime() - start;
        System.out.println(ans + " in " + timeTaken);

        start = System.nanoTime();
        ans = topDownDp(t1, t2);
        timeTaken = System.nanoTime() - start;
        System.out.println(ans + " in " + timeTaken);

        start = System.nanoTime();
        ans = bottomUpDp(t1, t2);
        timeTaken = System.nanoTime() - start;
        System.out.println(ans + " in " + timeTaken);
    }


    private static int bruteForce(String text1, String text2) {
        return bruteForce(text1, 0, text2, 0);
    }

    private static int bruteForce(String text1, int i, String text2, int j) {
        if (i >= text1.length() || j >= text2.length()) {
            return 0;
        }

        if (text1.charAt(i) == text2.charAt(j)) {
            return 1 + bruteForce(text1, i + 1, text2, j + 1);
        }

        return Math.max(bruteForce(text1, i, text2, j + 1), bruteForce(text1, i + 1, text2, j));
    }

    private static Map<Pair, Integer> memo = new HashMap<>();

    private static int topDownDp(String text1, String text2) {
        return topDownDp(text1, 0, text2, 0);
    }


    private static int topDownDp(String text1, int i, String text2, int j) {
        Pair p = new Pair(i, j);
        if (memo.containsKey(p)) {
            return memo.get(p);
        }
        if (i >= text1.length() || j >= text2.length()) {
            return 0;
        }

        if (text1.charAt(i) == text2.charAt(j)) {
            int v = 1 + topDownDp(text1, i + 1, text2, j + 1);
            memo.put(p, v);
            return v;
        }

        int v = Math.max(topDownDp(text1, i + 1, text2, j), topDownDp(text1, i, text2, j + 1));
        memo.put(p, v);
        return v;


    }

    private record Pair(int i, int j) {
    }

    /*
     * T1 = "abcde"
     * T2 = "ace"
     *
     * */
    private static int bottomUpDp(String text1, String text2) {
        int l1 = text1.length();
        int l2 = text2.length();
        int[][] dp = new int[l1 + 1][l2 + 1];
//        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < l1 + 1; i++) {
            for (int j = 1; j < l2 + 1; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
//                    sb.append(text1.charAt(i - 1));
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
//        System.out.println(sb);
        return dp[l1][l2];
    }
}
