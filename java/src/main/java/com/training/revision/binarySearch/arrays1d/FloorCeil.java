package com.training.revision.binarySearch.arrays1d;

public class FloorCeil {

    public static void main(String[] args) {
        int[] arr = {3, 4, 4, 7, 8, 10};
        System.out.println(floor(arr, 5) + " " + ceil(arr, 5));
        System.out.println(floor(arr, 9) + " " + ceil(arr, 9));
        System.out.println(floor(arr, 8) + " " + ceil(arr, 8));
    }

    private static int floor(int[] arr, int target) {
        int ans = -1;
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] <= target) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }
        return ans == -1 ? -1 : arr[ans];
    }

    private static int ceil(int[] arr, int target) {
        int ans = -1;
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                ans = mid;
                right = mid - 1;
            }
        }
        return ans == -1 ? -1 : arr[ans];
    }
}
