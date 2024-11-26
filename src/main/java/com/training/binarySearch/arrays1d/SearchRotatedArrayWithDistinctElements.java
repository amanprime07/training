package com.training.binarySearch.arrays1d;

public class SearchRotatedArrayWithDistinctElements {

    public static void main(String[] args) {
        int[] arr = {4, 5, 1, 2, 3};
        int pos = binarySearch(arr, 1);
        System.out.println(pos);
    }

    private static int bruteForce(int[] arr, int n) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == n) {
                return i;
            }
        }
        return -1;
    }


    // 4,5,1,2,3
    private static int binarySearch(int[] arr, int n) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == n) {
                return mid;
            }
            if (arr[left] <= arr[mid]) {
                if (arr[left] <= n && n <= arr[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (arr[mid] <= n && n <= arr[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
