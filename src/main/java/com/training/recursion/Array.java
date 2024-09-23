package com.training.recursion;

import java.util.Arrays;

public class Array {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(bruteForce(arr)));
        System.out.println(Arrays.toString(spaceOptimized(arr)));
        System.out.println(Arrays.toString(recursive(arr, 0, arr.length - 1)));
    }

    public static int[] bruteForce(int[] array) {
        int[] arr = new int[array.length];
        for (int i = array.length - 1; i >= 0; i--) {
            arr[array.length - i - 1] = array[i];
        }
        return arr;
    }

    public static int[] spaceOptimized(int[] a) {
        int start = 0;
        int end = a.length - 1;
        while (start < end) {
            swap(a, start, end);
            start++;
            end--;
        }
        return a;
    }

    public static int[] recursive(int[] a, int start, int end) {
        if (start >= end) {
            return a;
        }
        swap(a, start, end);
        return recursive(a, start+1, end-1);
    }

    public static void swap(int[] a, int s, int d) {
        int temp = a[s];
        a[s] = a[d];
        a[d] = temp;
    }


}
