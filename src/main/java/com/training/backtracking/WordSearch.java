package com.training.backtracking;

/*
79. Word Search
Given an m x n grid of characters board and a string word, return true if word exists in the grid.
The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are
horizontally or vertically neighboring. The same letter cell may not be used more than once.

Example 1:
    Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
    Output: true

Example 2:
    Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
    Output: true
Example 3:
    Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
    Output: false
 */
public class WordSearch {

    static int[][] dirs = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        System.out.println(exists(board, "ABCCED"));
        board = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        System.out.println(exists(board, "SEE"));
        board = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        System.out.println(exists(board, "ABCB"));
    }

    private static boolean exists(char[][] board, String word) {
        if (board.length == 1 && board[0].length == 1) {
            return board[0][0] == word.charAt(0);
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (backTrack(board, word, 0, i, j)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean backTrack(char[][] board, String word, int idx, int m, int n) {
        if (idx == word.length()) {
            return true;
        }
        if (board[m][n] != word.charAt(idx)) {
            return false;
        }
        char ch = board[m][n];
        board[m][n] = '$';
        int rows = board.length;
        int cols = board[0].length;
        for (int[] dir : dirs) {
            int r = m + dir[0];
            int c = n + dir[1];
            if ((r < 0 || r >= rows) || (c < 0 || c >= cols)) {
                continue;
            }
            if (backTrack(board, word, idx + 1, r, c)) {
                return true;
            }
        }
        board[m][n] = ch;
        return false;
    }


}
