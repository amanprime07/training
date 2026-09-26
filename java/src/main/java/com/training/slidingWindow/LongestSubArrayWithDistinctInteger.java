package com.training.slidingWindow;

import java.util.HashSet;
import java.util.Set;

public class LongestSubArrayWithDistinctInteger {

    public static void main(String[] args) {
        int[] arr= {2, 1, 2};
        System.out.println(longestArray(arr, 2));
        int[]arr1 = {3, 1, 2, 2, 2, 2};
        System.out.println(longestArray(arr1, 2));
        System.out.println(longestArray(arr1, 3));
    }

    /*
     * Input: arr[]= [2, 1, 2]
     * Output: 3
     *
     * Input: arr[] = [3, 1, 2, 2, 2, 2]
     * Output: 5
     * */
    private static int longestArray(int[] arr, int target) {
        int maxLen = 0;
        int window = 0;
        int l = 0;
        Set<Integer> set = new HashSet<>();
        for (int r = 0; r < arr.length; r++) {
            int i = arr[r];
            while (l <= r && set.size() > target) {
                set.remove(arr[l]);
                l++;
            }
            set.add(i);
            window = r - l + 1;
            if (maxLen < window) {
                maxLen = window;
            }
        }
        return maxLen;
    }
}
