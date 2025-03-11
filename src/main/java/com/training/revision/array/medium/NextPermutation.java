package com.training.revision.array.medium;

import java.util.Arrays;

public class NextPermutation {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        System.out.println(Arrays.toString(arr));
        nextPermutation(arr);
        System.out.println(Arrays.toString(arr));
    }

//    4,2,3,1

    private static void nextPermutation(int[] arr) {
        int idx = -1;
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                idx = i;
                break;
            }
        }
        if (idx == -1) {
            reverse(arr, 0, arr.length - 1);
        }

        for (int i = arr.length - 1; i > idx; i--) {
            if (arr[i] > arr[idx]) {
                swap(arr, i, idx);
                break;
            }
        }

        reverse(arr, idx + 1, arr.length - 1);
    }

    private static void swap(int[] arr, int s, int d) {
        int temp = arr[s];
        arr[s] = arr[d];
        arr[d] = temp;
    }

    private static void reverse(int[] arr, int s, int e) {
        while (s < e) {
            swap(arr, s, e);
            s++;
            e--;
        }
    }
}
