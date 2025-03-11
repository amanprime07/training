package com.training.revision.binarySearch.arrays1d;

public class LowerBound {

    public static void main(String[] args) {
        int[] arr = {-1, -1, 0, 0, 1, 1, 2, 2};
        System.out.println(lowerBound(arr, -1)); // 0
        System.out.println(lowerBound(arr, 0)); // 2
        System.out.println(lowerBound(arr, 1)); // 4
        System.out.println(lowerBound(arr, 2)); // 6
        System.out.println(lowerBound(arr, 3)); // 8
    }

    private static int lowerBound(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int idx = arr.length;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
                idx = mid;
            }
        }
        return idx;
    }
}
