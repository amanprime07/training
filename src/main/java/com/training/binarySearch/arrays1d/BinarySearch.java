package com.training.binarySearch.arrays1d;

public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(findX(arr, 1));
        System.out.println(findX(arr, 5));
        System.out.println(findX(arr, 0, arr.length - 1, 6));
    }

    private static int findX(int[] arr, int s) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] < s) {
                left = mid + 1;
            } else if (arr[mid] > s) {
                right = mid - 1;
            } else if (arr[mid] == s) {
                return mid;
            }
        }
        return -1;
    }

    private static int findX(int[] arr, int left, int right, int s) {
        int mid = (left + right) / 2;
        if (left > right) {
            return -1;
        }
        if (arr[mid] == s) {
            return mid;
        } else if (arr[mid] > s) {
            right = mid - 1;
        } else {
            left = mid + 1;
        }
        return findX(arr, left, right, s);
    }
}
