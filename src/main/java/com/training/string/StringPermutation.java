package com.training.string;

public class StringPermutation {


    static int count = 0;

    public static void main(String[] args) {
        String s = "AAC";
        String s1 = "ABC";
        String s2 = "ABCD";
        permutations("", s);
        System.out.println(count);
//        System.out.println("\nPermutations for " + s1 + " are: \n" + permutationFinder(s1));
//        System.out.println("\nPermutations for " + s2 + " are: \n" + permutationFinder(s2));

    }

    // Recursive function to generate all permutations of a String
    private static void permutations(String candidate, String remaining) {
        if (remaining.length() == 0) {
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

    // Find Permutations of a String in Java
    public static void main1(String[] args) {
        String s = "ABC";
        permutations("", s);
    }

}
