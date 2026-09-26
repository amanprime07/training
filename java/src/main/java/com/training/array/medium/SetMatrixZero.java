package com.training.array.medium;

public class SetMatrixZero {

    public static void main(String[] args) {
        int[][] matrix = {{1, 1, 0}, {0, 1, 1}, {1, 1, 1}};
        print(matrix);
        optimized(matrix);
        print(matrix);
    }

    /*
     00 01 02
     10 11 12
     20 21 22
     */
    private static void optimized(int[][] m) {
        int zeroCol = 1;
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                if (m[i][j] == 0) {
                    if (j == 0) {
                        zeroCol = 0;
                    } else {
                        m[0][j] = 0;
                    }
                    m[i][0] = 0;
                }
            }
        }

        for (int i = 1; i < m.length; i++) {
            for (int j = 1; j < m[0].length; j++) {
                if (m[0][j] == 0 || m[i][0] == 0) {
                    m[i][j] = 0;
                }
            }
        }

        if (m[0][0] == 0) {
            for (int j = 0; j < m[0].length; j++) {
                m[0][j] = 0;
            }
        }
// this needs to be set last otherwise first row will tale m[0][0] = 0;
        if (zeroCol == 0) {
            for (int i = 0; i < m.length; i++) {
                m[i][0] = 0;
            }
        }
    }

    /*
    Using extra O(m+n) space.
    * */
    private static void betterApproach(int[][] m) {
        int[] rows = new int[m.length];
        int[] cols = new int[m[0].length];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                if (m[i][j] == 0) {
                    rows[i] = 1;
                    cols[j] = 1;
                }
            }
        }

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                if (rows[i] == 1 || cols[j] == 1) {
                    m[i][j] = 0;
                }
            }
        }

    }

    private static void print(int[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    /*
    set the row & column except the i,j position with -1
    set i,j position with -1
    set row and column to 0 if arr[i][j] == -1
     */
    private static void bruteForce(int[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                if (m[i][j] == 0) {
                    markNegOne(m, i, j);
                }
            }
        }
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                if (m[i][j] == 0) {
                    m[i][j] = -1;
                }
            }
        }

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                if (m[i][j] == -1) {
                    m[i][j] = 0;
                }
            }
        }
    }

    private static void markNegOne(int[][] m, int row, int col) {
        for (int i = 0; i < m.length; i++) {
            if (m[row][i] != 0) {
                m[row][i] = -1;
            }
        }

        for (int i = 0; i < m[0].length; i++) {
            if (m[i][col] != 0) {
                m[i][col] = -1;
            }
        }
    }
}
