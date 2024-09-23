package com.training.sort;

import com.training.util.ArrayUtil;

import java.util.Arrays;

public class SelectionSort {

    /*
        {2, 5, 3, 4, 1, -100};
        i=0, j=0
        2, 2
        i=0,j=1
        2,5
        i=0,j=2
        2,3
        i=0,j=3
        2,4
        i=0,j=4
        2,1->Swap -> 1,2. New array = {1,5,3,4,2,-100}
        i=0,j=5
        1,-100 -> swap. New Array = {-100,5,3,4,2,1}
    */
    private static void ascending(int[] arr, int size) {
        for (int i = 0; i < size-1; i++) {
            for (int j = i+1; j < size; j++) {
                if (arr[i] > arr[j]) {
                    swap(arr, i, j);
                }
            }
        }
    }

    private static void swap(int[] arr, int start, int end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }

    private static void descending(int[] arr, int size) {
        for (int i = 0; i < size; i++) {
            for (int j = i; j < size; j++) {
                if (arr[i] < arr[j]) {
                    swap(arr, i, j);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 5, 3, 4, 1, -100};
        ArrayUtil.printArray(arr);
        long start = System.nanoTime();
        ascending(arr, arr.length);
        System.out.println("Time taken "+ (System.nanoTime()-start)/1000);
        ArrayUtil.printArray(arr);
        start = System.nanoTime();
        descending(arr, arr.length);
        System.out.println("Time taken "+ (System.nanoTime()-start)/1000);
        System.out.println(Arrays.toString(arr));
    }
}
