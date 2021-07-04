/*
1. You are given a number n, the size of a chess board.
2. You are required to place n number of queens in the n * n cells of board such that no queen can kill another.
     Note - Queens kill at distance in all 8 directions
3. Complete the body of printNQueens function - without changing signature - to calculate and print all safe configurations of n-queens
     Use sample input and output to get more idea.

Note -> The online judge can't force you to write the function recursively but that is what the spirit of question is.
               Write recursive and not iterative logic. The purpose of the question is to aid learning recursion, branch and bound technique, bit manipulation 
               and not test you.
*/

import java.util.*;

public class N_QueensUsingBit {

    public static void solution(boolean[][] board, int row, int cols, int ndiag, int rdiag, String asf) {
        // write your code here
        if (row == board.length) {
            System.out.println(asf + ".");
            return;
        }
        for (int col = 0; col < board.length; col++) {
            if ((cols & (1 << col)) == 0 && (ndiag & (1 << (row + col))) == 0
                    && (rdiag & (1 << (row - col + board.length - 1))) == 0) {
                board[row][col] = true;
                cols ^= (1 << col);
                ndiag ^= (1 << (row + col));
                rdiag ^= (1 << (row - col + board.length - 1));
                solution(board, row + 1, cols, ndiag, rdiag, asf + row + "-" + col + ", ");
                board[row][col] = false;
                cols ^= (1 << col);
                ndiag ^= (1 << (row + col));
                rdiag ^= (1 << (row - col + board.length - 1));
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        scn.close();
        boolean[][] board = new boolean[n][n];
        int cols = 0;
        int ndiag = 0;
        int rdiag = 0;
        solution(board, 0, cols, ndiag, rdiag, "");
    }

}