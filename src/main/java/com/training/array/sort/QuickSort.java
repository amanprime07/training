package com.training.array.sort;

import java.util.Arrays;

public class QuickSort {
    private static void quickSortAsc(int[] arr) {
        quickSortAsc(arr, 0, arr.length - 1);
    }

    /*
     1,5,4,3,2,8
     pivot = 3
     1,2,4,3,5,8
     1,2,3,4,5,8
    *
    * */
    private static void quickSortAsc(int[] arr, int start, int end) {
        int pivot = (start + end) / 2;
        int left = start;
        int right = end;
        do {
            while (arr[left] < arr[pivot] && left < end) {
                left++;
            }
            while (arr[pivot] < arr[right] && right > start) {
                right--;
            }
            if (left <= right) {
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

    private static void swap(int[] arr, int start, int end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }


    public static void main(String[] args) {
        int[] arr = {4, 3, 1, 5, 2, -90, 400};
        System.out.println(Arrays.toString(arr));
        quickSortAsc(arr);
        System.out.println(Arrays.toString(arr));
        quickSortDesc(arr);
        System.out.println(Arrays.toString(arr));
    }

    /*
     1,5,4,3,2,8
     pivot = 3
     left = 0
     right = 4
     arr[pivot]=3
     arr[left]=1
     arr[right]=8

     8,5,4,3,2,1
     left =2
     right = 3
     pivot = 3
     arr[pivot]=3
     arr[left]=3
     arr[right]=3

     left = 4
     right = 2
     pivot = 3
     arr[left] = 2
     arr[pivot] = 3
     arr[right] = 4
    * */

    private static void quickSortDesc(int[] arr, int start, int end) {
        int left = start;
        int right = end;
        int pivot = (start + end) / 2;

        do {
            while (arr[left] > arr[pivot] && left < end) {
                left++;
            }
            while (arr[right] < arr[pivot] && right > start) {
                right--;
            }
            if (left <= right) {
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

    private static void quickSortDesc(int[] arr) {
        quickSortDesc(arr, 0, arr.length - 1);
    }


}
