/*
1. You are given a number n, the size of a chess board.
2. You are required to place n number of queens in the n * n cells of board such that no queen can 
     kill another.
Note - Queens kill at distance in all 8 directions
3. Complete the body of printNQueens function - without changing signature - to calculate and 
     print all safe configurations of n-queens

Use sample input and output to get more idea.
*/

import java.util.*;

public class nQueens {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        boolean[][] board = new boolean[n][n];
        placeNQueens(0, "", board);
        scn.close();
    }

    public static void placeNQueens(int row, String psf, boolean[][] board) {
        if (row == board.length) {
            System.out.println(psf + ".");
            return;
        }
        for (int col = 0; col < board.length; col++) {
            if (isSafePlace(row, col, board)) {
                board[row][col] = true;
                placeNQueens(row + 1, psf + row + "-" + col + ", ", board);
                board[row][col] = false;
            }
        }
    }

    public static boolean isSafePlace(int row, int col, boolean[][] board) {
        for (int i = row - 1, j = col; i >= 0; i--) {
            if (board[i][j] == true) {
                return false;
            }
        }
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == true) {
                return false;
            }
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == true) {
                return false;
            }
        }
        return true;
    }
}