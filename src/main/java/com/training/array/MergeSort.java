package com.training.array;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {100, -400, 12, 4231, 12, 99};
        System.out.println(Arrays.toString(arr));
        mergeSortAsc(arr, 0, arr.length - 1, new int[arr.length]);
        System.out.println(Arrays.toString(arr));
        mergeSortDesc(arr, 0, arr.length - 1, new int[arr.length]);
        System.out.println(Arrays.toString(arr));
    }

    private static void mergeSortDesc(int[] arr, int start, int end, int[] temp) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        mergeSortDesc(arr, start, mid, temp);
        mergeSortDesc(arr, mid + 1, end, temp);
        mergeHalvesDesc(arr, start, mid, end, temp);
    }

    private static void mergeHalvesDesc(int[] arr, int start, int mid, int end, int[] temp) {
        int left = start;
        int right = mid+1;
        int index = 0;
        while (left<=mid && right<=end){
            if(arr[left]>arr[right]){
                temp[index] = arr[left];
                left++;
            } else {
                temp[index] = arr[right];
                right++;
            }
            index++;
        }

        while (left<=mid){
            temp[index]=arr[left];
            index++;
            left++;
        }
        while (right<=end){
            temp[index]=arr[right];
            right++;
            index++;
        }

        for(int i = start; i<=end; i++){
            arr[i] = temp[i-start];
        }
    }

    private static void mergeSortAsc(int[] arr, int start, int end, int[] temp) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        mergeSortAsc(arr, start, mid, temp);
        mergeSortAsc(arr, mid + 1, end, temp);
        mergeAsc(arr, start, mid, end, temp);
    }

    private static void mergeAsc(int[] arr, int start, int mid, int end, int[] temp) {
        int left = start;
        int right = mid + 1;
        int index = 0;
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
        // iterate though left if left
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

        for (int i = start; i <= end; i++) {
            arr[i] = temp[i - start];
        }
    }
}
