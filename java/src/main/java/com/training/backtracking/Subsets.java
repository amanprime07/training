package com.training.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* 78. Subsets
* Given an integer array nums of unique elements, return all possible subsets (the power set).
* The solution set must not contain duplicate subsets. Return the solution in any order.
* Example 1:
    Input: nums = [1,2,3]
    Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
* Example 2:
    Input: nums = [0]
    Output: [[],[0]]
* */
public class Subsets {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        List<List<Integer>> res = subsets(arr);
        System.out.println(res);
    }

    private static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> sol = new ArrayList<>();
        subsets(ans, sol, 0, nums);
        return ans;
    }

    private static void subsets(List<List<Integer>> ans, List<Integer> sol, int n, int[] nums) {
        if (n == nums.length) {
            ans.add(new ArrayList<>(sol));
            return;
        }

        subsets(ans, sol, n + 1, nums);
        sol.add(nums[n]);
        subsets(ans, sol, n + 1, nums);
        sol.removeLast();
    }
}
