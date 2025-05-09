package neetcode.arraysHashing;

import java.util.*;

public class TopKFrequentElement {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 1, 2, 2, 3};
        System.out.println(Arrays.toString(topKFrequentHeap(arr, 2)));
        System.out.println(Arrays.toString(topKFrequentList(arr, 2)));

        arr = new int[]{1};
        System.out.println(Arrays.toString(topKFrequentHeap(arr, 1)));
        System.out.println(Arrays.toString(topKFrequentList(arr, 1)));
    }

    private record Pair(int v, int freq) {

    }


    private static int[] topKFrequentList(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        List<List<Integer>> freqList = new ArrayList<>();

        for (int i : nums) {
            int f = freqMap.getOrDefault(i, 0);
            freqMap.put(i, f + 1);
            freqList.add(new ArrayList<>());
        }

        for (Map.Entry<Integer, Integer> e : freqMap.entrySet()) {
            List<Integer> list = freqList.get(e.getValue() - 1);
            list.add(e.getKey());
        }

        int[] ans = new int[k];
        int idx = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j : freqList.get(i)) {
                ans[idx] = j;
                idx++;
                if (idx == k) {
                    return ans;
                }
            }
        }
        return ans;
    }

    private static int[] topKFrequentHeap(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        Queue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.freq));
        for (int i : nums) {
            int f = freq.getOrDefault(i, 0);
            freq.put(i, f + 1);
        }

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            pq.offer(new Pair(entry.getKey(), entry.getValue()));
            if (pq.size() > k) {
                pq.poll();
            }
        }

        int[] ans = new int[k];
        int i = 0;
        while (!pq.isEmpty()) {
            ans[i] = pq.poll().v;
            i++;
        }
        return ans;

    }
}
