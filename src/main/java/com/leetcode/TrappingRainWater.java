package com.leetcode;

/*
 * 42. Trapping Rain Water
 * */
public class TrappingRainWater {

    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(arr));
        arr = new int[]{4, 2, 0, 3, 2, 5};
        System.out.println(trap(arr));
        arr = new int[]{1, 2, 3, 4, 5};
        System.out.println(trap(arr));
    }

    private static int trap(int[] height) {
        int trap = 0;
        int n = height.length;
        if (n <= 1) {
            return trap;
        }
        int left = 0;
        int right = n - 1;
        int lMax = 0, rMax = 0;

        while (left < right) {
            lMax = Math.max(lMax, height[left]);
            rMax = Math.max(rMax, height[right]);
            int smallOne = Math.min(lMax, rMax);
            if (height[left] <= height[right]) {
                trap += smallOne - height[left];
                left++;
            } else {
                trap += smallOne - height[right];
                right--;
            }
        }
        return trap;
    }
}
