package com.training.basics;

import java.util.Scanner;

public class Armstrong {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            for (int i = 0; i < t; i++) {
                int n = sc.nextInt();
                long start = System.nanoTime();
                System.out.println(isArmstrong(n));
                System.out.println("Time taken = " + (System.nanoTime() - start) / 1000);
            }
        }
    }

    public static boolean isArmstrong(int n) {
        int temp = n;
        int sum = 0;
        int digits = (int) Math.log10(n) + 1;
        while (temp > 0) {
            int rem = temp % 10;
            sum = sum + (int) Math.pow(rem, digits);
            temp = temp / 10;
        }
        return sum == n;
    }
}
