package com.training.array.medium;

import java.util.HashMap;
import java.util.Map;

public class CountSubArrayWithSumK {
    public static void main(String[] args) {
            int[] arr = {1,1,1};
        System.out.println(prefixSumApproach(arr, 2));
    }

/*
* 3,-3,1,1,1
* */


    private static int prefixSumApproach(int[] arr, int k) {
        int count = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            int rem = sum - k;
            if (map.containsKey(rem)) {
                count += map.get(rem);
            }
            int t = map.getOrDefault(sum, 0);
            map.put(sum, t + 1);
        }
        return count;
    }

    private static int bruteForce(int[] arr, int k) {
        int[][] m = new int[arr.length][2];
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if (sum == k) {
                    m[i] = new int[]{i, j};
                    count++;
                }
            }
        }
        print(m);
        return count;
    }

    private static void print(int[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
    }
}
