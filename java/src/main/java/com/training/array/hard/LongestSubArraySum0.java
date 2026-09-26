package com.training.array.hard;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArraySum0 {

    public static void main(String[] args) {
        int[] arr = {1, 2, -2, 4, -4};
        System.out.println((longestSubArrayWithSumK(arr, 0)));

    }


    private static int longestSubArrayWithSumK(int[] arr, int k) {
        int maxLen = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum == k) {
                maxLen = Math.max(maxLen, i + 1);
            }
            int rem = sum - k;
            if (map.containsKey(rem)) {
                int x = map.get(rem);
                maxLen = Math.max(maxLen, i - x);
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return maxLen;
    }

    private static int[] longestSubArraySum0(int[] arr) {
        int sum = 0;
        int maxLen = 0;
        int[] pos = {0, 0};
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum == 0) {
                maxLen = Math.max(maxLen, i + 1);
                pos[i] = i;
            }
            int rem = -sum;
            if (map.containsKey(rem)) {
                int x = map.get(rem);
                if (maxLen < i - x) {
                    maxLen = i - x;
                    pos[0] = x;
                    pos[1] = i;
                }
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        System.out.println(maxLen);
        return pos;
    }
}
