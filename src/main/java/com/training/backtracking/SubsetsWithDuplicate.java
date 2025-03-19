package com.training.backtracking;

import java.util.*;

/*
90. Subsets II
Given an integer array nums that may contain duplicates, return all possible subsets (the power set).
The solution set must not contain duplicate subsets. Return the solution in any order.

Example 1:
    Input: nums = [1,2,2]
    Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
Example 2:
    Input: nums = [0]
    Output: [[],[0]]
 */
public class SubsetsWithDuplicate {

    public static void main(String[] args) {
        int[] arr = {1, 2, 2};
        var res = subsets(arr);
        System.out.println(res);
    }

    private static List<List<Integer>> subsets(int[] nums) {
        Set<List<Integer>> ans = new HashSet<>();
        List<Integer> sol = new ArrayList<>();
        Arrays.sort(nums);
        subsets(ans, sol, 0, nums);
        return new ArrayList<>(ans);
    }

    private static void subsets(Set<List<Integer>> ans, List<Integer> sol, int n, int[] nums) {
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
