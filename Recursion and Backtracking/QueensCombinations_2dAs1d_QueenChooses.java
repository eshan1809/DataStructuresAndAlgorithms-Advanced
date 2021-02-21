/*
1. You are given a number n, representing the size of a n * n chess board.
2. You are required to calculate and print the combinations in which n queens can be placed on the n * n chess-board.
*/

import java.io.*;
import java.util.*;

public class QueensCombinations_2dAs1d_QueenChooses {
    public static void queensCombinations(int qpsf, int tq, boolean[][] chess, int lcno) {
        if (qpsf == tq) {
            for (int i = 0; i < tq; i++) {
                for (int j = 0; j < tq; j++) {
                    if (chess[i][j] == true) {
                        System.out.print("q	");
                    } else {
                        System.out.print("-	");
                    }
                }
                System.out.println();
            }
            System.out.println();
            return;
        }
        for (int j = lcno + 1; j < tq * tq; j++) {
            int rn = j / tq, cn = j % tq;
            chess[rn][cn] = true;
            queensCombinations(qpsf + 1, tq, chess, j);
            chess[rn][cn] = false;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][] chess = new boolean[n][n];
        queensCombinations(0, n, chess, -1);
    }
}
