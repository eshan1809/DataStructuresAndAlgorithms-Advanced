/*
1. You are given n number of domino shaped bipolar magnets.
2. You have to place these magnets in M*N following the conditions.
3. Conditions are -
   a. Each box of 1*2 or 2*1 can contain a magnet or can be empty.
   b. Empty box can be represented by X's and magnets are represented by + and 
    - sign.
   c. Digits along left and top side of the board represents the number of + in 
    corresponding rows and columns.
   d. Digits along right and bottom of the board represents the number of - in 
    corresponding rows and columns.
    e. -1 denotes that the corresponding row and column can have any number of 
    +  and - signs.
    f. No two adjacent cell can have the same sign.
*/

import java.io.*;
import java.util.*;

public class magnets {

    public static void print(char[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int countInColumn(char ans[][], char ch, int j) {
        int count = 0;
        for (int i = 0; i < ans.length; i++)
            if (ans[i][j] == ch)
                count++;

        return count;
    }

    private static int countInRow(char ans[][], char ch, int i) {
        int count = 0;
        for (int j = 0; j < ans[0].length; j++)
            if (ans[i][j] == ch)
                count++;

        return count;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int m = scn.nextInt();
        int n = scn.nextInt();
        char[][] arr = new char[m][n];
        for (int i = 0; i < arr.length; i++) {
            String str = scn.next();
            arr[i] = str.toCharArray();
        }
        int[] top = new int[n];
        for (int i = 0; i < n; i++) {
            top[i] = scn.nextInt();
        }
        int[] left = new int[m];
        for (int i = 0; i < m; i++) {
            left[i] = scn.nextInt();
        }
        int[] right = new int[m];
        for (int i = 0; i < m; i++) {
            right[i] = scn.nextInt();
        }
        int[] bottom = new int[n];
        for (int i = 0; i < n; i++) {
            bottom[i] = scn.nextInt();
        }

        char ans[][] = new char[m][n];

        for (int i = 0; i < m; i++)
            Arrays.fill(ans[i], 'X');

        scn.close();
        if (!solution(arr, top, left, right, bottom, ans, 0, 0)) {
            System.out.println("No Solution");
        } else
            print(ans);
    }
}