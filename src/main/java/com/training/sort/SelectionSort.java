package com.training.sort;

import com.training.util.ArrayUtil;

public class SelectionSort {

    private static void selectionSort(int[] arr, int size) {
        for (int i = 0; i < size; i++) {
            for (int j = i; j < size; j++) {
                if (arr[j] < arr[i]) {
                    ArrayUtil.swap(arr, i, j);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 5, 3, 4, 1};
        ArrayUtil.printArray(arr);
        selectionSort(arr, arr.length);
        ArrayUtil.printArray(arr);
    }
}
