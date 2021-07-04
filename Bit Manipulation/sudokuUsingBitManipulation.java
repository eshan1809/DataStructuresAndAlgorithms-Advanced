/*
1. You are give a partially filled 9*9 2-D array(arr) which represents an incomplete sudoku state.
2. You are required to assign the digits from 1 to 9 to the empty cells following some rules.
Rule 1 -> Digits from 1-9 must occur exactly once in each row.
Rule 2 -> Digits from 1-9 must occur exactly once in each column.
Rule 3 -> Digits from 1-9 must occur exactly once in each 3x3 sub-array of the given 2D array.

Assumption -> The given Sudoku puzzle will have a single unique solution.
Note -> You have to Solve this problem using bits.
*/

import java.util.*;

public class sudokuUsingBitManipulation {

    public static void display(int[][] arr) {
        for (int ii = 0; ii < arr.length; ii++) {
            for (int jj = 0; jj < arr.length; jj++) {
                System.out.print(arr[ii][jj] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void solveSudoku(int[][] arr, int[] rows, int[] cols, int[][] grid, int i, int j) {
        // write your code here. Use display function to display arr
        if (j == 9) {
            i++;
            j = 0;
        }
        if (i == 9) {
            display(arr);
            return;
        }
        if (arr[i][j] != 0)
            solveSudoku(arr, rows, cols, grid, i, j + 1);
        else {
            for (int num = 1; num < 10; num++) {
                if ((rows[i] & (1 << num)) == 0 && (cols[j] & (1 << num)) == 0
                        && (grid[i / 3][j / 3] & (1 << num)) == 0) {
                    arr[i][j] = num;
                    rows[i] ^= (1 << num);
                    cols[j] ^= (1 << num);
                    grid[i / 3][j / 3] ^= (1 << num);
                    solveSudoku(arr, rows, cols, grid, i, j + 1);
                    arr[i][j] = 0;
                    rows[i] ^= (1 << num);
                    cols[j] ^= (1 << num);
                    grid[i / 3][j / 3] ^= (1 << num);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int[][] arr = new int[9][9];
        int[] rows = new int[9];
        int[] cols = new int[9];
        int[][] grid = new int[3][3];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int digit = scn.nextInt();
                arr[i][j] = digit;
                rows[i] |= (1 << digit);
                cols[j] |= (1 << digit);
                grid[i / 3][j / 3] |= (1 << digit);
            }
        }
        scn.close();
        solveSudoku(arr, rows, cols, grid, 0, 0);
    }

}