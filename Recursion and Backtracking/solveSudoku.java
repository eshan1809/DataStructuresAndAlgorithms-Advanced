/*
1. You are give a partially filled 9*9 2-D array(arr) which represents an incomplete sudoku state.
2. You are required to assign the digits from 1 to 9 to the empty cells following some rules.
Rule 1 -> Digits from 1-9 must occur exactly once in each row.
Rule 2 -> Digits from 1-9 must occur exactly once in each column.
Rule 3 -> Digits from 1-9 must occur exactly once in each 3x3 sub-array of the given 2D array.

Assumption -> The given Sudoku puzzle will have a single unique solution.
*/

import java.util.*;

public class solveSudoku {
    public static void display(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void solve_Sudoku(int[][] board, int i, int j) {
        if (i == 9) {
            display(board);
            return;
        }
        int ni, nj;
        if (j == 8) {
            ni = i + 1;
            nj = 0;
        } else {
            ni = i;
            nj = j + 1;
        }
        if (board[i][j] != 0) {
            solve_Sudoku(board, ni, nj);
        } else {
            for (int pv = 1; pv < 10; pv++) {
                if (isValid(board, i, j, pv)) {
                    board[i][j] = pv;
                    solve_Sudoku(board, ni, nj);
                    board[i][j] = 0;
                }
            }
        }
    }

    public static boolean isValid(int[][] board, int i, int j, int pv) {
        for (int r = 0; r < 9; r++) {
            if (board[r][j] == pv) {
                return false;
            }
        }
        for (int c = 0; c < 9; c++) {
            if (board[i][c] == pv) {
                return false;
            }
        }
        int sr = (i / 3) * 3, sc = (j / 3) * 3;
        for (int r = sr; r < sr + 3; r++) {
            for (int c = sc; c < sc + 3; c++) {
                if (board[r][c] == pv) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int[][] arr = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                arr[i][j] = scn.nextInt();
            }
        }
        solve_Sudoku(arr, 0, 0);
        scn.close();
    }
}