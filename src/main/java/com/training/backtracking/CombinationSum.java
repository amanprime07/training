package com.training.backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public static void main(String[] args) {
        int[]arr = {2, 3, 6, 7};
        int target = 7;
        var res = combinationSum(arr, target);
        System.out.println(res);
    }

    private static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> sol = new ArrayList<>();
        combinationSum(ans, sol, 0, 0, candidates, target);
        return ans;
    }

    private static void combinationSum(List<List<Integer>> ans, List<Integer> sol, int n, int sum, int[] nums, int target) {
        if (sum == target) {
            ans.add(new ArrayList<>(sol));
            return;
        }
        if (sum > target || n >= nums.length) {
            return;
        }
        combinationSum(ans, sol, n + 1, sum, nums, target);
        sol.add(nums[n]);
        sum = sum + nums[n];
        combinationSum(ans, sol, n, sum, nums, target);
        sol.removeLast();
    }
}
