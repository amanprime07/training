package com.training.revision.binarySearch.arrays1d;

public class SearchRotatedArray {

    public static void main(String[] args) {
        int[] arr = {5, 1, 2, 2, 3, 4, 4, 5};
        System.out.println(search(arr, 3));
        System.out.println(search(arr, 2));
        System.out.println(search(arr, 6));
    }

    private static int search(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                return mid;
            }

            if (arr[left] == arr[mid] && arr[mid] == arr[right]) {
                left++;
                right--;
                continue;
            }

            if (arr[left] < arr[mid]) { // left half sorted
                if (arr[left] <= target && target <= arr[mid]) {
                    // element in left half
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                // right half sorted
                if (arr[mid] <= target && target <= arr[right]) {
                    // element in right half
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
