package com.training.slidingWindow;

public class LongestRepeatingCharacterReplacement {

    public static void main(String[] args) {
        String s = "ABAC";
        System.out.println(characterReplacement(s, 2));

        String s1 = "ABACAC";
        System.out.println(characterReplacement(s1, 3));
    }

    private static int characterReplacement(String s, int k) {
        int maxWindow = 0;
        int l = 0;
        int[] counter = new int[26];
        int window = 0;
        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            counter[c - 'A'] += 1;
            window = r - l + 1;
            while (l <= r && window - max(counter) > k) {
                counter[c - 'A'] -= 1;
                l++;
            }
            window = r - l + 1;
            if (maxWindow < window) {
                maxWindow = window;
            }
        }

        return maxWindow;
    }

    private static int max(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int j : arr) {
            max = Math.max(max, j);
        }
        return max;
    }
}
