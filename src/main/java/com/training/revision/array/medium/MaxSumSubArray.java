package com.training.revision.array.medium;

public class MaxSumSubArray {

    public static void main(String[] args) {
        int[] arr = {-2, 11, -3, 4};
        int[] res = maxSumSubArray(arr);
        if (res[0] == -1 || res[1] == -1) {
            System.out.println("[]");
        } else {
            for (int i = res[0]; i <= res[1]; i++) {
                System.out.print(arr[i] + ", ");
            }

        }
    }

    private static int[] maxSumSubArray(int[] arr) {
        int start = -1;
        int end = -1;
        int sum = 0, maxSum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (sum <= 0) {
                start = i;
                sum = 0;
            }
            sum += arr[i];
            if (maxSum < sum) {
                end = i;
                maxSum = sum;
            }
        }
        return new int[]{start, end};
    }
}
