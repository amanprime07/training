package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/*
 * 739: Daily Temperature
 * */
public class DailyTemperature {

    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(73, 74, 75, 71, 69, 72, 76, 73);
        System.out.println(dailyTemperature(arr));
        arr = Arrays.asList(30, 40, 50, 60);
        System.out.println(dailyTemperature(arr));
    }

    /*
    * Example 1:
        Input: temperatures = [73,74,75,71,69,72,76,73]
        Output: [1,1,4,2,1,1,0,0]
    * Example 2:
        Input: temperatures = [30,40,50,60]
        Output: [1,1,1,0]
    * Example 3:
        Input: temperatures = [30,60,90]
        Output: [1,1,0]
    * */
    private static List<Integer> dailyTemperature(List<Integer> temperatures) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < temperatures.size(); i++) {
            ans.add(0);
        }
        Stack<Pair> stack = new Stack<>();
        for (int i = 0; i < temperatures.size(); i++) {
            while (!stack.isEmpty() && temperatures.get(i) > stack.peek().val) {
                Pair p = stack.pop();
                ans.set(p.idx, i - p.idx);
            }
            stack.push(new Pair(temperatures.get(i), i));
        }
        return ans;
    }

    private static class Pair {
        int val;
        int idx;

        Pair(int val, int idx) {
            this.idx = idx;
            this.val = val;
        }
    }
}
