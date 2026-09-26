package neetcode.arraysHashing;

import java.util.ArrayList;
import java.util.List;

public class EncodeDecode {

    public static void main(String[] args) {
        List<String> input = List.of("neet","code","love","you");
        String s = encode(input);
        List<String> output = decode(s);
        System.out.println(input);
        System.out.println(output);
    }

    private static String encode(List<String> strings) {
        StringBuilder sb = new StringBuilder();
        for (String s : strings) {
            sb.append(s.length()).append('#').append(s);
        }
        return sb.toString();
    }

    private static List<String> decode(String s) {
        List<String> ans = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {
            int j = i;
            while (s.charAt(j) != '#') {
                j++;
            }
            int l = Integer.parseInt(s.substring(i, j));
            i = j + 1;
            j = i + l;
            ans.add(s.substring(i, j));
            i = j;
        }
        return ans;
    }
}
