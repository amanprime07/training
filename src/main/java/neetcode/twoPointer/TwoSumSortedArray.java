package neetcode.twoPointer;

import java.util.Arrays;

public class TwoSumSortedArray {
    public static void main(String[] args) {

        int[] arr = {2, 7, 11, 15};
        System.out.println(Arrays.toString(twoSum(arr, 9)));
        arr = new int[]{2, 3, 4};
        System.out.println(Arrays.toString(twoSum(arr, 6)));


    }

    private static int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;
        int sum = 0;
        while (l < r) {
            sum = numbers[l] + numbers[r];
            if (sum == target) {
                return new int[]{l + 1, r + 1};
            } else if (sum > target) {
                r--;
            } else {
                l++;
            }
        }
        return new int[]{-1, -1};
    }
}
