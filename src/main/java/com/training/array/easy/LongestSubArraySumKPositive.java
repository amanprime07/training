package com.training.array.easy;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArraySumKPositive {
    public static void main(String[] args) {
//        int[] arr = {2, 2, 4, 1, 2};
//        int[] arr = {1, 2, 3, 1, 1, 1};
//        int[] arr = {1, 2, 1, 3};
        int[]arr = {-1, 1, 1};
        long start = System.nanoTime();
        int n = slidingWindowApproach(arr, 1);
        System.out.println("time take: " + (System.nanoTime() - start) / 1000);
        System.out.println(n);
    }

    private static int bruteForce(int[] arr, int k) {
        int maxLen = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if (sum == k) {
                    maxLen = Math.max(maxLen, j - i + 1);
                    break;
                }
            }
        }
        return maxLen;
    }

    private static int prefixSumApproach(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int maxLen = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum == k) {
                maxLen = Math.max(maxLen, i + 1);
            }
            int rem = sum - k;
            if (map.containsKey(rem)) {
                int idx = map.get(rem);
                maxLen = Math.max(maxLen, i - idx);
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return maxLen;
    }

    public static int slidingWindowApproach(int []arr, long k) {
        // Write your code here
        int left =0, right=0;
        long sum = 0;
        int maxLen = Integer.MIN_VALUE;
        while(right<arr.length){
            sum+=arr[right];
            while(left<=right && sum>k){
                sum-=arr[left];
                left++;
            }
            if(sum==k){
                maxLen = Math.max(maxLen, right-left+1);
            }
            right++;
        }
        return maxLen;
    }
}
