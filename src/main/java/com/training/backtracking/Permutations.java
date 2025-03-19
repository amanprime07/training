package com.training.backtracking;

import java.util.ArrayList;
import java.util.List;

/*
* 46. Permutations
Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
Example 1:
    Input: nums = [1,2,3]
    Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
Example 2:
    Input: nums = [0,1]
    Output: [[0,1],[1,0]]
Example 3:
    Input: nums = [1]
    Output: [[1]]
* */
public class Permutations {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        var result = permutations(arr);
        System.out.println(result);
    }

    private static List<List<Integer>> permutations(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> sol = new ArrayList<>();
        permutations(ans, sol, 0, nums);
        return ans;
    }

    private static List<Integer> arrayToList(int[] arr) {
        List<Integer> l = new ArrayList<>();
        for (int i : arr) {
            l.add(i);
        }
        return l;
    }

    private static void permutations(List<List<Integer>> ans, List<Integer> sol, int n, int[] nums) {
        if (n == nums.length) {
            ans.add(arrayToList(nums));
            return;
        }
        for (int i = n; i < nums.length; i++) {
            swap(nums, i, n);
            permutations(ans, sol, n + 1, nums);
            swap(nums, i, n);
        }
    }

    private static void swap(int[] arr, int s, int d) {
        int temp = arr[s];
        arr[s] = arr[d];
        arr[d] = temp;
    }
}
