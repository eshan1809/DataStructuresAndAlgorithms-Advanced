/*
1. You are given a number n, representing the size of a n * n chess board.
2. You are required to calculate and print the permutations in which n queens (distinct) can be placed on the n * n chess-board. 
3. No queen shall be able to kill another.
*/

import java.io.*;

public class NqueensPermutations_2dAs1d_QueenChooses {

    public static boolean IsQueenSafe(int[][] chess, int row, int col) {
        for (int j = 0; j < chess.length; j++) {
            if (chess[row][j] > 0) {
                return false;
            }
        }
        for (int i = 0; i < chess.length; i++) {
            if (chess[i][col] > 0) {
                return false;
            }
        }
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chess[i][j] > 0) {
                return false;
            }
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j < chess.length; i--, j++) {
            if (chess[i][j] > 0) {
                return false;
            }
        }
        for (int i = row + 1, j = col + 1; i < chess.length && j < chess.length; i++, j++) {
            if (chess[i][j] > 0) {
                return false;
            }
        }
        for (int i = row + 1, j = col - 1; i < chess.length && j >= 0; i++, j--) {
            if (chess[i][j] > 0) {
                return false;
            }
        }
        return true;
    }

    public static void nqueens(int qpsf, int tq, int[][] chess) {
        if (qpsf == tq) {
            for (int i = 0; i < tq; i++) {
                for (int j = 0; j < tq; j++) {
                    if (chess[i][j] == 0) {
                        System.out.print("-	");
                    } else {
                        System.out.print("q" + chess[i][j] + "	");
                    }
                }
                System.out.println();
            }
            System.out.println();
            return;
        }
        for (int i = 0; i < tq; i++) {
            for (int j = 0; j < tq; j++) {
                if (chess[i][j] == 0 && IsQueenSafe(chess, i, j)) {
                    chess[i][j] = qpsf + 1;
                    nqueens(qpsf + 1, tq, chess);
                    chess[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] chess = new int[n][n];

        nqueens(0, n, chess);
    }
}
