package neetcode.arraysHashing;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        int[] arr = new int[]{100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(arr));
        arr = new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        System.out.println(longestConsecutive(arr));
    }

    private static int longestConsecutive(int[] nums) {
        int maxLen = 0;
        Set<Integer> set = new HashSet<>();

        for (int i : nums) {
            set.add(i);
        }

        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i] - 1)) {
                // start of seq
                int x = nums[i];
                int count = 0;
                while (set.contains(x++)) {
                    count++;
                    if (maxLen < count) {
                        maxLen = count;
                    }
                }
            }
        }
        return maxLen;
    }
}
