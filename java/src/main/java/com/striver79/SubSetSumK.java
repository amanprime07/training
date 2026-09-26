package com.striver79;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SubSetSumK {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4};
        System.out.println(subsetSumK(arr, 4));
        System.out.println(memoization(arr, 4));
        System.out.println(tabulation(arr, 4));
        System.out.println();
        memo.clear();
        System.out.println(subsetSumK(arr, 3));
        System.out.println(memoization(arr, 3));
        System.out.println(tabulation(arr, 3));
        System.out.println();
        memo.clear();
        arr = new int[]{2, 5, 1, 6, 7};
        System.out.println(subsetSumK(arr, 4));
        System.out.println(memoization(arr, 4));
        System.out.println(tabulation(arr, 4));
    }

    private static boolean subsetSumK(int[] arr, int target) {
        return subsetSumK(arr, target, 0);
    }

    private static boolean memoization(int[] arr, int target) {
        return memoization(arr, target, 0);
    }

    private record Pair(
            int i,
            int k
    ) {
    }

    private static boolean subsetSumK(int[] arr, int target, int pos) {
        if (target == 0) {
            return true;
        }
        if (pos >= arr.length) {
            return false;
        }
        int nt = target - arr[pos];

        return subsetSumK(arr, nt, pos + 1) || subsetSumK(arr, target, pos + 1);
    }

    private static Map<Pair, Boolean> memo = new HashMap<>();

    private static boolean memoization(int[] arr, int target, int i) {
        Pair p = new Pair(i, target);
        if (memo.containsKey(p)) {
            return memo.get(p);
        }
        if (target == 0) {
            return true;
        }
        if (i >= arr.length || arr[i] > target) {
            return false;
        }
        int nt = target - arr[i];
        boolean r = memoization(arr, nt, i + 1) || memoization(arr, target, i + 1);
        memo.put(p, r);
        return r;
    }


    //        1, 2, 3, 4
//    0 [[t, t, t, t]
//    1  [t, f, f, f]
//    2  [f, f, f, f]
//    3  [f, f, f, f]
//    4  [f, f, f, f]]
    private static boolean tabulation(int[] arr, int target) {
        int length = arr.length;
        boolean[][] dp = new boolean[target + 1][length];
        Arrays.fill(dp[0], true);
        if (arr[0] <= target) {
            dp[arr[0]][0] = true;
        }
        for (int i = 1; i <= target; i++) {
            for (int j = 1; j < length; j++) {
                int t = i - arr[j];
                boolean taken = false;
                if (t >= 0) {
                    taken = dp[t][j - 1];
                }
                dp[i][j] = dp[i][j - 1] || taken;
            }
        }
        return dp[target][length - 1];
    }

}
