package com.training.heap;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;


/*
* 973. K Closest Points to Origin
Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k, return the k closest points to the origin (0, 0).
The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).
You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).
* */
public class KClosestPoint {

    public static void main(String[] args) {
        int[][] points = {{1, 3}, {-2, 2}};
        int k = 1;
        int[][] kClosest = kClosest(points, k);
        for (int[] a : kClosest) {
            System.out.println(Arrays.toString(a));
        }
    }

    private static int[][] kClosest(int[][] points, int k) {
        Queue<int[]> q = new PriorityQueue<>((a, b) -> distance(b) - distance(a));

        for (int[] p : points) {
            q.add(p);
            if (q.size() > k) {
                q.poll();
            }
        }
        int[][] arr = new int[k][2];
        for (int i = 0; i < k; i++) {
            arr[i] = q.poll();
        }
        return arr;
    }

    private static int distance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }

    private static class PointDistance {
        int dist;
        int[] point;

        PointDistance(int dist, int[] point) {
            this.dist = dist;
            this.point = point;
        }
    }
}
