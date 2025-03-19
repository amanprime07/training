package com.training.backtracking;

import java.util.ArrayList;
import java.util.List;

/*
*
77. Combinations
Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].
You may return the answer in any order.
Example 1:
    Input: n = 4, k = 2
    Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
    Explanation: There are 4 choose 2 = 6 total combinations.
    Note that combinations are unordered, i.e., [1,2] and [2,1] are considered to be the same combination.
Example 2:
    Input: n = 1, k = 1
    Output: [[1]]
    Explanation: There is 1 choose 1 = 1 total combination.
 * */
public class Combinations {

    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        List<List<Integer>> result = combine(n, k);
        System.out.println(result);
    }

    private static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> sol = new ArrayList<>();
        combine(ans, sol, n, k);
        return ans;
    }

    private static void combine(List<List<Integer>> ans, List<Integer> sol, int n, int k) {
        if (sol.size() == k) {
            ans.add(new ArrayList<>(sol));
            return;
        }
        int left = n;
        int need = k - sol.size();
        if (left > need) {
            combine(ans, sol, n - 1, k);
        }
        sol.add(n);
        combine(ans, sol, n - 1, k);
        sol.removeLast();

    }
}
