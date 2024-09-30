package com.training.array.medium;

import java.util.Arrays;

public class StockBuySell {

    public static void main(String[] args) {
        int[] arr = {7, 1, 5, 3, 6, 4};
        long start = System.nanoTime();
        int n = bruteForce(arr, arr.length);
        System.out.println("Time taken: " + (System.nanoTime() - start)/1000);
        System.out.println(n);
        start = System.nanoTime();
        n = stockBuySell(arr, arr.length);
        System.out.println("Time taken: " + (System.nanoTime() - start)/1000);
        System.out.println(n);

        start = System.nanoTime();
        n = optimized(arr, arr.length);
        System.out.println("Time taken: " + (System.nanoTime() - start)/1000);
        System.out.println(n);
    }

    private static int bruteForce(int[] arr, int size) {
        int maxProfit = 0;
        int[] pos = {0, 0};
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (arr[j] > arr[i]) {
                    int profit = arr[j] - arr[i];
                    if (maxProfit < profit) {
                        maxProfit = profit;
                        pos[0] = i;
                        pos[1] = j;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(pos));
        return maxProfit;
    }

    private static int stockBuySell(int[] arr, int size) {
        int profit;
        int maxProfit = 0;
        int left = 0;
        int right = 0;
        int[] pos = {0, 0};
        while (right < size) {
            profit = arr[right] - arr[left];
            if (profit < 0) {
                profit = 0;
                left = right;
            }
            if (maxProfit < profit) {
                maxProfit = profit;
                pos[0] = left;
                pos[1] = right;
            }
            right++;
        }
        left = pos[0];
        right = pos[1];
        while (left < right) {
            profit = arr[right] - arr[left];
            if (profit > maxProfit) {
                pos[0] = left;
            }
            left++;
        }
        System.out.println(Arrays.toString(pos));
        return maxProfit;
    }

    private static int optimized(int[] arr, int size) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        int[] pos = {0, 0};
        for (int i = 0; i < size; i++) {
            if (arr[i] < minPrice) {
                minPrice = arr[i];
                pos[0] = i;
            }
            if (maxProfit < (arr[i] - minPrice)) {
                maxProfit = arr[i] - minPrice;
                pos[1] = i;
            }

        }
        System.out.println(Arrays.toString(pos));
        return maxProfit;
    }
}
