package com.training.array.easy;

import java.util.Map;

public class LargestElement {

    public static void main(String[] args) {
        int[] arr = {1, 4, 5, 3, 2};
        largestElement(arr, arr.length);
        System.out.println(largestElementRecursive(arr, arr.length - 1));
    }

    /*
    Largest Element in an Array
    * */
    private static void largestElement(int[] arr, int size) {
        int max = Integer.MIN_VALUE;
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (arr[i] > max) {
                max = arr[i];
                index = i;
            }
        }
        System.out.printf("Found %d at position %d\n", max, (index + 1));
    }

    /*
    Largest Element in an Array recursive
    * */
    private static int largestElementRecursive(int[] arr, int size) {
        if (size == 0) {
            return arr[0];
        }
        return Math.max(arr[size], largestElementRecursive(arr, size - 1));
    }
}
