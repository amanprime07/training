package com.training;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSMatrixTraversal {

    static class Pair {
        int row;
        int col;

        public Pair(int row, int column) {
            this.row = row;
            this.col = column;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = { { 0, 0, 1 }, { 1, 0, 0 }, { 1, 1, 0 } };
        int k = 2;
        // traverseMatrix(matrix, new Pair(0, 0), new Pair(2, 2), k);
    }

    /*
     * private static void traverseMatrix(int[][] matrix, Pair start, Pair end, int
     * k) {
     * Queue<Pair> queue = new LinkedList<>();
     * int rows = matrix.length;
     * int cols = matrix[0].length;
     * boolean[][] visited = new boolean[rows][cols];
     * queue.add(start);
     * visited[start.row][start.column] = true;
     * int[] rowMoves = {1, -1, 0, 0};
     * int[] colMoves = {0, 0, 1, -1};
     * while (!queue.isEmpty()) {
     * Pair currentPos = queue.poll();
     * int cr = currentPos.row;
     * int cc = currentPos.column;
     * System.out.printf("Visited cell %s, %s \n", cr, cc);
     * for (int i = 0; i < k; i++) {
     * int nr = cr + rowMoves[i];
     * int nc = cc + colMoves[i];
     * if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && !visited[nr][nc]) {
     * queue.add(new Pair(nr, nc));
     * visited[nr][nc] = true;
     * }
     * }
     * }
     * }
     */

    public static int getMinimumMoves(List<List<Integer>> maze, int k) {
        // Write your code here
        int rows = maze.size();
        int cols = maze.get(0).size();
        int[][] moves = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
        boolean[][] visited = new boolean[rows][cols];
        Queue<Pair> queue = new LinkedList<>();
        Pair start = new Pair(0, 0);
        queue.add(start);
        visited[0][0] = true;
        int steps = 0;
        while (!queue.isEmpty()) {
            Pair curr = queue.poll();
            int cr = curr.row;
            int cc = curr.col;
            for (int i = 0; i < k; i++) {
                if (maze.get(cr).get(cc) == 1) {
                    return steps;
                }
                for (int[] move : moves) {
                    int nr = cr + move[0];
                    int nc = cc + move[0];
                    // base condition
                    if (nr < 0 || nr == rows || nc < 0 || nc == cols || visited[nr][nc]) {
                        continue;
                    }
                    visited[nr][nc] = true;
                    queue.offer(new Pair(nr, nc));
                }
            }
            steps++;
        }
        return -1;
    }
}
