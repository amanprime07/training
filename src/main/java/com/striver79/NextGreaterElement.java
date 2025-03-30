package com.striver79;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {

    public static void main(String[] args) {
        int[] arr = {5, 7, 1, 2, 6, 0};
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(nextGreater(arr)));
        System.out.println(Arrays.toString(nextGreaterCyclic(arr)));
    }

    private static int[] nextGreater(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[i] >= stack.peek()) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                res[i] = -1;
            } else {
                res[i] = stack.peek();
            }
            stack.push(arr[i]);
        }
        return res;
    }

    private static int[] nextGreaterCyclic(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int length = arr.length;
        int[] result = new int[length];
        for (int i = 2 * length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[i % length] >= stack.peek()) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                result[i % length] = -1;
            } else {
                result[i % length] = stack.peek();
            }
            stack.push(arr[i % length]);
        }
        return result;
    }
}





