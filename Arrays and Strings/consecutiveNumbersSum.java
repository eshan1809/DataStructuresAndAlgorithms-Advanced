/*
1. Given an integer n.
2. Return the number of ways you can write n as the sum of consecutive positive integers.
*/

import java.util.*;

public class consecutiveNumbersSum {

    // ~~~~~~~~~~~User's Section~~~~~~~~~~~~~
    public static int solution(int n) {
        // write your code here
        int count = 0, i = 1;
        while (n > 0) {
            n -= i;
            if (n % i == 0)
                count++;
            i++;
        }
        return count;
    }

    // ~~~~~~~~~Input Management~~~~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int num = scn.nextInt();
        int res = solution(num);
        System.out.println(res);
    }
}