/*
1. You are given a number N, which represents the count of buttons pressed on a mobile numeric keypad.
2. You can only press buttons that are up, left, right, down to the current button and the current button also.
3. You can not press bottom row corner buttons(* and #).
    Image - https://pepcoding.com/resources/ojquestionresource/images/nokiakeypad.jpeg
4. You have to find the count of different numbers that can be generated by pressing N number of buttons.
*/

import java.io.*;
import java.util.*;

public class numericKeypad {
    public static boolean exists(int i, int j) {
        if (i >= 0 && i < 4 && j >= 0 && j < 3)
            return true;
        return false;
    }

    public static int solution(int n) {
        // write your code here
        int[][] prev = new int[4][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                prev[i][j] = 1;
            }
        }
        prev[3][1] = 1;
        while (--n > 0) {
            int[][] curr = new int[4][3];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    int ni = i, nj = j;
                    curr[i][j] = prev[ni][nj];
                    ni = i - 1;
                    if (exists(ni, nj))
                        curr[i][j] += prev[ni][nj];
                    ni = i + 1;
                    if (exists(ni, nj))
                        curr[i][j] += prev[ni][nj];
                    ni = i;
                    nj = j - 1;
                    if (exists(ni, nj))
                        curr[i][j] += prev[ni][nj];
                    nj = j + 1;
                    if (exists(ni, nj))
                        curr[i][j] += prev[ni][nj];
                }
            }
            curr[3][1] = prev[3][1] + prev[2][1];
            prev = curr;
        }
        int sum = 0;
        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 3; j++)
                sum += prev[i][j];
        return sum;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println(solution(scn.nextInt()));
    }

}