package com.training.revision.sorting;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {-100, 10, 1, 2, -999, 5};
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
        arr = new int[]{5,4,3,2,1};
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int start, int end) {
        int left = start;
        int right = end;
        int pivotIdx = (left + right) / 2;
        int pivot = arr[pivotIdx];
        do {
            while (arr[left] < pivot) {
                left++;
            }
            while (pivot < arr[right]) {
                right--;
            }

            if (left <= right) {
                swap(arr, left, right);
                left++;
                right--;
            }
        } while (left <= right);

        if (left < end) {
            quickSort(arr, left, end);
        }
        if (start < right) {
            quickSort(arr, start, right);
        }
    }

    private static void swap(int[] arr, int s, int d) {
        int temp = arr[s];
        arr[s] = arr[d];
        arr[d] = temp;
    }
}
