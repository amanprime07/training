package com.training.binarySearch.arrays1d;

public class FirstAndLastOccurrence {

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 3, 3, 3, 3};
        System.out.println(firstOccurrence(arr, 3));
        System.out.println(lastOccurrence(arr, 3));
    }

    private static int firstOccurrence(int[] arr, int n) {
        int left = 0;
        int right = arr.length - 1;
        int ans = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == n) {
                ans = mid;
                right = mid - 1;
            } else if (arr[mid] < n) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    private static int lastOccurrence(int[] arr, int n) {
        int left = 0;
        int right = arr.length - 1;
        int ans = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == n) {
                ans = mid;
                left = mid + 1;
            } else if (arr[mid] < n) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }
}
