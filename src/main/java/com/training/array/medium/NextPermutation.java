package com.training.array.medium;

public class NextPermutation {

    public static void main(String[] args) {

    }

    /*
     * 123
     * 231
     * 312
     * 123
     * 132
     * 213
     * */
    private static String nextPermutation(int[] arr, int size) {
        String s = toString(arr);


        return s;
    }

//    private static String[] permutation(int[] arr, int size) {
//
//        return ;
//    }

    private static String toString(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
        }
        return sb.toString();
    }
}
