package com.training.sort;

import java.util.Arrays;

public class MergeSort {

    private static void mergeSort(int[] arr, int leftStart, int rightEnd, int[] temp, boolean ascending) {
        if (leftStart >= rightEnd) {
            return;
        }
        int mid = (leftStart + rightEnd) / 2;
        mergeSort(arr, 0, mid, temp, ascending);
        mergeSort(arr, mid + 1, rightEnd, temp, ascending);
        if(ascending)
            mergeHalvesAscending(arr, leftStart, rightEnd, temp);
        mergeHalvesDescending(arr, leftStart, rightEnd, temp);
    }

    private static void mergeHalvesAscending(int[] arr, int leftStart, int rightEnd, int[] temp) {
        int leftEnd = (leftStart + rightEnd) / 2;
        int rightStart = leftEnd + 1;
        int index = leftStart;
        int size = rightEnd - leftStart + 1;

        int left = leftStart;
        while (leftStart <= leftEnd && rightStart <= rightEnd) {
            if (arr[leftStart] <= arr[rightStart]) {
                temp[index] = arr[leftStart];
                leftStart++;
            } else {
                temp[index] = arr[rightStart];
                rightStart++;

            }
            index++;
        }
        while (leftStart <= leftEnd) {
            temp[index] = arr[leftStart];
            index++;
            leftStart++;
        }
        while (rightStart <= rightEnd) {
            temp[index] = arr[rightStart];
            index++;
            rightStart++;
        }
        System.arraycopy(temp, left, arr, left, size);
    }

    private static void mergeHalvesDescending(int[] arr, int leftStart, int rightEnd, int[] temp) {
        int leftEnd = (leftStart + rightEnd) / 2;
        int rightStart = leftEnd + 1;
        int index = leftStart;
        int size = rightEnd - leftStart + 1;
        int left = leftStart;
        while (leftStart <= leftEnd && rightStart <= rightEnd) {
            if (arr[leftStart] > arr[rightStart]) {
                temp[index] = arr[leftStart];
                leftStart++;
            } else {
                temp[index] = arr[rightStart];
                rightStart++;

            }
            index++;
        }
        while (leftStart <= leftEnd) {
            temp[index] = arr[leftStart];
            index++;
            leftStart++;
        }
        while (rightStart <= rightEnd) {
            temp[index] = arr[rightStart];
            index++;
            rightStart++;
        }
        System.arraycopy(temp, left, arr, left, size);
    }

    public static void main(String[] args) {
        int[] a = {2, 5, 4, 3, 10, -1};
        boolean ascending = false;
        System.out.println(Arrays.toString(a));
        mergeSort(a, 0, 5, new int[a.length], ascending);
        System.out.println(Arrays.toString(a));
    }

}
