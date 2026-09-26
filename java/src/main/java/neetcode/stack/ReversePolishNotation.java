package neetcode.stack;

import java.util.Stack;

public class ReversePolishNotation {

    public static void main(String[] args) {
        String[] s = new String[]{"2", "1", "+", "3", "*"};
        System.out.println(evaluateRpn(s)); // 9
        s = new String[]{"4","13","5","/","+"};
        System.out.println(evaluateRpn(s)); // 6
    }

    private static int evaluateRpn(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int a, b;
        for (String t : tokens) {
            switch (t) {
                case "+":
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(a + b);
                    break;
                case "-":
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(b - a);
                    break;
                case "*":
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(a * b);
                    break;
                case "/":
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(b / a);
                    break;
                default:
                    int x = Integer.parseInt(t);
                    stack.push(x);
            }
        }
        return stack.pop();
    }
}
