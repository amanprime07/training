package com.training.array.medium;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public static void main(String[] args) {
        int[][] m = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        System.out.println(spiralMatrix(m));

    }

    /*
     * 1   2  3  4
     * 5   6  7  8
     * 9  10 11 12
     * 13 14 15 16
     * */
    private static List<Integer> spiralMatrix(int[][] m) {
        int top = 0;
        int bottom = m.length - 1;
        int left = 0;
        int right = m[0].length - 1;
        List<Integer> list = new ArrayList<>();
        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {
                list.add(m[top][i]);
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                list.add(m[i][right]);
            }
            right--;
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    list.add(m[bottom][i]);
                }
                bottom--;

            }
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    list.add(m[i][left]);
                }
                left++;
            }
        }
        return list;
    }
}
