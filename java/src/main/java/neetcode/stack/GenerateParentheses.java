package neetcode.stack;

import java.util.ArrayList;
import java.util.List;

// should be backtracking
public class GenerateParentheses {

    public static void main(String[] args) {
        System.out.println(generateParentheses(3));
    }

    private static List<String> generateParentheses(int n) {
        List<String> ans = new ArrayList<>();
        generateParentheses(ans, 0, 0, new StringBuilder(), n);
        return ans;
    }

    private static void generateParentheses(List<String> ans, int nOpen, int nClose, StringBuilder sb, int n) {
        if (nClose == n && nOpen == n) {
            ans.add(sb.toString());
            return;
        }

        if (nOpen < n) {
            sb.append("(");
            generateParentheses(ans, nOpen + 1, nClose, sb, n);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (nClose < nOpen) {
            sb.append(")");
            generateParentheses(ans, nOpen, nClose + 1, sb, n);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
