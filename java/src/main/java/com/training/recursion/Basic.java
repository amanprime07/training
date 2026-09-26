package com.training.recursion;

public class Basic {

    public static void main(String[] args) {
        System.out.println(factorial(5));
        //        sum(0, 10);
//        System.out.println(sumN(1, 10));
//        printNumberReverse(1,10);
//        printNumber(1,10);
//        print(1,10);
    }

    public static int factorial(int n){
        if(n==0 || n==1){
            return 1;
        }
        return n*factorial(n-1);
    }

    public static int sumN(int i, int n) {
        if (i > n) {
            return 0;
        }
        return i + sumN(i + 1, n);
    }

    public static void sum(int sum, int n) {
        if (n < 1) {
            System.out.println(sum);
            return;
        }
        sum(sum + n, n - 1);
    }

    public static void printNumberReverse(int i, int n) {
        if (i == n) {
            return;
        }
        printNumberReverse(i + 1, n);
        System.out.println(i);
    }

    public static void print(int i, int n) {
        if (i == n) {
            return;
        }
        System.out.println("Bob");
        print(++i, n);
    }

    public static void printNumber(int i, int n) {
        if (i == n) {
            return;
        }
        System.out.println(i);
        printNumber(++i, n);
    }
}
