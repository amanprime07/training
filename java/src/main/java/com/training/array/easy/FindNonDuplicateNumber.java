package com.training.array.easy;

import java.util.HashMap;
import java.util.Map;

public class FindNonDuplicateNumber {

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 3, 3, 4, 4};
        long start = System.nanoTime();
        System.out.println(bruteForce(arr, arr.length));
        System.out.println("Time :" + (System.nanoTime() - start) / 1000);
        start = System.nanoTime();
        System.out.println(nonDuplicateNumber(arr, arr.length));
        System.out.println("Time :" + (System.nanoTime() - start) / 1000);
        start = System.nanoTime();
        System.out.println(nonDuplicateHashMap(arr, arr.length));
        System.out.println("Time :" + (System.nanoTime() - start) / 1000);
    }

    private static int nonDuplicateHashMap(int[] arr, int n) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int count = map.getOrDefault(arr[i], 0);
            map.put(arr[i], ++count);
        }

        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (e.getValue() == 1) {
                return e.getKey();
            }
        }
        return -1;
    }

    private static int nonDuplicateNumber(int[] arr, int n) {
        int xSum = 0;
        for (int i = 0; i < n; i++) {
            xSum ^= arr[i];
        }
        return xSum;
    }

    private static int bruteForce(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                }
            }
            if (count == 1) {
                return arr[i];
            }
        }
        return -1;
    }
}
