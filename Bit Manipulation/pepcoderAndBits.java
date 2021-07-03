/*
1. Pepcoder is feeling confident after solving many problems on Bit Manipulation.
2. So, his teacher ask him to find out the count of positive integers strictly less than N, having same 
     number of set bits as that of N.
3. Let us see that if pepcoder can solve it or not.
*/

import java.util.*;

public class pepcoderAndBits {
    public static long ncr(long n, long r) {
        if (n < r) {
            return 0L;
        }

        long res = 1L;

        for (long i = 0L; i < r; i++) {
            res = res * (n - i);
            res = res / (i + 1);
        }

        return res;
    }

    public static long solution(long n, int k, int i) {
        if (i == 0)
            return 0;
        long mask = (1L << i);
        long res = 0;
        if ((n & mask) == 0)
            res = solution(n, k, i - 1);
        else
            res = solution(n, k - 1, i - 1) + ncr(i, k);
        return res;
    }

    public static int csb(long n) {
        int res = 0;

        while (n > 0) {
            long rsb = n & -n;
            n -= rsb;
            res++;
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        long n = scn.nextLong();
        scn.close();
        int k = csb(n);
        System.out.println(solution(n, k, 63));
    }

}