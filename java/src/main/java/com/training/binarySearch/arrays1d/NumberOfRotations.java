package com.training.binarySearch.arrays1d;

public class NumberOfRotations {

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 1, 2, 3};
        System.out.println(bruteForce(arr));
        System.out.println(rotationsWithBinarySearch(arr));
    }

    private static int bruteForce(int[] arr) {
        int min = Integer.MAX_VALUE;
        int idx = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                idx = i;
                min = arr[i];
            }
        }
        return idx;
    }
// number of rotations is equal to the position of minimum element.
    private static int rotationsWithBinarySearch(int[] arr) {
        int idx = -1;
        int min = Integer.MAX_VALUE;
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[left] <= arr[right]) {
                if (arr[left] < min) {
                    min = arr[left];
                    idx = left;
                    break;

                }
            }
            // left half sorted
            if (arr[left] <= arr[mid]) {
                if (arr[left] < min) {
                    min = arr[left];
                    idx = left;
                }
                left = mid + 1;
            }
            // right half sorted
            else {
                if (arr[mid] < min) {
                    min = arr[mid];
                    idx = mid;
                }
                right = mid - 1;
            }
        }
        return idx;
    }
}
