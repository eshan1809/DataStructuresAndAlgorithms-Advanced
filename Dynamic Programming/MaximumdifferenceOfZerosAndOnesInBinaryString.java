/*
1. You are given a string containing only 0's and 1's.
2. You have to find the length of substring which is having maximum difference of number of 0s and number of 1s i.e (Number of 0's - Number of 1's).
3. If there are all 1's present in the given string, then print '-1'.
*/

import java.io.*;
import java.util.*;

public class MaximumdifferenceOfZerosAndOnesInBinaryString {
    public static int solution(String str) {
        // write your code here
        int curr = str.charAt(0) == '0' ? 1 : -1, max = curr;
        for (int i = 1; i < str.length(); i++) {
            int x = str.charAt(i) == '0' ? 1 : -1;
            curr = Math.max(x, curr + x);
            max = Math.max(max, curr);
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        System.out.println(solution(str));
    }
}
