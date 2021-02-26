/*
1. You are given a number n, representing the size of a n * n chess board.
2. You are required to calculate and print the combinations in which n knights can be placed on the n * n chess-board. 
3. No knight shall be able to kill another.
*/

import java.io.*;

public class NknightsCombinations_2dAs1d_KnightChooses {
    public static boolean safe(boolean[][] chess, int row, int col) {
        if (row < 0 || col < 0 || row >= chess.length || col >= chess.length || chess[row][col] == false) {
            return true;
        }
        return false;
    }

    public static boolean IsKnightSafe(boolean[][] chess, int row, int col) {
        if (safe(chess, row - 2, col + 1) && safe(chess, row - 1, col + 2) && safe(chess, row + 1, col + 2)
                && safe(chess, row + 2, col + 1) && safe(chess, row + 2, col - 1) && safe(chess, row + 1, col - 2)
                && safe(chess, row - 1, col - 2) && safe(chess, row - 2, col - 1)) {
            return true;
        }
        return false;
    }

    public static void nknights(int kpsf, int tk, boolean[][] chess, int lcno) {
        if (kpsf == tk) {
            for (int row = 0; row < chess.length; row++) {
                for (int col = 0; col < chess.length; col++) {
                    System.out.print(chess[row][col] ? "k	" : "-	");
                }
                System.out.println();
            }
            System.out.println();
            return;
        }

        for (int i = lcno + 1; i < chess.length * chess.length; i++) {
            int row = i / chess.length;
            int col = i % chess.length;

            if (chess[row][col] == false && IsKnightSafe(chess, row, col)) {
                chess[row][col] = true;
                nknights(kpsf + 1, tk, chess, row * chess.length + col);
                chess[row][col] = false;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][] chess = new boolean[n][n];

        nknights(0, n, chess, -1);
    }
}
