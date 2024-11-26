package com.training.binarySearch.arrays1d;

public class LowerBound {

    public static void main(String[] args) {

        int[] arr = {1, 1, 3, 3, 4};
        System.out.println(findLowerBoundX(arr, 2));

    }

    private static int findLowerBoundX(int[] arr, int s) {
        int left = 0;
        int right = arr.length - 1;
        int ans = arr.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] >= s) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}
