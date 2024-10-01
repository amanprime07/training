package com.training.array.easy;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArraySumK {

    public static void main(String[] args) {
        int[] arr = {2, 2, 4, 1, -1, 1, 2};
        long start = System.nanoTime();
        int n = prefixSumApproach(arr, 0);
        System.out.println("time take: " + (System.nanoTime() - start) / 1000);
        System.out.println(n);
    }

    private static int bruteForce(int[] arr, int k) {
        int maxLen = 0;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if (sum == k) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }
        return maxLen;
    }

    /*
     * 2, 2, 4, 1, -1, 1, 2
     * 2, 4
     * */
    private static int prefixSumApproach(int[] arr, int k) {
        int maxLen = 0;
        if (arr.length == 0) {
            return maxLen;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum == k) {
                maxLen = Math.max(maxLen, i + 1);
            }
            int rem = sum - k;
            if (map.containsKey(rem)) {
                int j = map.get(rem);
                maxLen = Math.max(maxLen, i - j);
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return maxLen;
    }
}
