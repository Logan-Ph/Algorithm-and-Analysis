package w6_lecture;

import java.util.Arrays;

public class Queens {
    static final int N = 8;

    static boolean isSafe(int[][] board, int row, int col) {

        // check the rows
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] == 1) {
                return false;
            }
        }

        // check the upper left diagonal
        for (int x = row, y = col; x >= 0 && y >= 0; x--, y--) {
            if (board[x][y] == 1) {
                return false;
            }
        }

        // check the lower left diagonal
        for (int x = row, y = col; x < N && y >= 0; x++, y--) {
            if (board[x][y] == 1) {
                return false;
            }
        }

        return true;
    }

    static boolean solveNQueens(int[][] board, int col) {

        if (col == N) {
            for (int[] row : board) {
                System.out.println(Arrays.toString(row));
            }
            return true;
        }

        for (int i = 0; i < N; i++) {
            if (isSafe(board, i, col)) {
                board[i][col] = 1;
                if (solveNQueens(board, col + 1)) {
                    return true;
                }
                board[i][col] = 0;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] board = new int[N][N];
        if (!solveNQueens(board, 0))
            System.out.println("No solution found");
    }
}
