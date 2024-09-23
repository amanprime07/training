package com.training.array;

import com.training.util.ArrayUtil;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {100, -400, 12, 4231, 12, 99};
        System.out.println(Arrays.toString(arr));
        bubbleSortAsc(arr, arr.length);
        System.out.println(Arrays.toString(arr));
        bubbleSortDesc(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    /*
    100, -400, 12, 4231, 12, 99
    * */
    private static void bubbleSortAsc(int[] arr, int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    ArrayUtil.swap(arr, j, j + 1);
                }
            }
        }
    }

    private static void bubbleSortDesc(int[] arr, int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - 1; j++) {
                if (arr[j] <= arr[j + 1]) {
                    ArrayUtil.swap(arr, j, j + 1);
                }
            }
        }
    }
}
