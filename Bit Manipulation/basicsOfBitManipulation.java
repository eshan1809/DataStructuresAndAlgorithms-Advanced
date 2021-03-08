/*
1. You are given a number n.
2. Print the number produced on setting its i-th bit.
3. Print the number produced on unsetting its j-th bit.
4. Print the number produced on toggling its k-th bit.
5. Also, Check if its m-th bit is on or off. Print 'true' if it is on, otherwise print 'false'.
*/

import java.util.*;

public class basicsOfBitManipulation {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int i = scn.nextInt();
        int j = scn.nextInt();
        int k = scn.nextInt();
        int m = scn.nextInt();

        int onmask = (1 << i);
        int offmask = ~(1 << j);
        int togglemask = (1 << k);
        int checkmask = (1 << m);

        System.out.println(n | onmask);
        System.out.println(n & offmask);
        System.out.println(n ^ togglemask);
        System.out.println((n & checkmask) == 0 ? false : true);
        scn.close();
    }
}