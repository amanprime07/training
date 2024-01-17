package com.training.util;

public class ArrayUtil {

    public static void swap(int[] arr, int source, int destination) {
        int temp = arr[source];
        arr[source] = arr[destination];
        arr[destination]= temp;
    }

    public static void swapXor(int[] arr, int source, int destination) {
        arr[source] = arr[source] ^ arr[destination];
        arr[destination] = arr[source] ^ arr[destination];
        arr[source] = arr[source] ^ arr[destination];
    }

    public static void printArray(int[] arr) {
        for(int i :arr){
            System.out.print(i+ " ");
        }
        System.out.println();
    }
}
