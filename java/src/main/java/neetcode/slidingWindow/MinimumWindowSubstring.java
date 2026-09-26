package neetcode.slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s, t));
        s = "a";
        t = "a";
        System.out.println(minWindow(s, t));
        s = "a";
        t = "aa";
        System.out.println(minWindow(s, t));
        s = "ab";
        t = "b";
        System.out.println(minWindow(s, t));
        s = "cabwefgewcwaefgcf";
        t = "cae";
        System.out.println(minWindow(s, t));
    }

    private static String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            char sc = s.charAt(i);
            int fs = sMap.getOrDefault(sc, 0);
            sMap.put(sc, fs + 1);

            char tc = t.charAt(i);
            int ft = tMap.getOrDefault(tc, 0);
            tMap.put(tc, ft + 1);
        }

        if (containsChar(sMap, tMap)) {
            return s.substring(0, t.length());
        }
        int l = 0, start = 0, end = 0, minWindow = Integer.MAX_VALUE;
        for (int r = t.length(); r < s.length(); r++) {
            char sc = s.charAt(r);
            int fs = sMap.getOrDefault(sc, 0);
            sMap.put(sc, fs + 1);
            while (containsChar(sMap, tMap)) {
                if (r - l + 1 < minWindow) {
                    end = r;
                    start = l;
                    minWindow = r - l + 1;
                }
                char lc = s.charAt(l);
                sMap.put(lc, sMap.getOrDefault(lc, 0) - 1);
                l++;
            }
        }

        return end == 0 ? "" : s.substring(start, end + 1);
    }

    private static boolean containsChar(Map<Character, Integer> sMap, Map<Character, Integer> tMap) {
        for (Map.Entry<Character, Integer> e : tMap.entrySet()) {
            if (!sMap.containsKey(e.getKey()) || e.getValue() > sMap.get(e.getKey())) {
                return false;
            }
        }
        return true;
    }
}
