package com.training.slidingWindow;

public class MaxConsecutiveOnes {
    public static void main(String[] args) {

        int[] arr = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        System.out.println(longestOnes(arr, 2));

        int[] arr1 = {0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1};
        System.out.println(longestOnes(arr1, 3));

    }

    /*
     * [1,1,1,0,0,0,1,1,1,1,0], k = 2
     *
     * [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
     *
     * */
    private static int longestOnes(int[] nums, int k) {
        int numZero = 0;
        int l = 0;
        int maxWindow = 0;
        int window = 0;
        for (int r = 0; r < nums.length; r++) {
            if (nums[r] == 0) {
                numZero++;
            }
            while (l <= r && numZero > k) {
                if (nums[l] == 0) {
                    numZero--;
                }
                l++;
            }
            window = r - l + 1;
            if (window > maxWindow) {
                maxWindow = window;
            }
        }
        return maxWindow;
    }

}
