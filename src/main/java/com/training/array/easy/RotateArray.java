package com.training.array.easy;

import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        System.out.println(Arrays.toString(arr));
        rotateRight(arr, arr.length, 2);
        System.out.println(Arrays.toString(arr));
    }

    /*
    1,2,3,4,5,6
    k=2
    5,6,1,2,3,4

    1,2,3,4,5,6
    6,5,4,3,2,1
    5,6,1,2,3,4
    * */
    private static void rotateRight(int[] arr, int size, int k) {
        rotate(arr, 0, size - 1); // 5,4,3,2,1
        System.out.println(Arrays.toString(arr));
        rotate(arr, 0, k - 1); // 4,5,3,2,1
        rotate(arr, k, size - 1);
    }

    /*
    1,2,3,4,5,6
    6,5,4,3,2,1
    idx=0,1,2,3,4, k=2
    3,4,5,6,1,2
    * */

    /*
    time complexity: O(n)
    Space complexity: O(1)
    * */
    private static void rotationLeft(int[] arr, int size, int k) {
        rotate(arr, 0, size - 1);
        System.out.println(Arrays.toString(arr));
        rotate(arr, 0, size-1-k-1);
        rotate(arr, size-1-k, size - 1);
    }

    private static void rotate(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    private static void swap(int[] arr, int s, int d) {
        int temp = arr[s];
        arr[s] = arr[d];
        arr[d] = temp;
    }


    /*
    time complexity: O(n*k)
    Space complexity: O(1)
    * */
    private static void bruteForceRotateLeft(int[] arr, int size, int k) {
        for (int i = 0; i < k; i++) {
            int temp = arr[0];
            for (int j = 1; j < size; j++) {
                arr[j - 1] = arr[j];
            }
            arr[size - 1] = temp;
        }
    }

    /*
    time complexity: O(n)
    Space complexity: O(n)
    * */
    private static void extraSpaceRotateLeft(int[] arr, int size, int k) {

    }
}
