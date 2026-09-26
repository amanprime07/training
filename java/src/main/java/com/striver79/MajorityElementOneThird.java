package com.striver79;

import java.util.ArrayList;
import java.util.List;

public class MajorityElementOneThird {

    public static void main(String[] args) {
        int[] arr = {3,2,3};
        System.out.println(majorityElementOneThird(arr));
        arr = new int[]{1};
        System.out.println(majorityElementOneThird(arr));
        arr = new int[]{1,2};
        System.out.println(majorityElementOneThird(arr));

    }

    private static List<Integer> majorityElementOneThird(int[] nums) {
        int el1 = -1, count1 = 0;
        int el2 = -1, count2 = 0;
        for (int num : nums) {
            if (count1 == 0 && num != el2) {
                el1 = num;
                count1++;
            } else if (count2 == 0 && num != el1) {
                el2 = num;
                count2++;
            } else if (num == el1) {
                count1++;
            } else if (num == el2) {
                count2++;
            } else {
                count2--;
                count1--;
            }
        }

        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num == el1) {
                count1++;
            } else if (num == el2) {
                count2++;
            }
        }
        List<Integer> list = new ArrayList<>();
        if (count1 > nums.length / 3) {
            list.add(el1);
        }

        if (count2 > nums.length / 3) {
            list.add(el2);
        }
        return list;
    }
}
