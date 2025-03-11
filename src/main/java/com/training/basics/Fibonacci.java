package com.training.basics;

public class Fibonacci {

    public static void main(String[] args) {
        iterative(15);
        System.out.println();
        printWithRecursion( 15);
    }

    private static void iterative(int n) {
        int prev = 0;
        int current = 1;
        int temp;
        System.out.print(prev + " ");
        for (int i = 1; i < n; i++) {
            System.out.print(current + " ");
            temp = current;
            current = prev + current;
            prev = temp;
        }
    }

    private static void printWithRecursion(int n){
        for(int i =0; i<n; i++){
            System.out.print(recursive(i) + " ");
        }
    }

    private static int recursive(int n) {
        if (n <= 1) {
            return n;
        }
        return recursive(n - 1) + recursive(n - 2);
    }
}
