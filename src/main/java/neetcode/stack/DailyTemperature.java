package neetcode.stack;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperature {

    public static void main(String[] args) {
        int[] arr = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(Arrays.toString(dailyTemperature(arr)));

        arr = new int[]{5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(dailyTemperature(arr)));
    }

    /*
    *
    * Example 1:
        Input: temperatures = [73,74,75,71,69,72,76,73]
        Output: [1,1,4,2,1,1,0,0]
        *
        * maintain a decreasing monotonic stack and pop until stack has large value
    * */
    private static int[] dailyTemperature(int[] temperature) {
        Stack<Pair> stack = new Stack<>();
        int[] ans = new int[temperature.length];
        for (int i = 0; i < temperature.length; i++) {
            int t = temperature[i];
            while (!stack.isEmpty() && t > stack.peek().t) {
                Pair p = stack.pop();
                ans[p.i] = i - p.i;
            }
            stack.push(new Pair(t, i));
        }
// not needed since ans is initialized with 0;
//        while (!stack.isEmpty()) {
//            Pair p = stack.pop();
//            ans[p.i] = 0;
//        }
        return ans;
    }

    private record Pair(int t, int i) {
    }
}
