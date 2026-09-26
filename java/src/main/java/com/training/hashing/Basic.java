package com.training.hashing;

import java.util.HashMap;
import java.util.Map;

public class Basic {

    public static void main(String[] args) {
    int[] arr = {10,5,10,15,10,5};
//        System.out.println(queryElements(15, arr));
        queryMaxMinPresentElements(arr);
    }

    private static int queryElements(int n, int[]arr){
        Map<Integer, Integer> count = new HashMap<>();
        for (int j : arr) {
            int freq = count.getOrDefault(j, 0);
            count.put(j, ++freq);
        }
        return count.getOrDefault(n,0);
    }

    private static void queryMaxMinPresentElements(int []arr){
        Map<Integer, Integer> count = new HashMap<>();
        for (int j : arr) {
            int freq = count.getOrDefault(j, 0);
            count.put(j, ++freq);
        }
        int maxCount = Integer.MIN_VALUE;
        int maxNum = -1, minNum = -1;
        int minCount = Integer.MAX_VALUE;
        for(Map.Entry<Integer, Integer> entry: count.entrySet()){
            if(maxCount <= entry.getValue()){
                maxNum = entry.getKey();
                maxCount = entry.getValue();
            }
            if(minCount>=entry.getValue()){
                minNum = entry.getKey();
                minCount = entry.getValue();
            }

        }
        System.out.printf("The frequency of %d is %d, i.e. the highest and the frequency of %d is %d i.e. the lowest.", maxNum, maxCount, minNum, minCount);
    }
}
