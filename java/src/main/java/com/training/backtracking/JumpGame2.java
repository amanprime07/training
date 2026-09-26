package com.training.backtracking;

import java.util.ArrayList;
import java.util.List;

/*
* 45. Jump Game II
You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].
Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at nums[i], you can jump to any nums[i + j] where:
0 <= j <= nums[i] and
i + j < n
Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated such that you can reach nums[n - 1].

Example 1:
    Input: nums = [2,3,1,1,4]
    Output: 2
    Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:
    Input: nums = [2,3,0,1,4]
    Output: 2
* */
public class JumpGame2 {
    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 1, 4};
        int minJump = minJump(arr);
        System.out.println(minJump);
        System.out.println(minJumpRegion(arr));
    }

    private static int minJump(int[] arr) {
        List<Integer> ans = new ArrayList<>();
        ans.add(Integer.MAX_VALUE);
        minJump(ans, 0, 0, arr);
        return ans.getFirst();
    }

    private static void minJump(List<Integer> ans, int pos, int jumps, int[] arr) {
        if (pos == arr.length - 1) {
            if (jumps < ans.getFirst()) {
                ans.set(0, jumps);
            }
            return;
        }

        int maxAllowed = Math.min(pos + arr[pos], arr.length - 1);

        for (int i = maxAllowed; i > pos; i--) {
            minJump(ans, i, jumps + 1, arr);
        }
    }

    private static int minJumpRegion(int[] arr) {
        int small = 0;
        int far = 0;
        int end = 0;
        for (int i = 0; i <= arr.length - 2; i++) {
            far = Math.max(far, i + arr[i]);
            if (i == end) {
                small++;
                end = far;
            }
        }
        return small;
    }
}
