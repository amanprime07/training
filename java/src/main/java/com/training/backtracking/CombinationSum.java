package com.training.backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public static void main(String[] args) {
        int[] arr = {2, 3, 6, 7};
        int target = 7;
        long start = System.nanoTime();
        var res = combinationSum1(arr, target);
        long dr = System.nanoTime() - start;
        System.out.println("TimeTaken: " + dr / (1000));
        System.out.println(res);

        start = System.nanoTime();
        res = combinationSum2(arr, target);
        dr = System.nanoTime() - start;
        System.out.println("TimeTaken: " + dr / (1000));
        System.out.println(res);

        start = System.nanoTime();
        res = combinationSum(arr, target);
        dr = System.nanoTime() - start;
        System.out.println("TimeTaken: " + dr / (1000));
        System.out.println(res);
    }

    private static List<List<Integer>> combinationSum(int[] arr, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> sol = new ArrayList<>();
        combinationSum(ans, sol, arr, target, 0);
        return ans;
    }

    private static void combinationSum(List<List<Integer>> ans, List<Integer> sol, int[] arr, int target, int pos) {
        if (target == 0) {
            ans.add(new ArrayList<>(sol));
            return;
        }

        if (pos >= arr.length) {
            return;
        }
        if (arr[pos] <= target) {
            sol.add(arr[pos]);
            combinationSum(ans, sol, arr, target - arr[pos], pos);
            sol.removeLast();
        }
        combinationSum(ans, sol, arr, target, pos + 1);
    }


    private static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> sol = new ArrayList<>();
        combinationSum2(ans, sol, 0, target, candidates);
        return ans;
    }

    private static void combinationSum2(List<List<Integer>> ans, List<Integer> sol, int pos, int target, int[] nums) {
        if (target == 0) {
            ans.add(new ArrayList<>(sol));
            return;
        }

        if (pos >= nums.length) {
            return;
        }

        if (nums[pos] <= target) {
            sol.add(nums[pos]);
            combinationSum2(ans, sol, pos, target - nums[pos], nums);
            sol.removeLast();
        }
        combinationSum2(ans, sol, pos + 1, target, nums);
    }

    private static List<List<Integer>> combinationSum1(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> sol = new ArrayList<>();
        combinationSum1(ans, sol, 0, 0, candidates, target);
        return ans;
    }

    private static void combinationSum1(List<List<Integer>> ans, List<Integer> sol, int pos, int sum, int[] nums, int target) {
        if (sum == target) {
            ans.add(new ArrayList<>(sol));
            return;
        }
        if (sum > target || pos >= nums.length) {
            return;
        }
        combinationSum1(ans, sol, pos + 1, sum, nums, target);
        if ((target - sum) >= nums[pos]) {
            sol.add(nums[pos]);
            sum = sum + nums[pos];
            combinationSum1(ans, sol, pos, sum, nums, target);
            sol.removeLast();
        }
    }
}
