/*
1. You are given a number n.
2. You have to check whether it is a power of 2 or not.
*/

import java.util.*;

public class isAPowerOf2 {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        scn.close();
        // write your code here
        int res = 0;
        while (n > 0) {
            long rsb = (n & -n);
            n -= rsb;
            res++;
            if (res > 1)
                break;
        }
        System.out.println(res == 1);
    }

}