/*
1. You are given a positive number N.
2. You have to find the minimum number of operations required to convert N into 1.
3. Operations allowed :
     (i)  If n is even, you have to replace n with n/2.
     (ii) If n is odd, you can replace n with either n-1 or n+1.
*/

import java.util.*;

public class reduceNTo1 {

    public static int solution(long n) {
        // write your code here
        int ans = 0;
        while (n != 1) {
            if (n % 2 == 0)
                n /= 2;
            else if (n == 3)
                n--;
            else if ((n & 3) == 1)
                n--;
            else if ((n & 3) == 3)
                n++;
            ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        scn.close();
        System.out.println(solution(n));
    }
}