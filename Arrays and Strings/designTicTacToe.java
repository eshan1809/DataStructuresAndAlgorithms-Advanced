/*
Assume the following rules are for the tic-tac-toe game on an n x n board between two players:

A move is guaranteed to be valid and is placed on an empty block.
Once a winning condition is reached, no more moves are allowed.
A player who succeeds in placing n of their marks in a horizontal, vertical, or diagonal row wins the game.
Implement the TicTacToe class:

TicTacToe(int n) Initializes the object the size of the board n.
int move(int row, int col, int player) Indicates that the player with id player plays at the cell (row, col) of the board. The move is guaranteed to be a valid move.
*/

import java.util.*;

public class designTicTacToe {

    static class TicTacToe {
        int n;
        int[][] mat;

        public TicTacToe(int n) {
            // initialize data members
            this.n = n;
            mat = new int[n][n];
        }

        public int move(int row, int col, int player) {
            mat[row][col] = player;
            if (checkRow(row, player) || checkColumn(col, player))
                return player;
            if (row == col && checkFirstDiagonal(player))
                return player;
            if (row + col == n - 1 && checkSecondDiagonal(player))
                return player;
            return 0;
        }

        private boolean checkRow(int row, int player) {
            for (int i = 0; i < n; i++)
                if (mat[row][i] != player)
                    return false;
            return true;
        }

        private boolean checkColumn(int col, int player) {
            for (int i = 0; i < n; i++)
                if (mat[i][col] != player)
                    return false;
            return true;
        }

        private boolean checkFirstDiagonal(int player) {
            for (int i = 0, j = 0; i < n; i++, j++)
                if (mat[i][j] != player)
                    return false;
            return true;
        }

        private boolean checkSecondDiagonal(int player) {
            for (int i = 0, j = n - 1; i < n; i++, j--)
                if (mat[i][j] != player)
                    return false;
            return true;
        }
    }

    public static void main(String[] args) throws java.lang.Exception {

        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        TicTacToe obj = new TicTacToe(n);
        for (int i = n * n; i >= 1; i--) {
            int ans = obj.move(scn.nextInt(), scn.nextInt(), scn.nextInt());
            System.out.println(ans);
            if (ans != 0)
                break;
        }
        scn.close();
    }
}
