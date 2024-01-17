package com.training.sort;

import com.training.util.ArrayUtil;

public class BubbleSort {

    private static void bubbleSort(int[] arr, boolean asc){
        for(int i =0; i< arr.length; i++){
            for(int j=0; j<arr.length-1; j++){
                if(asc){
                    if(arr[j]>arr[j+1]){
                        ArrayUtil.swap(arr, j, j+1);
                    }
                }else {
                    if(arr[j+1]>arr[j]){
                        ArrayUtil.swap(arr, j, j+1);
                    }
                }

            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,4,5,3,2};
        System.out.print("Original Order: ");
        ArrayUtil.printArray(arr);
        System.out.print("Ascending Order: ");
        bubbleSort(arr, true);
        ArrayUtil.printArray(arr);
        System.out.print("Descending Order");
        bubbleSort(arr, false);
        ArrayUtil.printArray(arr);
    }
}
