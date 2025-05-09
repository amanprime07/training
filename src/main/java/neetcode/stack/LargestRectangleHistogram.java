package neetcode.stack;

import java.util.Stack;

public class LargestRectangleHistogram {

    public static void main(String[] args) {
        int[] arr = new int[]{2, 1, 5, 6, 2, 3};
        System.out.println(largestRectangleArea(arr));

        arr = new int[]{2, 4};
        System.out.println(largestRectangleArea(arr));
        arr = new int[]{2};
        System.out.println(largestRectangleArea(arr));
    }


    private static int largestRectangleArea(int[] arr) {
        Stack<Pair> stack = new Stack<>();

        int maxArea = 0, area;

        for (int i = 0; i < arr.length; i++) {
            int idx = i;
            while (!stack.isEmpty() && stack.peek().v > arr[i]) {
                Pair p = stack.pop();
                idx = p.i;
                area = p.v * (i - idx);
                if (area > maxArea) {
                    maxArea = area;
                }
            }
            stack.push(new Pair(arr[i], idx));
        }

        int idx = arr.length;
        while (!stack.isEmpty()) {
            Pair p = stack.pop();
            area = p.v * (idx - p.i);
            if (area > maxArea) {
                maxArea = area;
            }
        }
        return maxArea;
    }

    private record Pair(int v, int i) {
    }
}
