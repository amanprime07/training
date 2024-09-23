package com.training.sort;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = {1, 4, 5, 7, 2, 3, -100};
        insertionSortAsc(arr);
        System.out.println(Arrays.toString(arr));
        insertionSortDesc(arr);
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

    private static void insertionSortDesc(int[]arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] > arr[j - 1]) {
                    swap(arr, j, j - 1);
                }
            }
        }
    }

    private static void swap(int[] arr, int s, int d) {
        arr[s] = arr[s] ^ arr[d];
        arr[d] = arr[s] ^ arr[d];
        arr[s] = arr[s] ^ arr[d];
    }
}
