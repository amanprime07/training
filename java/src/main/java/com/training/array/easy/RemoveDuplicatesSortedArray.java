package com.training.array.easy;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicatesSortedArray {

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 3, 3, 3, 4, 4, 5, 5};
//        int n = bruteForce(arr, arr.length);
//        for (int i = 0; i < n; i++) {
//            System.out.print(arr[i] + " ");
//        }
//        System.out.println();
//        arr = new int[]{1, 2, 2, 2, 3, 4, 5, 5};
        int n = removeDup(arr, arr.length);
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private static int bruteForce(int[] arr, int n) {
        Set<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            hashSet.add(arr[i]);
        }
        int i = 0;
        for (Integer x : hashSet) {
            arr[i] = x;
            i++;
        }
        return hashSet.size();
    }

    public static int removeDuplicates(int[] arr, int n) {
        int x = 0;
        for (int i = 0; i < n; i++) {
            if (arr[x] != arr[i]) {
                x++;
                arr[x] = arr[i];
            }
        }
        return x + 1;
    }

    private static int removeDup(int[] arr, int n) {
        int x = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[x] != arr[i]) {
                x++;
                arr[x] = arr[i];
            }
        }
        return x + 1;
    }
}
