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

        arr = new int[]{1, -1};
        start = System.nanoTime();
        ans = maximumUsingHeap(arr, 1);
        dr = System.nanoTime() - start;
        System.out.println(Arrays.toString(ans) + " time -> " + dr);


        start = System.nanoTime();
        ans = maximumUsingDeque(arr, 1);
        dr = System.nanoTime() - start;
        System.out.println(Arrays.toString(ans) + " time -> " + dr);
    }

    private record Pair(int v, int i) {
    }

    private static int[] maximumUsingHeap(int[] nums, int k) {
        int size = nums.length;
        int[] ans = new int[size - k + 1];
        Queue<Pair> q = new PriorityQueue<>((a, b) -> b.v - a.v); // max heap
        for (int r = 0; r < size; r++) {
            q.offer(new Pair(nums[r], r));
            while (!q.isEmpty() && r - q.peek().i > k - 1) {
                q.poll();
            }
            if (!q.isEmpty() && r - k + 1 >= 0) {
                ans[r - k + 1] = q.peek().v;
            }
        }
        return ans;
    }

    /*
     * idx = 0, 1,  2,  3, 4, 5, 6, 7
     * ele = 1, 3, -1, -3, 5, 3, 6, 7
     * */
    private static int[] maximumUsingDeque(int[] nums, int k) {
        int l = nums.length;
        int[] ans = new int[l - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < l; i++) {
            // push element in increasing order.
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.offer(i);

            // check valid window
            while (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll();
            }

            if (!deque.isEmpty() && i - k + 1 >= 0) {
                ans[i - k + 1] = nums[deque.peek()];
            }
        }
        return ans;
    }
}
