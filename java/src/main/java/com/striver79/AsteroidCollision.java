package com.striver79;

import java.util.Arrays;
import java.util.Stack;

public class AsteroidCollision {

    public static void main(String[] args) {
        int[] arr = {5, 10, -5};
        System.out.println(Arrays.toString(asteroidCollision(arr)));
        arr = new int[]{8, -8};
        System.out.println(Arrays.toString(asteroidCollision(arr)));
        arr = new int[]{10, 2, -5, 10, -20, 20};
        System.out.println(Arrays.toString(asteroidCollision(arr)));
        arr = new int[]{-2, -1, 1, 2};
        System.out.println(Arrays.toString(asteroidCollision(arr)));
    }

    /*
     * 5,10,-5
     *
     * 10
     * 5
     *
     * */
    private static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int asteroid : asteroids) {
            if (asteroid > 0) {
                stack.push(asteroid);
            } else {
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(asteroid)) {
                    stack.pop();
                }
                if (stack.isEmpty() || stack.peek() < 0) {
                    stack.push(asteroid);
                }
                if (!stack.isEmpty() && stack.peek() == Math.abs(asteroid)) {
                    stack.pop();
                }
            }
        }
        int[] res = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }
        return res;
    }
}
