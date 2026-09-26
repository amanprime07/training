package com.training.array.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSumK {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, -1, 5};
        int sum = 8;
        long start = System.nanoTime();
        int[] a = bruteForce(arr, sum);
        long timeTaken = System.nanoTime() - start;
        System.out.println(Arrays.toString(a));
        System.out.println("Time take: " + timeTaken / 1000);
        start = System.nanoTime();
        a = checkSumKWithMap(arr, sum);
        timeTaken = System.nanoTime() - start;
        System.out.println(Arrays.toString(a));
        System.out.println("Time take: " + timeTaken / 1000);
        start = System.nanoTime();
        var ans = twoSumK(arr, sum);
        timeTaken = System.nanoTime() - start;
        System.out.println(ans);
        System.out.println("Time take: " + timeTaken / 1000);
    }

    /*
     * Time complexity: O(N^2)
     * Space Complexity: O(1)
     * */
    private static int[] bruteForce(int[] arr, int k) {
        int[] idxArr = {-1, -1};
        if (arr.length == 0) {
            return idxArr;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] + arr[j] == k) {
                    idxArr[0] = j;
                    idxArr[1] = i;
                    break;
                }
            }
        }
        return idxArr;
    }


    /*
     * Time Complexity: O(N LogN), worst case O(N^2)
     * Space Complexity: O(N)
     * */
    private static int[] checkSumKWithMap(int[] arr, int k) {
        int[] idxArr = {-1, -1};
        if (arr.length == 0) {
            return idxArr;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int rem = k - arr[i];
            if (map.containsKey(rem)) {
                int j = map.get(rem);
                idxArr[0] = j;
                idxArr[1] = i;
                break;
            }
            map.put(arr[i], i);
        }
        return idxArr;
    }

    /*

     */
    private static boolean twoSumK(int[] arr, int k) {
        Arrays.sort(arr);
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == k) {
                return true;
            } else if (sum > k) {
                right--;
            } else {
                left++;
            }
        }
        return false;
    }
}
