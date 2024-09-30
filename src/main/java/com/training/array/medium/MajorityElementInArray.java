package com.training.array.medium;

import java.util.HashMap;
import java.util.Map;

public class MajorityElementInArray {

    public static void main(String[] args) {
        int[] arr = {3, 2, 3};
        long start = System.nanoTime();
        int n = majorityElement(arr, arr.length);
        System.out.println("Time taken: " + (System.nanoTime() - start) / 1000);
        System.out.println(n);
        start = System.nanoTime();
        n = majorityElementMap(arr, arr.length);
        System.out.println("Time taken: " + (System.nanoTime() - start) / 1000);
        System.out.println(n);
        start = System.nanoTime();
        n = majorityElementMoore(arr, arr.length);
        System.out.println("Time taken: " + (System.nanoTime() - start) / 1000);
        System.out.println(n);
    }

    private static int majorityElement(int[] arr, int size) {
        int el = arr[0];
        for (int i = 0; i < size; i++) {
            int count = 0;
            for (int j = 0; j < size; j++) {
                if (arr[j] == arr[i]) {
                    count++;
                }
            }
            if (count > size / 2) {
                el = arr[i];
                break;
            }
        }
        return el;
    }

    private static int majorityElementMap(int[] arr, int size) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < size; i++) {
            int count = map.getOrDefault(arr[i], 0);
            count++;
            if (count > size / 2) {
                return arr[i];
            }
            map.put(arr[i], count);
        }
        return -1;
    }

    // Boyer-Moore Voting Algo
    private static int majorityElementMoore(int[] arr, int size) {
        int el = -1, count = 0;
        for (int i = 0; i < size; i++) {
            if (count == 0) {
                el = arr[i];
                count = 1;
            }
            if (el == arr[i]) {
                count++;
            } else {
                count--;
            }
        }
        count = 0;
        for (int i = 0; i < size; i++) {
            if (arr[i] == el) {
                count++;
            }
        }
        if (count > size / 2) {
            return el;
        }
        return -1;
    }
}
