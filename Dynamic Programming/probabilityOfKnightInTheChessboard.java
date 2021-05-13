/*
1. You are given a N*N chessboard and the starting position of the knight in the chessboard.
2. The rows and columns are 0 indexed, so the top-left square is (0, 0), and the bottom-right square is (N-1, N-1).
3. You have to find the probability of knight to remain in the chessboard after exactly k number of moves.

Note -> The knight continues moving until it has made exactly K moves or has moved off the chessboard.
*/

import java.io.*;
import java.util.*;

public class probabilityOfKnightInTheChessboard {
    public static boolean inBoard(int n, int i, int j) {
        if (i < n && i >= 0 && j < n && j >= 0)
            return true;
        return false;
    }

    public static void solution(int r, int c, int n, int k) {
        // write your code here
        double[][] prev = new double[n][n];
        prev[r][c] = 1;
        while (k-- > 0) {
            double[][] curr = new double[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (prev[i][j] != 0) {
                        double prob = prev[i][j] / 8.0;

                        int ci = i - 2, cj = j + 1;
                        if (inBoard(n, ci, cj))
                            curr[ci][cj] += prob;

                        ci = i - 1;
                        cj = j + 2;
                        if (inBoard(n, ci, cj))
                            curr[ci][cj] += prob;

                        ci = i + 1;
                        cj = j + 2;
                        if (inBoard(n, ci, cj))
                            curr[ci][cj] += prob;

                        ci = i + 2;
                        cj = j + 1;
                        if (inBoard(n, ci, cj))
                            curr[ci][cj] += prob;

                        ci = i + 2;
                        cj = j - 1;
                        if (inBoard(n, ci, cj))
                            curr[ci][cj] += prob;

                        ci = i + 1;
                        cj = j - 2;
                        if (inBoard(n, ci, cj))
                            curr[ci][cj] += prob;

                        ci = i - 1;
                        cj = j - 2;
                        if (inBoard(n, ci, cj))
                            curr[ci][cj] += prob;

                        ci = i - 2;
                        cj = j - 1;
                        if (inBoard(n, ci, cj))
                            curr[ci][cj] += prob;
                    }
                }
            }
            prev = curr;
        }
        double prob = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                prob += prev[i][j];
        System.out.println(prob);
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        int r = scn.nextInt();
        int c = scn.nextInt();
        solution(r, c, n, k);
    }
}
