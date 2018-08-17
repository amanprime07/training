package com.training.sort;

import java.util.Arrays;

public class SelectionSort {

    private static void selectionSort(int[] arr, int size) {
        for (int i = 0; i < size; i++) {
            for (int j = i; j < size; j++) {
                if (arr[j] < arr[i]) {
                    swap(arr, i, j);
                }
            }
        }
    }

    private static void swap(int[] arr, int s, int d) {
        int temp = arr[s];
        arr[s] = arr[d];
        arr[d] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {2, 5, 3, 4, 1};
        System.out.println(Arrays.toString(arr));
        selectionSort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }
}
