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
        subset(0, s, new StringBuilder(), ans);
        Collections.sort(ans);
        return ans;
    }

    private static void subset(int i, String s, StringBuilder temp, List<String> ans) {
        if (i == s.length()) {
            ans.add(temp.toString());
            return;
        }
        subset(i + 1, s, temp, ans);
        subset(i + 1, s, temp.append(s.charAt(i)), ans);
    }
}
