package com.training.binarySearch.answers;

public class NthRootOfNumber {
    public static void main(String[] args) {
        int n = 262144;
        int pow = 9;
        long start = System.nanoTime();
        long ans = bruteForce(n, pow);
        long timeTaken = System.nanoTime() - start;
        System.out.println(ans);
        System.out.println("timeTaken " + timeTaken / 1000);
        start = System.nanoTime();
        ans = binarySearch(n, pow);
        timeTaken = System.nanoTime() - start;
        System.out.println(ans);
        System.out.println("timeTaken " + timeTaken / 1000);
    }

    private static long binarySearch(long n, int pow) {
        long left = 0;
        long right = n;
        while (left <= right) {
            long mid = (left + right) / 2;
            int val = pow(mid, n, pow);
            if (val == 0) {
                return mid;
            }
            if (val == 1) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    private static int pow(long mid, long k, int pow) {
        long ans = 1;
        for (int i = 0; i < pow; i++) {
            ans = ans * mid;
            if (ans == k) {
                return 0;
            }
            if (ans > k) {
                return 1;
            }
        }
        return -1;
    }

    private static long pow(long n, int pow) {
        long ans = 1;
        for (int i = 0; i < pow; i++) {
            ans = ans * n;
        }
        return ans;
    }

    private static int bruteForce(long n, int pow) {
        for (int i = 0; i <= n; i++) {
            long res = pow(i, pow);
            if (res == n) {
                return i;
            }
        }
        return -1;
    }
}
