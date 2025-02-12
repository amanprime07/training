package clearwater;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Subsets {

    public static void main(String[] args) {
        String s = "abc";
        List<String> list = subsets(s);
        System.out.println(list);

    }

    private static List<String> subsets(String s) {
        List<String> ans = new ArrayList<>();
        subset(0, s, "", ans);
        Collections.sort(ans);
        return ans;
    }

    private static void subset(int i, String s, String temp, List<String> ans) {
        if (i == s.length()) {
            ans.add(temp);
            return;
        }
        subset(i + 1, s, temp, ans);
        subset(i + 1, s, temp + s.charAt(i), ans);
    }
}
