package com.training.binarySearch.arrays1d;

public class MinimumInRotatedArray {
    public static void main(String[] args) {
        int[] arr = {4, 5, -1, 1, 2, 3};
        long start = System.nanoTime();
        var i = minimum(arr);
        long timeTaken = System.nanoTime()-start;
        System.out.println(timeTaken/1000);
        System.out.println(i);
        start = System.nanoTime();
        i = optimizedMinimum(arr);
        timeTaken = System.nanoTime()-start;
        System.out.println(timeTaken/1000);
        System.out.println(i);
    }

    //    {4, 5, 1, 2, 3, 3, 3};
    private static int minimum(int[] arr) {
        int left = 0, right = arr.length - 1;
        int min = Integer.MAX_VALUE;
        while (left <= right) {
            int mid = (left + right) / 2;
            // left sorted
            if (arr[left] <= arr[mid]) {
                min = Math.min(min, arr[left]);
                left = mid + 1;
            } else {
                // right sorted
                min = Math.min(min, arr[mid]);
                right = mid - 1;
            }
        }
        return min;
    }

    private static int optimizedMinimum(int[] arr) {
        int left = 0, right = arr.length - 1;
        int min = Integer.MAX_VALUE;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[left] <= arr[right]) {
                min = Math.min(min, arr[left]);
            }
            if(arr[left]<=arr[mid]){
                min = Math.min(min, arr[left]);
                left = mid+1;
            } else {
                min = Math.min(min, arr[mid]);
                right = mid-1;
            }
        }
        return min;
    }


    public static int bruteForce(int[] arr) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }
}
