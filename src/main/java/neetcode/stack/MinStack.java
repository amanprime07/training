package neetcode.stack;

import java.util.ArrayList;
import java.util.List;

public class MinStack {

    private record Pair(int v, int min) {
    }

    List<Pair> list;

    public MinStack() {
        list = new ArrayList<>();
    }

    public void push(int val) {
        int min;
        if (list.isEmpty()) {
            min = val;
        } else {
            min = list.getLast().min;
        }
        if (val < min) {
            min = val;
        }
        list.add(new Pair(val, min));

    }

    public void pop() {
        list.removeLast();
    }

    public int top() {
        return list.getLast().v;
    }

    public int getMin() {
        return list.getLast().min;
    }
}
