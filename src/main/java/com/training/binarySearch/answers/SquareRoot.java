package com.training.binarySearch.answers;

public class SquareRoot {

    public static void main(String[] args) {
        long n = (long) Math.pow(999, 2);
        long start = System.nanoTime();
        long ans = bruteForce(n);
        long timeTaken = System.nanoTime()-start;
        System.out.println(ans);
        System.out.println("bruteForce time: " + timeTaken);
        start = System.nanoTime();
        ans  = builtIn(n);
        timeTaken = System.nanoTime()-start;
        System.out.println(ans);
        System.out.println("builtIn time: " + timeTaken);
        start = System.nanoTime();
        ans = binarySearch(n);
        timeTaken = System.nanoTime()-start;
        System.out.println(ans);
        System.out.println("binarySearch time: " + timeTaken);
    }

    private static long bruteForce(long n) {
        long ans = -1;
        long i = 1;
        while (i * i <= n) {
            ans = i;
            i++;
        }
        return ans;
    }

    private static long builtIn(long n) {
        return (long) Math.sqrt(n);
    }

    private static long binarySearch(long n) {
        long left = 1, right = n;
        long ans = -1;
        while (left <= right) {
            long mid = (left + right) / 2;
            long sq = mid * mid;
            if (sq <= n) {
                left = mid + 1;
                ans = mid;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }
}
