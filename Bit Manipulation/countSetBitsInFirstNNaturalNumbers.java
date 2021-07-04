/*
1. You are given a number n.
2. You have to print the count of set bits of first n natural numbers.
*/

import java.util.*;

public class countSetBitsInFirstNNaturalNumbers {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        scn.close();
        System.out.println(solution(n));
    }

    public static int solution(int n) {
        // write your code here
        if (n == 0)
            return 0;
        int x = largetPowOf2(n);
        int bit = x * (1 << (x - 1));
        int msb = n - (1 << x) + 1;
        return bit + msb + solution(n - (1 << x));
    }

    public static int largetPowOf2(int n) {
        int x = 0;
        while ((1 << x) <= n)
            x++;
        return x - 1;
    }
}