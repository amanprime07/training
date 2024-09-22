package com.training.practice;

import jdk.jfr.Timespan;

import java.util.Scanner;

public class CountDigits {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int t = scanner.nextInt();
            for (int i = 1; i <= t; i++) {
                long n = scanner.nextLong();
                long start = System.nanoTime();
                bruteForce(n);
                System.out.println("Time " + (System.nanoTime() - start));
                start = System.nanoTime();
                optimized(n);
                System.out.println("Time " + (System.nanoTime() - start));
            }
        }
    }

    public static void bruteForce(long n) {
        int count = 0;
        do {
            n = n / 10;
            count++;
        } while (n != 0);
        System.out.println("bruteForce " + count);
    }

    public static void optimized(long n) {
        int cnt = (int) (Math.log10(n) + 1);
        System.out.println("optimized " + cnt);
    }


}
