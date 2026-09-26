package com.training.revision.array.medium;

public class MaxSubArraySum {

    public static void main(String[] args) {
        int[] arr = {-2, 11, -3, 4};
        int s = maxSubArraySum(arr);
        System.out.println(s);
    }

    private static int maxSubArraySum(int[] arr) {
        int sum = 0;
        int maxSum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (maxSum < sum) {
                maxSum = sum;
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        return maxSum;
    }
}
