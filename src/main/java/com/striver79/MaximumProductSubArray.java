package com.striver79;

public class MaximumProductSubArray {

    public static void main(String[] args) {
        int[] arr = {2, 3, -2, 4};
        System.out.println(maxProduct(arr));

        arr = new int[]{-2};
        System.out.println(maxProduct(arr));
        arr = new int[]{3, -1, 4};
        System.out.println(maxProduct(arr));
        arr = new int[]{-2, 0, -1};
        System.out.println(maxProduct(arr));
    }

    private static int maxProduct(int[] arr) {
        int prefixProduct = 1;
        int suffixProduct = 1;
        int maxProduct = Integer.MIN_VALUE;
        int l = arr.length;
        for (int i = 0; i < arr.length; i++) {
            if (prefixProduct == 0) {
                prefixProduct = 1;
            }
            if (suffixProduct == 0) {
                suffixProduct = 1;
            }
            prefixProduct = prefixProduct * arr[i];
            suffixProduct = suffixProduct * arr[l - i - 1];
            maxProduct = Math.max(maxProduct, Math.max(suffixProduct, prefixProduct));
        }
        return maxProduct;
    }
}
