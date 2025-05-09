package com.training.heap;

import java.util.*;

public class TopKFrequent {

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 2, 2, 3};
        int k = 2;
        System.out.println(Arrays.toString(topKFrequentHeap(arr, k)));
        System.out.println(Arrays.toString(topKFrequentArray(arr, k)));
        arr = new int[]{4, 1, -1, 2, -1, 2, 3};
        System.out.println(Arrays.toString(topKFrequentArray(arr, k)));

        arr = new int[]{4};
        k = 1;
        System.out.println(Arrays.toString(topKFrequentArray(arr, k)));
    }

    private static int[] topKFrequentArray(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int n : nums) {
            int f = freq.getOrDefault(n, 0);
            freq.put(n, f + 1);
        }

        List<List<Integer>> list = new ArrayList<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            list.add(i, new ArrayList<>());
        }
        for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
            List<Integer> l = list.get(e.getValue() - 1);
            l.add(e.getKey());
        }
        int[] arr = new int[k];
        int idx = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            for (Integer x : list.get(i)) {
                arr[idx] = x;
                idx++;
                if (idx == k) {
                    return arr;
                }
            }
        }
        return arr;

    }

    private static int[] topKFrequentHeap(int[] nums, int k) {
        Queue<NumFrequency> q = new PriorityQueue<>();
        Map<Integer, NumFrequency> map = new HashMap<>();
        for (int i : nums) {
            NumFrequency nf = map.getOrDefault(i, new NumFrequency());
            nf.freq += 1;
            nf.val = i;
            map.put(i, nf);
        }
        for (NumFrequency nf : map.values()) {
            q.add(nf);
        }

        while (q.size() > k) {
            q.poll();
        }
        int[] topK = new int[k];

        for (int i = 0; i < k; i++) {
            NumFrequency nf = q.poll();
            topK[i] = nf.val;
        }
        return topK;
    }

    private static class NumFrequency implements Comparable<NumFrequency> {
        int val;
        int freq;

        @Override
        public int compareTo(NumFrequency o) {
            return this.freq - o.freq;
        }
    }
}
