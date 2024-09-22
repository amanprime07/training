package com.training.practice;

import java.util.ArrayList;
import java.util.Arrays;

public class ReverseArray {

    public static void main(String[] args) {
        var list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        reverseArray(list, 3);
        System.out.println(list);
    }

    public static void reverseArray(ArrayList<Integer> arr, int m) {
        // Write your code here.
        for (int i = m + 1; i < arr.size()-m/2; i++) {
            int temp = arr.get(i); // 5
            arr.set(i, arr.get(arr.size() - i + m - 1+1)); // 5->
            arr.set(arr.size() - i + m - 1+1, temp);
        }
    }
}
