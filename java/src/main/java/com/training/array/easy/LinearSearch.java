package com.training.array.easy;

public class LinearSearch {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 9};
        System.out.println(search(arr, arr.length, 6));
        System.out.println(search(arr, arr.length, 5));
    }

    private static int search(int[] arr, int n, int el) {
        for (int i = 0; i < n; i++) {
            if (arr[i] == el) {
                return i + 1;
            }
        }
        return -1;
    }
}
