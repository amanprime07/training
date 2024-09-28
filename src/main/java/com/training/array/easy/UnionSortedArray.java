package com.training.array.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UnionSortedArray {

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {2, 3, 4, 4, 5};
        int[] arr = new int[arr1.length + arr2.length];
//        int n = union(arr1, arr2, arr);
//        System.out.println(Arrays.toString(arr));
        System.out.println(union(arr1, arr2));
    }

    private static List<Integer> union(int[] arr1, int[] arr2) {
        int i = 0;
        int j = 0;
        var list = new ArrayList<Integer>();
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                if (list.isEmpty() || list.get(list.size() - 1) != arr1[i]) {
                    list.add(arr1[i]);
                }
                i++;
            } else {
                if (list.isEmpty() || list.get(list.size() - 1) != arr2[j]) {
                    list.add(arr2[j]);
                }
                j++;
            }
        }
        return list;
    }

    private static int union(int[] arr1, int[] arr2, int[] arr) {
        int i = 0;
        int j = 0;
        int pos = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                arr[pos++] = arr1[i++];
            } else {
                arr[pos++] = arr2[j++];
            }
        }
        while (i < arr1.length) {
            arr[pos] = arr1[i];
            i++;
            pos++;
        }
        while (j < arr2.length) {
            arr[pos] = arr2[j];
            j++;
            pos++;
        }
        return removeDuplicates(arr, arr.length);
//        return pos;
    }

    private static int removeDuplicates(int[] arr, int length) {
        int x = 0;
        for (int i = 0; i < length; i++) {
            if (arr[x] != arr[i]) {
                x++;
                arr[x] = arr[i];
            }
        }
        return x + 1;
    }
}
