package com.training.array.medium;

public class TransposeMatrix {

    public static void main(String[] args) {
        int[][] m = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        print(m);
        transpose(m);
        print(m);
    }

    private static void transpose(int[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length; j++) {
                if (i > j) {
                    swap(m, i, j);
                }
            }
        }
    }


    private static void print(int[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }


    private static void swap(int[][] m, int i, int j) {
        int temp = m[i][j];
        m[i][j] = m[j][i];
        m[j][i] = temp;
    }
}
