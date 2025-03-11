package com.training.array.sort;

import java.util.Arrays;

public class MergeSort {


    /*
        2, 5, 4, 3, 10, -1
        mid = 2
        2,5,4    3,10,-1
        mid=1    mid = (3+5)/2 = 4
      2,5   4    3,10, -1
      mid=0      mid = (3+4)/2 = 3
      2  5  4    3  10  -1


    * */
    private static void mergeSortAsc(int[] arr, int start, int end, int[] temp) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        mergeSortAsc(arr, start, mid, temp);
        mergeSortAsc(arr, mid + 1, end, temp);
        mergeHalvesAscending(arr, start, mid, end, temp);
    }

    private static void mergeHalvesAscending(int[] arr, int start, int mid, int end, int[] temp) {
        int left = start;
        int right = mid + 1;
        int index = 0;
        while (left <= mid && right <= end) {
            if (arr[left] <= arr[right]) {
                temp[index] = arr[left];
                left++;
            } else {
                temp[index] = arr[right];
                right++;
            }
            index++;
        }
        while (left <= mid) {
            temp[index] = arr[left];
            left++;
            index++;
        }
        while (right <= end) {
            temp[index] = arr[right];
            right++;
            index++;
        }
        if (end + 1 - start >= 0) System.arraycopy(temp, 0, arr, start, end + 1 - start);
    }

    public static void main(String[] args) {
        int[] arr = {2, 5, 4, 3, 10, -1};
        System.out.println(Arrays.toString(arr));
        int[] temp = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1, temp);
        System.out.println(Arrays.toString(arr));
//        mergeSortDesc(arr, 0, arr.length - 1, temp);
//        System.out.println(Arrays.toString(arr));
    }


    private static void mergeSortDesc(int[] arr, int start, int end, int[] temp) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        mergeSortDesc(arr, start, mid, temp);
        mergeSortDesc(arr, mid + 1, end, temp);
        mergeHalvesDescending(arr, start, mid, end, temp);
    }

    private static void mergeHalvesDescending(int[] arr, int start, int mid, int end, int[] temp) {
        int left = start;
        int right = mid + 1;
        int index = 0;
        while (left <= mid && right <= end) {
            if (arr[left] > arr[right]) {
                temp[index] = arr[left];
                left++;
            } else {
                temp[index] = arr[right];
                right++;
            }
            index++;
        }
        while (left <= mid) {
            temp[index] = arr[left];
            index++;
            left++;
        }
        while (right <= end) {
            temp[index] = arr[right];
            index++;
            right++;
        }

        if (end + 1 - start >= 0) System.arraycopy(temp, 0, arr, start, end + 1 - start);
    }

    private static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        mergeSort(arr, left, mid, temp);
        mergeSort(arr, mid + 1, right, temp);
        mergeHalves(arr, left, mid, right, temp);
    }

    private static void mergeHalves(int[] arr, int start, int mid, int end, int[] temp) {
        int index = 0;
        int left = start;
        int right = mid + 1;
        while (left <= mid && right <= end) {
            if (arr[left] < arr[right]) {
                temp[index] = arr[left];
                left++;
            } else {
                temp[index] = arr[right];
                right++;
            }
            index++;
        }
        while (left < mid) {
            temp[index] = arr[left];
            left++;
            index++;
        }
        while (right < end) {
            temp[index] = arr[right];
            index++;
            right++;
        }
        for (int i = start; i <= end; i++) {
            arr[i] = temp[i - start];
        }
    }

}
