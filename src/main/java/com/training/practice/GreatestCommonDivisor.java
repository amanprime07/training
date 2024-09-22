package com.training.practice;

import java.util.Scanner;

public class GreatestCommonDivisor {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            for (int i = 0; i < t; i++) {
                int m = sc.nextInt();
                int n = sc.nextInt();
                long start = System.nanoTime();
                System.out.println(bruteForce(m, n));
                System.out.println("Time taken = " + (System.nanoTime() - start) / 1000);
                start = System.nanoTime();
                System.out.println(betterBruteForce(m, n));
                System.out.println("Time taken = " + (System.nanoTime() - start) / 1000);
                start = System.nanoTime();
                System.out.println(euclideanAlgo(m, n));
                System.out.println("Time taken = " + (System.nanoTime() - start) / 1000);
            }
        }
    }

    public static int euclideanAlgo(int m, int n) {
        if (m == 0) {
            return n;
        }
        return euclideanAlgo(n % m, m);
    }

    public static int bruteForce(int m, int n) {
        int count = Math.min(m, n);
        int gcd = 1;
        for (int i = 1; i <= count; i++) {
            if (m % i == 0 && n % i == 0) {
                gcd = Math.max(i, gcd);
            }
        }
        return gcd;
    }

    public static int betterBruteForce(int m, int n) {
        int count = Math.min(m, n);
        int gcd = 1;
        for (int i = count; i > 0; i--) {
            if (m % i == 0 && n % i == 0) {
                gcd = Math.max(i, gcd);
            }
        }
        return gcd;
    }
}
