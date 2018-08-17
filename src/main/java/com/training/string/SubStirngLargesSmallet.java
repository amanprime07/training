package com.training.string;

import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class SubStirngLargesSmallet {
    public static String getSmallestAndLargest(String s, int k) {
        String smallest = "";
        String largest = "";
        SortedSet<String> stringSet = new TreeSet<>();
        System.out.println(s.length());
        for (int i = 0; i < (s.length() - k + 1); i++) {
            System.out.println(i + " " + s.substring(i, i + k));
            stringSet.add(s.substring(i, i + k));
        }
        smallest = stringSet.first();
        largest = stringSet.last();

        // Complete the function
        // 'smallest' must be the lexicographically smallest substring of length 'k'
        // 'largest' must be the lexicographically largest substring of length 'k'

        return smallest + "\n" + largest;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int k = scan.nextInt();
        scan.close();

        System.out.println(getSmallestAndLargest(s, k));
    }

}