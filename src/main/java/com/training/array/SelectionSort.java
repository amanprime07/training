package com.training.array;

import com.training.util.ArrayUtil;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = {100, 200, 1, -1, 8, 3, -100};
        System.out.println(Arrays.toString(arr));
        selectionSortAsc(arr, arr.length);
        System.out.println(Arrays.toString(arr));
        selectionSortDesc(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    private static void selectionSortAsc(int[] arr, int size) {
        for (int i = 0; i < size; i++) {
            for (int j = i; j < size; j++) {
                if (arr[i] > arr[j]) {
                    ArrayUtil.swap(arr, i, j);
                }
            }
        }
    }

    private static void selectionSortDesc(int[] arr, int size) {
        for (int i = 0; i < size; i++) {
            for (int j = i; j < size; j++) {
                if (arr[i] < arr[j]) {
                    ArrayUtil.swapXor(arr, i, j);
                }
            }
        }
    }
}
