package com.training.array;

import com.training.util.ArrayUtil;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = {100, 200,1,1,3,4};
        System.out.println(Arrays.toString(arr));
        insertionSortDesc(arr, arr.length);
        System.out.println(Arrays.toString(arr));
        insertionSortAsc(arr, arr.length);
        System.out.println(Arrays.toString(arr));

    }


    /*
    100, 200,1,1,3,4
    * */

    private static void insertionSortDesc(int[] arr, int size) {
        for (int i = 0; i < size; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j - 1] < arr[j]) {
                    ArrayUtil.swap(arr, j, j - 1);
                }
            }
        }
    }

    private static void insertionSortAsc(int[] arr, int size) {
        for (int i = 0; i < size; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j - 1] > arr[j]) {
                    ArrayUtil.swap(arr, j, j - 1);
                }
            }
        }
    }
}
