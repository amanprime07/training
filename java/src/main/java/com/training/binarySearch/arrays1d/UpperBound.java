package com.training.binarySearch.arrays1d;

public class UpperBound {

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3};
        System.out.println(upperBound(arr, 2));
    }

    /*
     * 1,2,2,3
     * 2
     * */
    private static int upperBound(int[] arr, int s) {
        int ans = arr.length;
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] > s) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid+1;
            }
        }
        return ans;
    }
}
