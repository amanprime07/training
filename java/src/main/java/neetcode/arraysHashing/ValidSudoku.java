package neetcode.arraysHashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class ValidSudoku {

    public static void main(String[] args) {

        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        System.out.println(isValidSudokuMap(board));
        System.out.println(isValidSudokuArr(board));
    }

    private static boolean isValidSudokuArr(char[][] board) {
        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] cols = new HashSet[9];
        HashSet<Character>[] boxes = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int boxIdx = (i / 3) * 3 + j / 3;
                if (
                        rows[i].contains(board[i][j]) ||
                                cols[j].contains(board[i][j]) ||
                                boxes[boxIdx].contains(board[i][j])
                ) {
                    return false;
                }


                rows[i].add(board[i][j]);
                cols[j].add(board[i][j]);
                boxes[boxIdx].add(board[i][j]);
            }
        }
        return true;
    }

    private static boolean isValidSudokuMap(char[][] board) {
        Map<Integer, HashSet<Character>> rows = new HashMap<>();
        Map<Integer, HashSet<Character>> cols = new HashMap<>();
        Map<Pair, HashSet<Character>> box = new HashMap<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.') {
                    continue;
                }

                Pair p = new Pair(i / 3, j / 3);
                if (rows.computeIfAbsent(i, k -> new HashSet<>()).contains(board[i][j]) || cols.computeIfAbsent(i, k -> new HashSet<>()).contains(board[i][j]) || box.computeIfAbsent(p, k -> new HashSet<>()).contains(board[i][j])) {
                    return false;
                }

                rows.get(i).add(board[i][j]);
                cols.get(i).add(board[i][j]);
                box.get(p).add(board[i][j]);
            }
        }
        return true;
    }

    private record Pair(int r, int c) {
    }
}
