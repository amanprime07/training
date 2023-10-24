package com.training.string;


import java.time.LocalDate;
import java.util.Arrays;

public class Anagram {

    public static void main(String[] args) {
        System.out.println("isAnagram -> " + isAnagram("cars", "duel"));
        System.out.println("isAnagramUsingSort -> " + isAnagramUsingSort("cars", "duel"));
        System.out.println("isAnagram -> " + isAnagram("dule", "duel"));
        System.out.println("isAnagramUsingSort -> " + isAnagramUsingSort("abc", "bca"));
    }

    static boolean isAnagram(String a, String b) {
        int[] arr = new int[Character.MAX_VALUE];
        if (a.length() != b.length())
            return false;
        for (int i = 0; i < a.length(); i++) {
            arr[a.charAt(i)]++;
        }
        for (int i = 0; i < b.length(); i++) {
            int count = arr[(b.charAt(i))];
            if (count <= 0)
                return false;
            arr[b.charAt(i)]--;
        }
        return true;
    }

    static String sortedString(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        return String.valueOf(arr);
    }

    static boolean isAnagramUsingSort(String a, String b) {
        if (a.length() != b.length())
            return false;
        a = sortedString(a);
        b = sortedString(b);
        return a.equals(b);
    }
}



