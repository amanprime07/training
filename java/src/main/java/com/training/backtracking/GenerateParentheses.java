package com.training.backtracking;

import java.util.ArrayList;
import java.util.List;

/*
* 22. Generate Parentheses
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
Example 1:
    Input: n = 3
    Output: ["((()))","(()())","(())()","()(())","()()()"]
Example 2:
    Input: n = 1
    Output: ["()"]
* */
public class GenerateParentheses {

    public static void main(String[] args) {
        int n = 3;
        System.out.println(generateParentheses(n));
        n = 1;
        System.out.println(generateParentheses(n));
    }


    private static List<String> generateParentheses(int n) {
        List<String> ans = new ArrayList<>();
        generateParentheses(ans, new StringBuilder(), n, 0, 0);
        return ans;
    }

    private static void generateParentheses(List<String> ans, StringBuilder sol, int n, int numOpen, int numClose) {
        if (numOpen == n && numClose == n) {
            ans.add(sol.toString());
            return;
        }

        if (numOpen < n) {
            sol.append('(');
            generateParentheses(ans, sol, n, numOpen+1, numClose);
            sol.deleteCharAt(sol.length()-1);
        }

        if(numClose<numOpen){
            sol.append(')');
            generateParentheses(ans, sol, n, numOpen, numClose+1);
            sol.deleteCharAt(sol.length()-1);
        }
    }
}
