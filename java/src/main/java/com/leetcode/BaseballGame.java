package com.leetcode;

import java.util.Stack;

public class BaseballGame {


    public static void main(String[] args) {
        String[] arr = {"5", "2", "C", "D", "+"};
        System.out.println(calPoints(arr));
        arr = new String[] {"5","-2","4","C","D","9","+","+"};
        System.out.println(calPoints(arr));
        arr = new String[] {"1","C"};
        System.out.println(calPoints(arr));
    }

    private static int calPoints(String[] ops) {
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        for (String s : ops) {
            switch (s) {
                case "D":
                    stack.push(2 * stack.peek());
                    break;
                case "C":
                    stack.pop();
                    break;
                case "+":
                    int i = stack.pop();
                    int o = stack.peek() + i;
                    stack.push(i);
                    stack.push(o);
                    break;
                default:
                    stack.push(Integer.parseInt(s));
            }
        }

        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }
}
