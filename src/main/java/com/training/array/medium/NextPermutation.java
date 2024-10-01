package com.training.array.medium;

import java.util.Arrays;

public class NextPermutation {

    public static void main(String[] args) {
        int[] arr = {1};
        System.out.println(Arrays.toString(arr));
        nextPermutation(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    /*
     * 123
     * 231
     * 312
     * 123
     * 132
     * 213
     * */
    private static void nextPermutation(int[] arr, int size) {
        int idx = -1;
        for (int i = size - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                idx = i;
                break;
            }
        }
        if (idx != -1) {
            for (int i = size - 1; i >= idx; i--) {
                if (arr[i] > arr[idx]) {
                    swap(arr, idx, i);
                    break;
                }
            }
        }
        quickSort(arr, idx + 1, size - 1);
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
        if (start < right) {
            quickSort(arr, start, right);
        }
        if (left < end) {
            quickSort(arr, left, end);
        }
    }

    private static void swap(int[] arr, int s, int d) {
        int temp = arr[s];
        arr[s] = arr[d];
        arr[d] = temp;
    }

//    private static String[] permutation(int[] arr, int size) {
//
//        return ;
//    }

    private static String toString(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
        }
        return sb.toString();
    }
}
