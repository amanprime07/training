package com.striver79;

public class MajorityElementHalf {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1, 1, 1, 2, 2, 2};
        System.out.println(majorityElement(arr));
    }

    private static int majorityElement(int[] nums) {
        int count = 0;
        int el = -1;
        for (int num : nums) {
            if (count == 0) {
                el = num;
            }

            if (num == el) {
                count++;
            } else {
                count--;
            }
        }

        count = 0;
        for (int num : nums) {
            if (num == el) {
                count++;
            }
        }
        if (count > nums.length / 2) {
            return el;
        }
        return -1;
    }
}
