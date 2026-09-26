package com.training.basics;

public class Palindrome {

    public static void main(String[] args) {
        String str = "ABCDCBa";
        char[] s = str.toCharArray();
        String str2 = "ABCDCDA";
        char[] s2 = str2.toCharArray();
//        System.out.println(isPalindrome(s, 0, s.length - 1));
//        System.out.println(isPalindrome(s2, 0, s2.length - 1));
        System.out.println(isPalindrome2Pointer(str));
        System.out.println(isPalindromeRec(str));
        System.out.println(isPalindrome2Pointer(str2));
        System.out.println(isPalindromeRec(str2));

//        System.out.println(isPalindrome(100));
//        System.out.println(isPalindrome(1331));
//        System.out.println(isPalindrome(4554));

    }

    private static boolean isPalindromeRec(String s) {
        return isPalindromeHelp(s, 0);
    }

    private static boolean isPalindromeHelp(String s, int i) {
        if (i == s.length() / 2) {
            return true;
        }
        if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
            return false;
        }
        return isPalindromeHelp(s, i + 1);
    }


    private static boolean isPalindrome2Pointer(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            char l = Character.toLowerCase(s.charAt(left)), r = Character.toLowerCase(s.charAt(right));
            if (!Character.isLetterOrDigit(l)) {
                left++;
            } else if (!Character.isLetterOrDigit(r)) {
                right--;
            } else if (l != r) {
                return false;
            } else {
                left++;
                right--;
            }
        }
        return true;
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
