package com.striver79;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        System.out.println(Arrays.toString(maxSlidingWindow(arr, k)));

        arr = new int[]{1};
        k = 1;
        System.out.println(Arrays.toString(maxSlidingWindow(arr, k)));

        arr = new int[]{5, 4, 3, 2, 1};
        k = 2;
        System.out.println(Arrays.toString(maxSlidingWindow(arr, k)));
        arr = new int[]{1, 3, 1, 2, 0, 5};
        k = 3;
        System.out.println(Arrays.toString(maxSlidingWindow(arr, k)));
    }

    private static int[] maxSlidingWindow(int[] arr, int k) {
        int n = arr.length;
        int[] ans = new int[n - k + 1];
        Deque<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (!q.isEmpty() && q.peek() <= i - k) {
                q.poll();
            }
            while (!q.isEmpty() && arr[q.peekLast()] < arr[i]) {
                q.pollLast();
            }
            q.offer(i);
            if (!q.isEmpty() && i >= k - 1) {
                ans[i - k + 1] = arr[q.peek()];
            }
        }

        return ans;
    }
}
