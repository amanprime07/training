package com.training.array.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumProblem {

    public static void main(String[] args) {
        int[] arr = {-2,0,1,1,2};
        System.out.println(triplet(arr, arr.length));
    }

    /*
     * Find triplet with sum 0
     *
     * -1,2,-1
     * */
    private static List<List<Integer>> triplet(int[] arr, int size) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(arr);
        int i = 0;
        int j = 1;
        int k = size - 1;
        int sum = 0;
        while (i < k && j < k) {
            sum = arr[i] + arr[j];
            int rem = -sum;
            int x = k;
            while (arr[x] != rem && x > j) {
                x--;
            }
            if ((arr[i] + arr[j] + arr[x]) == 0) {
                list.add(Arrays.asList(arr[i], arr[j], arr[x]));
            }
            i++;
            j++;
        }
        return list;
    }
}
