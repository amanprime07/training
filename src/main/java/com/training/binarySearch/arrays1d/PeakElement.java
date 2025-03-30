package com.training.binarySearch.arrays1d;

public class PeakElement {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 4, 3, 1};
        System.out.println(arr[peak(arr)]);
        System.out.println(arr[binarySearch(arr)]);
    }

    private static int peak(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if ((i == 0 || arr[i] > arr[i - 1]) && (i == arr.length - 1 || arr[i] > arr[i + 1])) {
                return i;
            }
        }
        return -1;
    }

    private static int binarySearch(int[] arr) {
        int size = arr.length;
        if (size == 1 || arr[0] > arr[1]) {
            return 0;
        }
        if (arr[size - 1] > arr[size - 2]) {
            return size - 1;
        }
        int left = 1;
        int right = arr.length - 2;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid - 1] < arr[mid] && arr[mid] > arr[mid + 1]) {
                return mid;
            }

            if (arr[mid - 1] < arr[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
