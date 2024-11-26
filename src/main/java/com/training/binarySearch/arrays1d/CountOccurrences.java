package com.training.binarySearch.arrays1d;

public class CountOccurrences {

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 3, 3, 3, 4};
        System.out.println(countOccurrences(arr, 5));
    }

    private static int countOccurrences(int[] arr, int n) {
        int last = lastOccurrence(arr, n);
        if (last == -1) {
            return 0;
        }
        int first = firstOccurrence(arr, n);
        return last - first + 1;
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
