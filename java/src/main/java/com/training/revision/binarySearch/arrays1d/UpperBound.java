package com.training.revision.binarySearch.arrays1d;

public class UpperBound {

    public static void main(String[] args) {
        int[] arr = {-1, -1, 0, 0, 1, 1, 2, 2};
        System.out.println(upperBound(arr, -1)); // 2
        System.out.println(upperBound(arr, 0)); // 4
        System.out.println(upperBound(arr, 1)); // 6
        System.out.println(upperBound(arr, 2)); // 8
        System.out.println(upperBound(arr, 3)); // 8
    }

    private static int upperBound(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int idx = arr.length;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] <= target) {
                left = mid + 1;
            } else {
                idx = mid;
                right = mid - 1;
            }
        }
        return idx;
    }
}
