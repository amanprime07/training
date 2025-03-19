package com.training.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinations {

    public static void main(String[] args) {
        String s = "23";
        var combinations = letterCombinations(s);
        System.out.println(combinations);
    }

    private static void letterCombinations(List<String> ans, StringBuilder sol, int n, Map<Character, String> map, String digits) {
        if (sol.length() == digits.length()) {
            ans.add(sol.toString());
            return;
        }

        String s = map.get(digits.charAt(n));
        for (int i = 0; i < s.length(); i++) {
            sol.append(s.charAt(i));
            letterCombinations(ans, sol, n + 1, map, digits);
            sol.deleteCharAt(sol.length()-1);
        }
    }

    private static List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        letterCombinations(ans, new StringBuilder(), 0, map, digits);
        return ans;
    }
}
