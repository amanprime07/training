package neetcode.arraysHashing;

import java.util.*;

public class GroupAnagrams {

    public static void main(String[] args) {
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
    }


    private static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            String count = key(s);
            List<String> list = map.getOrDefault(count, new ArrayList<>());
            list.add(s);
            map.put(count, list);
        }
        return map.values().stream().toList();
    }

    private static String key(String s) {
        int[] arr = new int[26];
        for (char c : s.toCharArray()) {
            arr[c - 'a']++;
        }
        return Arrays.toString(arr);
    }
}
