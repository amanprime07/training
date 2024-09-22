package com.training.practice;

public class Palindrome {

    public static void main(String[] args) {
        char[] s = "ABCDCBA".toCharArray();
        char[] s2 = "ABCDCDA".toCharArray();
        System.out.println(isPalindrome(s, 0, s.length - 1));
        System.out.println(isPalindrome(s2, 0, s2.length - 1));
//        System.out.println(isPalindrome(100));
//        System.out.println(isPalindrome(1331));
//        System.out.println(isPalindrome(4554));

    }

    public static boolean isPalindrome(int n) {
        int temp = n;
        int x = 0;
        while (temp > 0) {
            int rem = temp % 10;
            temp = temp / 10;
            x = x * 10 + rem;
        }
        return x == n;
    }

    private static boolean isPalindrome(char[] s, int start, int end) {
        if (start >= end) {
            return true;
        }
        return s[start] == s[end] && isPalindrome(s, start + 1, end - 1);
    }
}
