package com.training.array.medium;

public class RotateMatrixBy90 {

    public static void main(String[] args) {
        int[][] m = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9},};
        print(m);
//        int[][] x = rotateAntiClockWise(m);
        optimizeAntiClockWise(m);
        print(m);
    }

    private static void optimizeAntiClockWise(int[][] m) {
        transpose(m);
        print(m);
        for (int i = 0; i < m.length; i++) {
            int start = 0;
            int end = m[i].length - 1;
            while (start < end) {
                int temp = m[start][i];
                m[start][i] = m[end][i];
                m[end][i] = temp;
                start++;
                end--;
            }
        }
    }


    /*
     * 1 2 3    1 4 7
     * 4 5 6 => 2 5 8
     * 7 8 9    3 6 9
     *   ||
     *   \/
     * 3 6 9
     * 2 5 8
     * 1 4 7
     * */
//   j=0, i=2
//    j=1, i=1
//    j = 2, i=0
    private static int[][] rotateAntiClockWise(int[][] m) {
        int[][] x = new int[m[0].length][m.length];
        for (int j = 0; j < m[0].length; j++) {
            int k = m[0].length - 1 - j;
            for (int i = 0; i < m.length; i++) {
                x[k][i] = m[i][j];
            }
        }
        return x;
    }

    private static void optimizedClockwise(int[][] m) {
        transpose(m);
        for (int i = 0; i < m.length; i++) {
            rotate(m[i]);
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
     * 1 2 3
     * 4 5 6
     * 7 8 9
     *   ||
     *   \/
     * 7 4 1
     * 8 5 2
     * 9 6 3
     * */

    //    i=0, j=2
//    i=1, j=1
//    i=2, j=0
    private static int[][] rotateClockwise(int[][] m) {
        int[][] x = new int[m[0].length][m.length];
        for (int i = 0; i < m.length; i++) {
            int k = m[i].length - 1 - i;
            for (int j = 0; j < m[i].length; j++) {
                x[j][k] = m[i][j];
            }
        }
        return x;
    }

    private static void transpose(int[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length; j++) {
                if (i > j) {
                    int temp = m[i][j];
                    m[i][j] = m[j][i];
                    m[j][i] = temp;
                }
            }
        }
    }

    private static void transposeAntiClockWise(int[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length; j++) {
                if (i < j) {
                    int temp = m[i][j];
                    m[i][j] = m[j][i];
                    m[j][i] = temp;
                }
            }
        }
    }

    private static void rotate(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }

    private static void swap(int[] arr, int s, int d) {
        int temp = arr[s];
        arr[s] = arr[d];
        arr[d] = temp;
    }
}
