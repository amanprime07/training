package com.training.array.medium;

import java.util.Arrays;

public class Sort012 {
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 0, 1, 2};
        System.out.println(Arrays.toString(arr));
        sort012Pointer(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    /*
        0, 1, 2, 0, 1, 2
        i = 0, j = 0
        k = 5

    * */
    private static void sort012Pointer(int[] arr, int size) {
        int one = 0, zero = 0;
        int two = size - 1;

        while (one <= two) {
            if (arr[one] == 0) {
                swap(arr, one, zero);
                zero++;
                one++;
            } else if (arr[one] == 1) {
                one++;
            } else if (arr[one] == 2) {
                swap(arr, one, two);
                two--;
            }
        }
    }

    private static void sort012Sorting(int[] arr, int size) {
        // quick sort
        quickSort(arr, 0, size - 1);
    }

    private static void quickSort(int[] arr, int start, int end) {
        int pivot = (start + end) / 2;
        int left = start;
        int right = end;
        do {
            while (arr[left] < arr[pivot]) {
                left++;
            }
            while (arr[pivot] < arr[right]) {
                right--;
            }
            if (left <= right) {
                swap(arr, left, right);
                left++;
                right--;
            }
        } while (left < right);

        if (left <= end) {
            quickSort(arr, left, end);
        }
        if (start <= right) {
            quickSort(arr, start, right);
        }
    }

    private static void swap(int[] arr, int s, int d) {
        int temp = arr[s];
        arr[s] = arr[d];
        arr[d] = temp;
    }


    private static void sort012Count(int[] arr, int n) {
        int ones = 0;
        int zeros = 0;
        int twos = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                zeros++;
            } else if (arr[i] == 1) {
                ones++;
            } else if (arr[i] == 2) {
                twos++;
            }
        }
        fill(arr, 0, zeros, 0);
        fill(arr, zeros, zeros + ones, 1);
        fill(arr, zeros + ones, arr.length, 2);
    }

    private static void fill(int[] arr, int start, int end, int n) {
        for (int i = start; i < end; i++) {
            arr[i] = n;
        }
    }
}
