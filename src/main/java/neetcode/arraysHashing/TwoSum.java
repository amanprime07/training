package neetcode.arraysHashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(nums, target)));
        nums = new int[]{3, 2, 4};
        target = 6;
        System.out.println(Arrays.toString(twoSum(nums, target)));

        nums = new int[]{3, 3};
        target = 6;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }


    private static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int p1 = -1, p2 = -1;
        for (int i = 0; i < nums.length; i++) {
            int rem = target - nums[i];
            if (map.containsKey(rem)) {
                p1 = map.get(rem);
                p2 = i;
                break;
            }
            map.put(nums[i], i);
        }
        return new int[]{p1, p2};
    }
}
