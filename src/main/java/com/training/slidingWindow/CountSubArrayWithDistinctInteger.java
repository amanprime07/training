package com.training.slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class CountSubArrayWithDistinctInteger {

    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 2, 3};
        System.out.println(subArraysWithKDistinct(arr, 2));
//        System.out.println(subArraysWithKDistinct(arr, 3));
    }

    private static int subArraysWithKDistinct(int[] arr, int target) {
        return countSubArrays(arr, target) - countSubArrays(arr, target-1);
    }

    private static int countSubArrays(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int l = 0;
        int count = 0;
        for (int r = 0; r < arr.length; r++) {
            int i = arr[r];
            map.put(i, map.getOrDefault(i, 0) + 1);
            while (l <= r && map.size() > target) {
                if (map.containsKey(arr[l])) {
                    map.put(arr[l], map.get(arr[l]) - 1);
                    if (map.get(arr[l]) == 0) {
                        map.remove(arr[l]);
                    }
                }
                l++;
            }
            count += (r - l + 1);
        }
        return count;
    }
}
