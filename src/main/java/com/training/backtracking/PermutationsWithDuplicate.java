package com.training.backtracking;

import java.util.*;

/*
* 47. Permutations II
Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.
Example 1:
    Input: nums = [1,1,2]
    Output: [[1,1,2], [1,2,1], [2,1,1]]
Example 2:
    Input: nums = [1,2,3]
    Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
* */
public class PermutationsWithDuplicate {

    public static void main(String[] args) {
        int[] arr = {1, 2, 2};
        var result = permutations(arr);
        System.out.println(result);
    }

    private static List<List<Integer>> permutations(int[] nums) {
        Set<List<Integer>> ans = new HashSet<>();
        Arrays.sort(nums);
        permutations(ans, 0, nums);
        return new ArrayList<>(ans);
    }

    private static void permutations(Set<List<Integer>> ans, int n, int[] nums) {
        if (n == nums.length) {
            List<Integer> l = arrayToList(nums);
            ans.add(l);
            return;
        }
        for (int i = n; i < nums.length; i++) {
            swap(nums, i, n);
            permutations(ans, n + 1, nums);
            swap(nums, i, n);
        }
    }

    private static List<Integer> arrayToList(int[] arr) {
        List<Integer> l = new ArrayList<>();
        for (int i : arr) {
            l.add(i);
        }
        return l;
    }

    private static void swap(int[] arr, int s, int d) {
        int temp = arr[s];
        arr[s] = arr[d];
        arr[d] = temp;
    }
}
