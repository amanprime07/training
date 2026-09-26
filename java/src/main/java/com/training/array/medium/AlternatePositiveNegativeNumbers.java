package com.training.array.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AlternatePositiveNegativeNumbers {
    public static void main(String[] args) {
        int[] arr = {1, 2, -1, -2, -1, -3, -2};
        int[] n = alternate(arr, arr.length);
        System.out.println(Arrays.toString(n));
    }

    private static int[] alternatePositiveNegative(int[] arr, int size) {
        int i = 0;
        int j = 1;
        int[] n = new int[arr.length];
        for (int k = 0; k < size; k++) {
            if (arr[k] > 0 && i < size) {
                n[i] = arr[k];
                i += 2;
            } else if (arr[k] < 0 && j < size) {
                n[j] = arr[k];
                j += 2;
            }
        }
        return n;
    }

    private static void bruteForce(int[] arr, int size) {
        for (int i = 0; i < size; i++) {
            if (i % 2 == 1) {
                for (int j = i; j < size; j++) {
                    if (arr[j] < 0) {
                        swap(arr, i, j);
                        break;
                    }
                }
            } else {
                for (int j = i; j < size; j++) {
                    if (arr[j] > 0) {
                        swap(arr, i, j);
                        break;
                    }
                }
            }
        }
    }

    private static int[] alternate(int[] arr, int size) {
        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            if (arr[i] > 0) {
                pos.add(arr[i]);
            } else {
                neg.add(arr[i]);
            }
        }
        int[] a = new int[size];
        int p = 0;
        int n = 1;
        int t = Math.min(pos.size(), neg.size());
        for (var i : pos) {
            a[p] = i;
            if (p <= t) {
                p += 2;
            } else {
                p++;
            }
        }
        for (var i : neg) {
            a[n] = i;
            if (n <= t) {
                n += 2;
            } else {
                n++;
            }
        }
        return a;
    }

    private static void swap(int[] arr, int s, int d) {
        int temp = arr[s];
        arr[s] = arr[d];
        arr[d] = temp;
    }
}
