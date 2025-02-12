package com.training.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StringPermutation {


    static int count = 0;

    public static void main(String[] args) {
        String s = "AAC";
        String s1 = "ABC";
        String s2 = "ABCD";
//        permutations("", s);
//        System.out.println(count);
//        System.out.println("\nPermutations for " + s1 + " are: \n" + permutationFinder(s1));
//        System.out.println("\nPermutations for " + s2 + " are: \n" + permutationFinder(s2));
        var list = permutations(s1);
//        Collections.sort(list);
        System.out.println(list);
    }

//    backtracking

    private static List<String> permutations(String s) {
        List<String> result = new ArrayList<>();
        char[] arr = s.toCharArray();
        permute(arr, 0, result);
        return result;
    }

    private static void permute(char[] arr, int idx, List<String> list) {
        if (idx == arr.length) {
            list.add(String.valueOf(arr));
            return;
        }

        for (int i = idx; i < arr.length; i++) {
            swap(arr, idx, i);
            permute(arr, idx+1, list);
            swap(arr, idx, i);
        }
    }

    private static void swap(char[] arr, int s, int d) {
        char c = arr[s];
        arr[s] = arr[d];
        arr[d] = c;
    }

    // Recursive function to generate all permutations of a String
    private static void permutations(String candidate, String remaining) {
        if (remaining.isEmpty()) {
            System.out.println(candidate);
            count++;
        }

        for (int i = 0; i < remaining.length(); i++) {
            String newCandidate = candidate + remaining.charAt(i);

            String newRemaining = remaining.substring(0, i) +
                    remaining.substring(i + 1);

            permutations(newCandidate, newRemaining);
        }
    }

}
