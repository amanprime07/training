package com.training.array.easy;

public class MissingNumber {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.println(findMissingNumber(arr, 4));
    }

    private static int findMissingNumber(int[] arr, int n) {
        int sum = n * (n +1) / 2;
        int s = 0;
        for (int i = 0; i < arr.length; i++) {
            s += i;
        }
        return sum - s;
    }

    private static int findMissingNumberXor(int[] arr, int n) {
        int s1 = n;
        int s2 = 0;
        for (int i = 1; i <= arr.length; i++) {
            s1 ^= i;
            s2 ^= arr[i - 1];
        }
        return s1 ^ s2;
    }

    private static int bruteForce(int[] arr, int n) {
        int num = -1;
        for (int i = 1; i <= n; i++) {
            boolean found = false;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == i) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                num = i;
            }
        }
        return num;
    }
}
