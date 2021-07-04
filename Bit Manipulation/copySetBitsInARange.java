/*
1. You are given two numbers A and B.
2. You are given two more numbers left and right, representing a range [left,right].
3. You have to set bits in B which are set in A lying in the above mentioned range.
4. Print the updated number B.
*/

import java.util.*;

public class copySetBitsInARange {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int a = scn.nextInt();
        int b = scn.nextInt();
        int left = scn.nextInt();
        int right = scn.nextInt();
        scn.close();
        // write your code here
        int mask = (1 << (right - left + 1));
        mask--;
        mask = (mask << (left - 1));
        mask &= a;
        System.out.println(mask | b);
    }

}