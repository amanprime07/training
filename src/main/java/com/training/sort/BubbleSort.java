package com.training.sort;

import com.training.util.ArrayUtil;

import java.util.Arrays;

public class BubbleSort {

    private static void bubbleSortAsc(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j + 1] < arr[j]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    private static void bubbleSortDesc(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j + 1] > arr[j]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    private static void swap(int[] arr, int s, int d) {
        arr[s] = arr[s] ^ arr[d];
        arr[d] = arr[s] ^ arr[d];
        arr[s] = arr[s] ^ arr[d];
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 5, 3, 2};
        System.out.println(Arrays.toString(arr));
        long start = System.nanoTime();
        bubbleSortAsc(arr);
        System.out.println("Time taken: " + (System.nanoTime() - start) / 1000);
        ArrayUtil.printArray(arr);
        bubbleSortDesc(arr);
        ArrayUtil.printArray(arr);
        bubbleSortAscRecursive(arr, arr.length);
        System.out.println(Arrays.toString(arr));
        bubbleSortDescRecursive(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    private static void bubbleSortAscRecursive(int[] arr, int size) {
        if (size <= 0) {
            return;
        }
        for (int j = 0; j < size - 1; j++) {
            if (arr[j + 1] < arr[j]) {
                swap(arr, j, j + 1);
            }
        }
        bubbleSortAscRecursive(arr, size - 1);
    }

    private static void bubbleSortDescRecursive(int[] arr, int size) {
        if (size <= 0) {
            return;
        }
        for (int j = 0; j < size - 1; j++) {
            if (arr[j + 1] > arr[j]) {
                swap(arr, j, j + 1);
            }
        }
        bubbleSortDescRecursive(arr, size - 1);
    }
}
