package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class MinStack {
    List<Pair> stack;
    int size;

    MinStack() {
        this.stack = new ArrayList<>();
    }

    public void push(int val) {
        Pair p = stack.getLast();
        int min = p.min;
        if (val < min) {
            min = val;
        }
        p = new Pair(val, min);
        stack.add(p);
    }

    public void pop() {
        stack.removeLast();
    }

    public int top() {
        return stack.getLast().val;
    }

    public int getMin() {
        return stack.getLast().min;
    }

    private static class Pair {
        int val;
        int min;

        Pair(int v, int m) {
            val = v;
            min = m;
        }
    }

}
