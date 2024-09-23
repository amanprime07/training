package com.training.sort;

import com.training.util.ArrayUtil;

public class BubbleSort {

    private static void bubbleSortAsc(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length-1; j++) {
                if (arr[j + 1] < arr[j]) {
                    swap(arr, j,j+1);
                }
            }
        }
    }

    private static void bubbleSortDesc(int[] arr){
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr.length-1;j++){
                if(arr[j+1]>arr[j]){
                    swap(arr, j,j+1);
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
        System.out.print("Original Order: ");
        ArrayUtil.printArray(arr);
        System.out.print("Ascending Order: ");
        long start=System.nanoTime();
        bubbleSortAsc(arr);
        System.out.println("Time taken: " +( System.nanoTime()-start)/1000);
        ArrayUtil.printArray(arr);
        System.out.print("Descending Order: ");
        bubbleSortDesc(arr);
        ArrayUtil.printArray(arr);
    }
}
