package com.training.slidingWindow;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        String s = "abcabcdbb";
        System.out.println(longestSubstringWithoutRepeats(s));
        s = "bbbbbb";
        System.out.println(longestSubstringWithoutRepeats(s));
    }

    /*
     * abcabcbb
     * */
    private static int longestSubstringWithoutRepeats(String s) {
        Set<Character> set = new HashSet<>();

        int l = 0;
        int maxWindow = 0;
        int window = 0;
        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            while (l <= r && set.contains(c)) {
                set.remove(s.charAt(l));
                l++;
            }
            set.add(c);
            window = r - l + 1;
            if (maxWindow < window) {
                maxWindow = window;
            }
        }
        return maxWindow;
    }
}
