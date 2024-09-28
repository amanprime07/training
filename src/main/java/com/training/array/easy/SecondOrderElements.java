package com.training.array.easy;

import java.util.Arrays;

public class SecondOrderElements {

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 2, 3};
        System.out.println("anotherBetterApproach");
        anotherBetterApproach(arr);
        System.out.println("optimized");
        System.out.println(Arrays.toString(optimized(arr.length, arr)));
    }

    public static int[] optimized(int n, int[] arr) {
        int[] x = {-1, -1};
        if (n == 1) {
            return x;
        }
        // Write your code here.
        int min = Integer.MAX_VALUE;
        int nextMin = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int nextMax = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (arr[i] < min) {
                nextMin = min;
                min = arr[i];
            } else if (nextMin < arr[i] && arr[i] != min) {
                nextMin = arr[i];
            }
            if (arr[i] > max) {
                nextMax = max;
                max = arr[i];
            } else if (nextMax > arr[i] && arr[i] != max) {
                nextMax = arr[i];
            }
        }

        if (nextMax != Integer.MIN_VALUE) {
            x[0] = nextMax;
        }

        if (nextMin != Integer.MAX_VALUE) {
            x[1] = nextMin;
        }
        return x;
    }

    private static void betterApproach(int[] arr) {
        if (arr.length <= 1) {
            System.out.println("-1");
            System.out.println("-1");
            return;
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }
        int minDist = Integer.MAX_VALUE;
        int maxDist = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] - min != 0) {
                minDist = Math.min(arr[i] - min, minDist);
            }
            if (max - arr[i] != 0) {
                maxDist = Math.min(max - arr[i], maxDist);
            }
        }
        if (minDist < Integer.MAX_VALUE) {
            System.out.println(min + minDist);
        } else {
            System.out.println("-1");
        }
        if (maxDist < Integer.MAX_VALUE) {
            System.out.println(max - maxDist);
        } else {
            System.out.println("-1");
        }
    }

    private static void anotherBetterApproach(int[] arr) {
        int min = Integer.MAX_VALUE;
        int nextMin = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int nextMax = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            min = Math.min(arr[i], min);
            max = Math.max(arr[i], max);
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < nextMin && arr[i] != min) {
                nextMin = arr[i];
            }
            if (arr[i] > nextMax && arr[i] != max) {
                nextMax = arr[i];
            }
        }
        if (nextMin < Integer.MAX_VALUE) {
            System.out.println(nextMin);
        } else {
            System.out.println("-1");
        }
        if (nextMax > Integer.MIN_VALUE) {
            System.out.println(nextMax);
        } else {
            System.out.println("-1");
        }

    }

    private static void bruteForce(int[] arr) {
        if (arr.length == 1) {
            System.out.println("-1");
            return;
        }
        Arrays.sort(arr);
        int prev = arr[0];
        int current = prev;
        int i = 1;
        while (current == prev && i < arr.length) {
            current = arr[i];
            i++;
        }
        if (prev == current) {
            System.out.println("Next min: -1");
        } else {
            System.out.println("Next min " + current);
        }
        prev = arr[arr.length - 1];
        current = prev;
        i = arr.length - 2;
        while (current == prev && i >= 0) {
            current = arr[i];
            i--;
        }
        if (prev == current) {
            System.out.println("Next max: -1");
        } else {
            System.out.println("Next max " + current);
        }
    }
}
