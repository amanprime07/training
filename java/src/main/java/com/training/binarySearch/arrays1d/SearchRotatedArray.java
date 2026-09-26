package com.training.binarySearch.arrays1d;

public class SearchRotatedArray {

    public static void main(String[] args) {
        int[] arr = {2,5,6,0,0,1,2};
        int pos = binarySearch(arr, 3);
        System.out.println(pos);
    }

    // returns position of element else -1
    private static int binarySearch(int[] arr, int k) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == k) {
                return mid;
            }
            if (arr[left] == arr[mid] && arr[mid] == arr[right]) {
                left++;
                right--;
                continue;
            }

            // left half sorted
            if (arr[left] <= arr[mid]) {
                if (arr[left] <= k && k <= arr[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                // right half sorted
                if (arr[mid] <= k && k <= arr[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
