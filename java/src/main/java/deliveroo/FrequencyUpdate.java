package deliveroo;

import java.util.*;

public class FrequencyUpdate {


    public static void main(String[] args) {
        List<Integer> timestamp = Arrays.asList(1, 3, 4, 5, 7, 9, 15);
        List<String> words = Arrays.asList("Hello", "Hi", "Hello", "abcd", "xyz", "Hello", "ppp");
        System.out.println(update(timestamp, words, 5));
    }

    private static List<String> update(List<Integer> timestamps, List<String> words, int k) {
        Map<String, Integer> map = new HashMap<>();
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < timestamps.size(); i++) {
            if (map.containsKey(words.get(i))) {
                int diff = timestamps.get(i) - map.get(words.get(i));
                if (diff >= k) {
                    map.put(words.get(i), timestamps.get(i));
                    ans.add("true");
                } else {
                    ans.add("false");
                }
            } else {
                map.put(words.get(i), timestamps.get(i));
                ans.add("true");
            }
        }
        return ans;
    }
}
