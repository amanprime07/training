package com.training.array.medium;

/*
* You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.
Return true if you can reach the last index, or false otherwise.
* */
public class JumpGame {

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 1, 4};
        System.out.println(canJump(arr));
    }

    /*
     * Input: nums = [2,3,1,1,4]
     * Output: true
     * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
     * */
    private static boolean canJump(int[] nums) {
        int n = nums.length;
        int goal = n - 1;
        for (int i = n - 2; i >= 0; i--) {
            if (goal - i <= nums[i]) {
                goal = i;
            }
        }
        return goal == 0;
    }
}
