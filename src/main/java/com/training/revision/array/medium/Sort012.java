package com.training.revision.array.medium;

import java.util.Arrays;

public class Sort012 {

    public static void main(String[] args) {
        int[] arr = {1, 1, 0, 0, 0, 2, 2, 2};

        int zero = 0, one = 0, two = arr.length - 1;

        while (one < two) {
            if (arr[one] == 0) {
                swap(arr, zero, one);
                zero++;
                one++;
            }
            if (arr[one] == 1) {
                one++;
            }
            if (arr[one] == 2) {
                swap(arr, one, two);
                one++;
                two--;
            }
        }

        System.out.println(Arrays.toString(arr));
    }

    private static void swap(int[] arr, int s, int d) {
        int temp = arr[s];
        arr[s] = arr[d];
        arr[d] = temp;
    }
}
