package com.training.binarySearch.arrays1d;

public class SingleElement {

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 3, 3, 4, 5, 5, 6, 6};
//                   0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10
        System.out.println(arr[bruteForce(arr)]);
        System.out.println(searchSingleXor(arr));
        System.out.println(arr[binarySearch(arr)]);
    }

    private static int bruteForce(int[] arr) {
        int size = arr.length;
        if (arr.length == 1 || arr[0] != arr[1]) {
            return 0;
        }
        if (arr[size - 1] != arr[size - 2]) {
            return size - 1;
        }
        for (int i = 1; i <= size - 2; i++) {
            if (arr[i - 1] != arr[i] && arr[i] != arr[i + 1]) {
                return i;
            }
        }
        return -1;
    }


    private static int searchSingleXor(int[] arr) {
        int s = 0;
        for (int i = 0; i < arr.length; i++) {
            s = s ^ arr[i];
        }
        return s;
    }

    private static int binarySearch(int[] arr) {
        int size = arr.length;
        if (arr.length == 1 || arr[0] != arr[1]) {
            return 0;
        }
        if (arr[size - 1] != arr[size - 2]) {
            return size - 1;
        }
        int left = 1, right = size - 2;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid - 1] != arr[mid] && arr[mid] != arr[mid + 1]) {
                return mid;
            }
            // left half
            if ((mid % 2 == 0 && arr[mid] == arr[mid + 1]) ||
                    mid % 2 == 1 && arr[mid] == arr[mid - 1]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
