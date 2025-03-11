package com.training.array.easy;

import java.util.Arrays;

public class RotateArray {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        System.out.println(Arrays.toString(arr));
        int[] tempArr = Arrays.copyOf(arr, arr.length);
        rotateLeft(tempArr, arr.length, 2);
        System.out.println("rotateLeft " + Arrays.toString(tempArr));

        tempArr = Arrays.copyOf(arr, arr.length);
        System.out.println(Arrays.toString(arr));
        rotateRight(tempArr, arr.length, 2);
        System.out.println("rotateRight " + Arrays.toString(tempArr));
    }

    /*
     * Rotate Right by 2
     * IN: 1,2,3,4,5,6
     * OUT: 5,6,1,2,3,4
     * Steps for reversal:
     *   Rotate 0, n-1: 6,5,4,3,2,1
     *   Rotate 0, k-1: 5,6,4,3,2,1
     *   Rotate k, n-1: 5,6,1,2,3,4
     * */
    private static void rotateRight(int[] arr, int n, int k) {
        reverse(arr, 0, n - 1);
        reverse(arr, 0, k - 1);
        reverse(arr, k, n - 1);
    }

    /*
     * Rotate Left by 2
     * IN: 1,2,3,4,5,6
     * OUT: 3,4,5,6,1,2
     * Steps of reversal
     *   Rotate entire arr: 6,5,4,3,2,1
     *   Rotate 0, n-k: 3,4,5,6,1,2
     *   Rotate n-k, n
     * */

    private static void rotateLeft(int[] arr, int n, int k) {
        reverse(arr, 0, n - 1);
        reverse(arr, 0, n - k - 1);
        reverse(arr, n - k, n - 1);
    }

    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
