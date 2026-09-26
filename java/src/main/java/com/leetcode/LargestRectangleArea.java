package com.leetcode;

import java.util.Stack;

/*
 * 84: Largest Rectangle in Histogram
 * */
public class LargestRectangleArea {

    public static void main(String[] args) {
        int[] arr = new int[]{2, 1, 5, 6, 2, 3};
        System.out.println(largestRectangleArea(arr));

        arr = new int[]{2, 4};
        System.out.println(largestRectangleArea(arr));
        arr = new int[]{1, 2, 3, 4, 5};
        System.out.println(largestRectangleArea(arr));
    }


    /*
     * Example 1:
     *               i = [0,1,2,3,4,5]
        Input: heights = [2,1,5,6,2,3]
        Output: 10
        Explanation: The above is a histogram where width of each bar is 1.
        The largest rectangle is shown in the red area, which has an area = 10 units.
    * */
    private static int largestRectangleArea(int[] heights) {
        Stack<Pair> stack = new Stack<>();
        int maxArea = 0;
        Pair p;
        int idx;
        for (int i = 0; i < heights.length; i++) {
            idx = i;
            while (!stack.isEmpty() && stack.peek().val > heights[i]) {
                p = stack.pop();
                int w = i - p.idx;
                idx = p.idx;
                maxArea = Math.max(p.val * w, maxArea);
            }
            stack.push(new Pair(heights[i], idx));
        }

        int i = heights.length;
        while (!stack.isEmpty()) {
            p = stack.pop();
            maxArea = Math.max(maxArea, p.val * (i - p.idx));
        }
        return maxArea;
    }

    private static class Pair {
        int val;
        int idx;

        Pair(int v, int i) {
            val = v;
            idx = i;
        }
    }
}
