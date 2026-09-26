package com.training.slidingWindow;

/*
 * Given an array of positive integers nums and a positive integer target, return the minimal length of a subarray whose
 * sum is greater than or equal to target. If there is no such subarray, return 0 instead.
 * */
public class MinimumSizeSubArraySum {

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 2, 4, 3};
        int target = 70;
        System.out.println(minSubArrayLen(target, arr));
    }

    /*
     * target = 7, nums = [2,3,1,2,4,3]
     * output 2
     * Explanation: The subarray [4,3] has the minimal length under the problem constraint.
     * */
    private static int minSubArrayLen(int target, int[] nums) {
        int minLen = Integer.MAX_VALUE;
        int l = 0;
        int sum = 0;
        int window = 0;
        for (int r = 0; r < nums.length; r++) {
            sum += nums[r];
            while (l <= r && sum >= target) {
                window = r - l + 1;
                if (window < minLen) {
                    minLen = window;
                }
                sum -= nums[l];
                l++;
            }
        }
        if (minLen == Integer.MAX_VALUE) {
            minLen = 0;
        }
        return minLen;
    }
}
