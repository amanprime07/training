package com.training.string;

import java.util.*;
import java.util.stream.Collectors;

public class AutoCorrect {

    static boolean isAnagram(String a, String b) {
        // Complete the function
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
    static List<List<String>> findAutoCorrect(String[] words, String[] queries) {
        List<List<String>> autoCorrectWords = new ArrayList<>();
        Map<Integer, Set<String>> lengthToWords = new HashMap<>();
        for (String word : words) {
            Set<String> sameLengthWords = lengthToWords.getOrDefault(word.length(), new TreeSet<>());
            sameLengthWords.add(word);
            lengthToWords.put(word.length(), sameLengthWords);
        }
        for (String q : queries) {
            List<String> anagrams = lengthToWords.getOrDefault(q.length(), new TreeSet<>()).stream().filter(v -> isAnagram(q, v)).collect(Collectors.toList());
            autoCorrectWords.add(anagrams);
        }
        return autoCorrectWords;
    }

    static List<List<String>> findAutoCorrectAnagramMap(String[] words, String[] queries) {
        List<List<String>> autoCorrectWords = new ArrayList<>();
        Map<String, Set<String>> anagramsMap = new HashMap<>();
        for (String word : words) {
            String s = sortedString(word);
            Set<String> sameLengthWords = anagramsMap.getOrDefault(s, new TreeSet<>());
            sameLengthWords.add(word);
            anagramsMap.put(s, sameLengthWords);
        }
        for (String q : queries) {
            String s = sortedString(q);
            Set<String> anagrams = anagramsMap.getOrDefault(s, new TreeSet<>());
            autoCorrectWords.add(new ArrayList<>(anagrams));
        }
        return autoCorrectWords;
    }

    public static void main(String[] args) {
        var words = new String[]{"duel", "speed", "dule", "cars"};
        var queries = new String[]{"spede", "deul"};
        long start = System.nanoTime();
        System.out.println(findAutoCorrect(words, queries));
        System.out.println("TimeTaken "+ (System.nanoTime()-start)/100000);
        start = System.nanoTime();
        System.out.println(findAutoCorrectAnagramMap(words, queries));
        System.out.println("TimeTaken "+ (System.nanoTime()-start)/100000);
    }

}
