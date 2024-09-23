package com.training.sort;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = {1, 4, 5, 7, 2, 3, -100};
//        insertionSortAsc(arr);
        System.out.println(Arrays.toString(arr));
//        insertionSortDesc(arr);
//        System.out.println(Arrays.toString(arr));
        insertionSortDescRecursive(arr, 0, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    /*
     * 1,4,5,7,2,3,-100
     *
     *
     * */
    private static void insertionSortAsc(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1);
                }
            }
        }
    }

    private static void insertionSortDesc(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] > arr[j - 1]) {
                    swap(arr, j, j - 1);
                }
            }
        }
    }

    private static void insertionSortAscRecursive(int[] arr, int k, int size) {
        if (k == size) {
            return;
        }
        for (int i = k; i > 0; i--) {
            if (arr[i] < arr[i - 1]) {
                swap(arr, i, i - 1);
            }
        }
        insertionSortAscRecursive(arr, k+1, size);
    }

    private static void insertionSortDescRecursive(int[] arr, int k, int size) {
        if (k == size) {
            return;
        }
        for (int i = k; i > 0; i--) {
            if (arr[i] > arr[i - 1]) {
                swap(arr, i, i - 1);
            }
        }
        insertionSortDescRecursive(arr, k+1, size);
    }

    private static void swap(int[] arr, int s, int d) {
        arr[s] = arr[s] ^ arr[d];
        arr[d] = arr[s] ^ arr[d];
        arr[s] = arr[s] ^ arr[d];
    }
}
