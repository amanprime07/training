package com.training.basics;

public class ReverseDigits {

    public static void main(String[] args) {
        System.out.println(reverse(-1234));
    }


    public static int reverse(int x) {
        long num = 0;
        do {
            int rem = x % 10;
            num = num * 10 + rem;
            x /= 10;
        } while (Math.abs(x) > 0);
        if (num > Integer.MAX_VALUE || num < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) num;
    }
}
