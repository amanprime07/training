package com.training.array.medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LeadersInArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2, 1};
        List<Integer> list = leaders(arr, arr.length);
        list.sort(Comparator.reverseOrder());
        System.out.println(list);
    }

    /*
    arr[i] > arr[i+1..n]
    */
    private static List<Integer> leaders(int[] arr, int size) {
        List<Integer> list = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for (int i = arr.length - 1; i > 0; i--) {
            if (arr[i] > max) {
                list.add(arr[i]);
                max = arr[i];
            }
        }
        return list;
    }
}
