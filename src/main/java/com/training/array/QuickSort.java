package com.training.array;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {

        int[] arr = {100, 200, 1, -1, 8, 3, -100};
        System.out.println(Arrays.toString(arr));
        quickSortAsc(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

        quickSortDesc(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

    }

    private static void quickSortDesc(int[] arr, int start, int end) {
        int pivot = (start + end) / 2;
        int left = start;
        int right = end;
        do {
            while (arr[left] > arr[pivot] && left < end) {
                left++;
            }
            while (arr[right] < arr[pivot] && right > start) {
                right--;
            }
            if (arr[left] <= arr[right]) {
                swap(arr, left, right);
                left++;
                right--;
            }
        } while (left <= right);

        if (left < end) {
            quickSortDesc(arr, left, end);
        }
        if (right > start) {
            quickSortDesc(arr, start, right);
        }
    }


    private static void quickSortAsc(int[] arr, int start, int end) {
        int pivot = (start + end) / 2;
        int left = start;
        int right = end;
        do {
            while (arr[left] < arr[pivot] && left < end) {
                left++;
            }
            while (arr[right] > arr[pivot] && right > start) {
                right--;
            }
            if (arr[left] >= arr[right]) {
                swap(arr, left, right);
                left++;
                right--;
            }
        } while (left <= right);
        if (left < end) {
            quickSortAsc(arr, left, end);
        }
        if (right > start) {
            quickSortAsc(arr, start, right);
        }
    }

    private static void swap(int[] arr, int s, int d) {
        int temp = arr[s];
        arr[s] = arr[d];
        arr[d] = temp;
    }
}
