/*
1. You are given a number n, representing the size of a n * n chess board.
2. You are required to calculate and print the combinations in which n queens can be placed on the n * n chess-board.
*/

import java.io.*;
import java.util.*;

public class Queens_Combinations_2dAs2d_BoxChooses {
    public static void queensCombinations(int qpsf, int tq, int row, int col, String asf) {
        // write your code here
        if (row == tq) {
            if (qpsf == tq) {
                System.out.print(asf);
                System.out.println();
            }
            return;
        }

        if (col < tq - 1) {
            queensCombinations(qpsf + 1, tq, row, col + 1, asf + "q");
            queensCombinations(qpsf, tq, row, col + 1, asf + "-");
        } else {
            queensCombinations(qpsf + 1, tq, row + 1, 0, asf + "q");
            queensCombinations(qpsf, tq, row + 1, 0, asf + "-");
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        queensCombinations(0, n, 0, 0, "");
    }
}
