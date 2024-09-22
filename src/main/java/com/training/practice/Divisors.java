package com.training.practice;

import java.util.Scanner;

public class Divisors {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            long start = System.nanoTime();
            System.out.println(isPrimeBruteForce(n));
            System.out.println("Time taken = " + (System.nanoTime() - start) / 1000);
            start = System.nanoTime();
//            sqrtApproach(n);
            System.out.println(isPrime(n));
            System.out.println("Time taken = " + (System.nanoTime() - start) / 1000);
        }
    }

    private static void bruteForce(int n) {
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                System.out.print(i + " ");
            }
        }
        System.out.print(n + " ");
    }

    private static void sqrtApproach(int n) {
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                System.out.print(i + " ");
                if (n / i != i) {
                    System.out.print(n / i + " ");
                }
            }
        }
    }

    private static boolean isPrime(int n) {
        int factors = 0;
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                factors++;
            }
        }
        return factors == 1;
    }

    private static boolean isPrimeBruteForce(int n) {
        int factors = 0;
        for (int i = 1; i < n; i++) {
            if (n % i == 0) {
                factors++;
            }
        }
        return factors == 1;
    }
}
