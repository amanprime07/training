package com.training.array.sort;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class QuickSort {

    private static void quickSortAsc(int[] arr) {
        quickSortAsc(arr, 0, arr.length - 1);
    }

    private static void quickSortAsc(int[] arr, int start, int end) {
        int left = start;
        int right = end;
        int pivot = arr[(left + right)/ 2] ;
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
            quickSortAsc(arr, left, end);
        }
        if (start < right) {
            quickSortAsc(arr, start, right);
        }
    }


    private static void swap(int[] arr, int start, int end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }

    public static void quickSort(List<Integer> arr) {
        // Write your code here.
        quickSort(arr, 0, arr.size() - 1);
    }

    private static void quickSort(List<Integer> arr, int start, int end) {
        int left = start;
        int right = end;
        int pivotVal = arr.get((left + right) / 2);
        do {
            while (arr.get(left) < pivotVal) {
                left++;
            }
            while (pivotVal < arr.get(right)) {
                right--;
            }
            if (left <= right) {
                swap(arr, left, right);
                left++;
                right--;
            }
        } while (left <= right);
        if (start < right) {
            quickSort(arr, start, right);
        }
        if (left < end) {
            quickSort(arr, left, end);
        }
    }

    private static void swap(List<Integer> arr, int s, int d) {
        int temp = arr.get(s);
        arr.set(s, arr.get(d));
        arr.set(d, temp);
    }


    public static void main(String[] args) {
        int[] arr = {137515, 266567, 777013, -878339, 266386, -562525, -630611, -833218, 37965, 21121, 568807, -723810, 37458, 812878, -930721, 24322, -945619, 506568, -857016, -984393, -826500, 116976, 569877, 972200, 904715, 846571, 517272, 247119, -767309, 543506, 596374, -549444, 611329, 743422, 469208, 31027, -578828, 427750, -725559, -511203, 110731, -415254, -95874, 440236, -206925, -151270, 434493, 744606, -105195, -16136, -757338, -727831};
        var l = Arrays.stream(arr).boxed().collect(Collectors.toList());
        quickSort(l);
        System.out.println(l);
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
        int pivot = arr[(start + end) / 2];

        do {
            while (arr[left] > pivot) {
                left++;
            }
            while (arr[right] < pivot) {
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
        if (start < right) {
            quickSortDesc(arr, start, right);
        }
    }

    private static void quickSortDesc(int[] arr) {
        quickSortDesc(arr, 0, arr.length - 1);
    }


}
