package com.training.array.medium;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {

    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 1, 1};
        System.out.println(findMaxLength(arr));
    }

    private static int findMaxLength(int[] arr) {
        int sum = 0;
        int maxLen = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                sum--;
            } else {
                sum++;
            }
            if (sum == 0) {
                maxLen = Math.max(maxLen, i + 1);
            }
            int rem = sum - 0;
            if (map.containsKey(rem)) {
                maxLen = Math.max(maxLen, i - map.get(rem));
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return maxLen;
    }
}
