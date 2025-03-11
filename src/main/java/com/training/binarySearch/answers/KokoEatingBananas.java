package com.training.binarySearch.answers;

public class KokoEatingBananas {

    public static void main(String[] args) {
        int[] arr = {7, 15, 6, 3};
        int h = 8;
        System.out.println(minimumTime(arr, h));
    }

    private static int minimumTime(int[] arr, int h) {
        int left = 1;
        int right = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            right = Math.max(right, arr[i]);
        }

        while (left < right) {
            int mid = (left + right) / 2;
            int hrs = hoursSpent(arr, mid);
            if (hrs <= h) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    private static int hoursSpent(int[] arr, int num) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            count += (int) Math.ceil((double) arr[i] / num);
        }
        return count;
    }
}
