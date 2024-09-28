package com.training.array.easy;

import java.util.Arrays;

public class MoveZerosToEnd {
    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 2, 3, 0, 1};
        System.out.println(Arrays.toString(arr));
        moveZeros(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    private static void moveZeros(int[] arr, int size) {
        int x = 0;
        for (int i = 0; i < size; i++) {
            if (arr[i] != 0) {
                arr[x] = arr[i];
                x++;
            }
        }
        for (int i = x; i < size; i++) {
            arr[i] = 0;
        }
    }
}
