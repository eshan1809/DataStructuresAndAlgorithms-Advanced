/*
1. You are given a number n.
2. You have to count the number of set bits in the given number.
*/

import java.util.*;

public class KernighansAlgorithm {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int cs = 0;
        while (n != 0) {
            int rsbm = (n & -n);
            n -= rsbm;
            cs++;
        }
        System.out.println(cs);
        scn.close();
    }
}
