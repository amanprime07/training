package com.training.revision.sorting;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {3, 4, 1, 6, 2, 5, 7};
        mergeSort(arr, 0, arr.length - 1, new int[arr.length]);
        System.out.println(Arrays.toString(arr));
    }

    private static void mergeSort(int[] arr, int start, int end, int[] temp) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        mergeSort(arr, start, mid, temp);
        mergeSort(arr, mid + 1, end, temp);
        mergeHalves(arr, start, mid, end, temp);
    }

    private static void mergeHalves(int[] arr, int start, int mid, int end, int[] temp) {
        int idx = 0;
        int left = start;
        int right = mid + 1;

        while (left <= mid && right <= end) {
            if (arr[left] < arr[right]) {
                temp[idx] = arr[left];
                left++;
            } else {
                temp[idx] = arr[right];
                right++;
            }
            idx++;
        }

        while (left <= mid) {
            temp[idx] = arr[left];
            idx++;
            left++;
        }

        while (right <= end) {
            temp[idx] = arr[right];
            right++;
            idx++;
        }

        for (int i = start; i <= end; i++) {
            arr[i] = temp[i - start];
        }

    }
}
