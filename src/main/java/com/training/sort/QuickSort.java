package com.training.sort;

import com.training.util.ArrayUtil;
public class QuickSort {

    private static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length-1);
    }

    private static void quickSort(int[] arr, int start, int end) {
        int left = start, right = end;
        int mid = arr[(start + end) / 2], temp;

        do {
            while (arr[left] < mid & left < end) {
                left++;
            }
            while (arr[right] > mid & right > start) {
                right--;
            }
            if (left <= right) {
                ArrayUtil.swap(arr, left, right);
                left++;
                right--;
            }

        } while (left <= right);
        if (start < right) quickSort(arr, start, left);
        if (left < end) quickSort(arr, right, end);

    }

    public static void main(String[] args) {
        int[] arr = {4,3,1,5,2};
        ArrayUtil.printArray(arr);
        quickSort(arr);
        ArrayUtil.printArray(arr);
    }


}
