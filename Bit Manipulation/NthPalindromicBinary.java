/*
1. You are given an integer N.
2. You have to find the N-th number whose binary representation is a palindrome.

Note -> First binary number whose representation is a palindrome is 1.
*/

import java.util.*;

public class NthPalindromicBinary {
    public static int reverse(int n) {
        int flag = 0, rev = 0, j = 0;
        for (int i = 31; i >= 0; i--) {
            if (flag == 1) {
                if ((n & (1 << i)) != 0) {
                    int mask = (1 << j);
                    rev |= mask;
                }
                j++;
            } else if ((n & (1 << i)) != 0) {
                flag = 1;
                int mask = (1 << j);
                rev |= mask;
                j = 1;
            }
        }
        return rev;
    }

    public static int solution(int n) {
        // write your code here
        int count = 1, len = 1;
        while (count < n) {
            len++;
            count += (1 << (len - 1) / 2);
        }
        count -= (1 << (len - 1) / 2);
        int offset = n - count - 1;
        int ans = (1 << (len - 1));
        ans |= (offset << (len / 2));
        return ans | reverse((ans >> (len / 2)));
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        scn.close();
        System.out.println(solution(n));
    }

}