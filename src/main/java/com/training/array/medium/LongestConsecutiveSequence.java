package com.training.array.medium;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        int[] arr = {5, 8, 3, 2, 1, 4, 9, 7, 10, 11, 12, 13};
        System.out.println(longestConsecutiveSequenceSorting(arr, arr.length));
        System.out.println(longestConsecutiveSequenceSet(arr, arr.length));
    }

    private static int bruteForce(int[] arr, int size) {
        int maxCount = 0;
        for (int i = 0; i < size; i++) {
            int x = arr[i];
            int count = 1;
            while (linearSearch(arr, x + 1)) {
                count++;
                x++;
            }
            maxCount = Math.max(count, maxCount);
        }
        return maxCount;
    }

    private static boolean linearSearch(int[] arr, int x) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                return true;
            }
        }
        return false;
    }

    /*
    5,8,3,2,1,4
    * */
    private static int longestConsecutiveSequenceSet(int[] arr, int size) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < size; i++) {
            set.add(arr[i]);
        }
        int maxCount = 0;
        for (var i : set) {
            if(!set.contains(i-1)) {
                int count = 0;
                int n = i;
                while (set.contains(n++)) {
                    count++;
                    maxCount = Math.max(maxCount, count);
                }
            }
        }
        return maxCount;
    }

    private static int longestConsecutiveSequenceSorting(int[] arr, int size) {
        sort(arr);
        int len = 1;
        int maxLen = 1;
        for (int i = 1; i < size; i++) {
            if (arr[i] - 1 == arr[i - 1]) {
                len++;
                maxLen = Math.max(len, maxLen);
            } else {
                len = 1;
            }
        }
        return maxLen;
    }

    //    merge sort
    private static void sort(int[] arr) {
        int[] temp = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1, temp);
    }

    private static void mergeSort(int[] arr, int start, int end, int[] temp) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        mergeSort(arr, start, mid, temp);
        mergeSort(arr, mid + 1, end, temp);
        mergeHalves(arr, start, mid, end, temp);
    }

    private static void mergeHalves(int[] arr, int start, int mid, int end, int[] temp) {
        int x = 0;
        int left = start;
        int right = mid + 1;

        while (left <= mid && right <= end) {
            if (arr[left] <= arr[right]) {
                temp[x] = arr[left];
                left++;
            } else {
                temp[x] = arr[right];
                right++;
            }
            x++;
        }
        while (left <= mid) {
            temp[x] = arr[left];
            left++;
            x++;
        }
        while (right <= end) {
            temp[x] = arr[right];
            right++;
            x++;
        }
        for (int i = start; i <= end; i++) {
            arr[i] = temp[i - start];
        }
    }
}
