package com.training.array.easy;

import java.util.*;

public class PairSumK {

    public static void main(String[] args) {
        int[] arr = {2, -6, 2, 5, 2};
        pairSum(arr, 4).forEach(i -> System.out.println(Arrays.toString(i)));
    }

    public static List<int[]> pairSum(int[] arr, int k) {
        // Write your code here.
        List<int[]> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int rem = k - arr[i];
            if (map.containsKey(rem)) {
                for (int j = 0; j < map.get(rem); j++) {
//                    list.add(new int[]{arr[i], rem});
                    if (rem < arr[i]) {
                        list.add(new int[]{rem, arr[i]});
                    } else {
                        list.add(new int[]{arr[i], rem});
                    }
                }
            }
            int freq = map.getOrDefault(rem, 0);
            map.put(rem, freq + 1);
        }
        list.sort(Comparator.comparing(v -> v[0]));
        return list;
    }
}

