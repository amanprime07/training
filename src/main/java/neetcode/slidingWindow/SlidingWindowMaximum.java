package neetcode.slidingWindow;

import java.util.*;

public class SlidingWindowMaximum {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        long start = System.nanoTime();
        int[] ans = maximumUsingHeap(arr, 3);
        long dr = System.nanoTime() - start;
        System.out.println(Arrays.toString(ans) + " time-> " + dr);

        start = System.nanoTime();
        ans = maximumUsingDeque(arr, 3);
        dr = System.nanoTime() - start;
        System.out.println(Arrays.toString(ans) + " time -> " + dr);

        arr = new int[]{1};
        start = System.nanoTime();
        ans = maximumUsingHeap(arr, 1);
        dr = System.nanoTime() - start;
        System.out.println(Arrays.toString(ans) + " time -> " + dr);


        start = System.nanoTime();
        ans = maximumUsingDeque(arr, 1);
        dr = System.nanoTime() - start;
        System.out.println(Arrays.toString(ans) + " time -> " + dr);
    }

    private record Pair(int v, int idx) {
    }

    /*
     * {1, 3, -1, -3, 5, 3, 6, 7};
     *
     *
     * [1,3]
     * */
    private static int[] maximumUsingDeque(int[] arr, int k) {
        Deque<Integer> q = new LinkedList<>();
        int[] ans = new int[arr.length - k + 1];

        for (int i = 0; i < arr.length; i++) {
            while (!q.isEmpty() && q.peek() < i - k) {
                q.poll();
            }
            while (!q.isEmpty() && arr[q.peekLast()] < arr[i]) {
                q.pollLast();
            }
            q.offer(i);
            if (!q.isEmpty() && i - k + 1 >= 0) {
                ans[i - k + 1] = arr[q.peek()];
            }
        }
        return ans;
    }

    private static int[] maximumUsingHeap(int[] arr, int k) {
        Queue<Pair> q = new PriorityQueue<>((a, b) -> b.v - a.v);// max heap
        int[] ans = new int[arr.length - k + 1];
        int r = 0;
        for (; r < k; r++) {
            q.offer(new Pair(arr[r], r));
        }
        if (!q.isEmpty()) {
            ans[0] = (q.peek().v);
        }

        while (r < arr.length) {
            while (!q.isEmpty() && q.peek().idx < r - k) {
                q.poll();
            }
            q.offer(new Pair(arr[r], r));
            if (!q.isEmpty()) {
                ans[r - k + 1] = (q.peek().v);
            }
            r++;
        }
        return ans;
    }
}
