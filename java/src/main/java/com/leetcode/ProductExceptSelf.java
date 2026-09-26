package com.leetcode;

import java.util.Arrays;

/*
Leetcode #238
Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
You must write an algorithm that runs in O(n) time and without using the division operation.
* */
public class ProductExceptSelf {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4};
        int[] ans;
        ans = productExceptSelfPrefixSuffix(arr);
        System.out.println(Arrays.toString(ans));
        ans = productExceptSelfUsingDivision(arr);
        System.out.println(Arrays.toString(ans));
        ans = productExceptSelf(arr);
        System.out.println(Arrays.toString(ans));
        System.out.println("bruteForce");
        ans = bruteForce(arr);
        System.out.println(Arrays.toString(ans));
        int[] arr1 = {-1, 1, 0, -3, 3};
        ans = productExceptSelfPrefixSuffix(arr1);
        System.out.println(Arrays.toString(ans));
        ans = productExceptSelfUsingDivision(arr1);
        System.out.println(Arrays.toString(ans));
        ans = productExceptSelf(arr1);
        System.out.println(Arrays.toString(ans));
    }

    private static int[] productExceptSelf(int[] arr) {
        int[] ans = new int[arr.length];
        Arrays.fill(ans, 1);
        int curr = 1;
        for (int i = 0; i < arr.length; i++) {
            ans[i] = ans[i] * curr;
            curr = curr * arr[i];
        }
        curr = 1;
        for (int i = arr.length - 1; i >= 0; i--) {
            ans[i] = ans[i] * curr;
            curr = curr * arr[i];
        }
        return ans;
    }

    private static int[] productExceptSelfPrefixSuffix(int[] arr) {
        int[] ans = new int[arr.length];
        int[] prefix = new int[arr.length];
        int[] suffix = new int[arr.length];
        prefix[0] = 1;
        suffix[arr.length - 1] = 1;
        for (int i = 1; i < arr.length; i++) {
            prefix[i] = prefix[i - 1] * arr[i - 1];
        }

        for (int i = arr.length - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * arr[i + 1];
        }
        for (int i = 0; i < arr.length; i++) {
            ans[i] = prefix[i] * suffix[i];
        }
        return ans;
    }

    /*
    * Example 1:
        Input: nums = [1,2,3,4]
        Output: [24,12,8,6]
    * Example 2:
        Input: nums = [-1,1,0,-3,3]
        Output: [0,0,9,0,0]
    * */
    private static int[] productExceptSelfUsingDivision(int[] arr) {
        int[] ans = new int[arr.length];
        int product = 1;
        int numZero = 0;
        int zeroIdx = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                numZero++;
                zeroIdx = i;
            } else {
                product *= arr[i];
            }
        }
        if (numZero == 2) {
            return ans;
        }
        if (numZero == 1) {
            ans[zeroIdx] = product;
            return ans;
        }
        for (int i = 0; i < arr.length; i++) {
            ans[i] = product / arr[i];
        }
        return ans;
    }

    private static int[] bruteForce(int[] arr) {
        int[] ans = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int prod = 1;
            for (int j = 0; j < arr.length; j++) {
                if (i == j) {
                    continue;
                }
                prod *= arr[j];
            }
            ans[i] = prod;
        }
        return ans;
    }
}
