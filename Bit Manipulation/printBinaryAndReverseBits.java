/*
1. You are given a number.
2. You have to print its binary representation.
3. You also have to reverse the bits of n and print the number obtained after reversing the bits.
*/

import java.util.*;

public class printBinaryAndReverseBits {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        scn.close();
        // write your code here
        int flag = 0, rev = 0, j = 0;
        for (int i = 31; i >= 0; i--) {
            if (flag == 1) {
                if ((n & (1 << i)) == 0)
                    System.out.print(0);
                else {
                    System.out.print(1);
                    int mask = (1 << j);
                    rev |= mask;
                }
                j++;
            } else if ((n & (1 << i)) != 0) {
                flag = 1;
                System.out.print(1);
                int mask = (1 << j);
                rev |= mask;
                j = 1;
            }
        }
        System.out.print("\n" + rev);
    }
}