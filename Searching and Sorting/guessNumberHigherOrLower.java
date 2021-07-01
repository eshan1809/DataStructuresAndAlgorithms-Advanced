/*
1. We are playing the Guess Game. The game is as follows:
2. I pick a number from 1 to n. You have to guess which number I picked.
3. Every time you guess wrong, I will tell you whether the number I picked is higher or lower than your guess.
4. You call a pre-defined API int guess(int num), which returns 3 possible results:
   a) -1: The number I picked is lower than your guess (i.e. pick < num).
   b) 1: The number I picked is higher than your guess (i.e. pick > num).
   c). 0: The number I picked is equal to your guess (i.e. pick == num).
5. Return the number that I picked.
*/

import java.util.*;
import java.io.*;

public class guessNumberHigherOrLower {

    public static int guessNumber(int n) {
        // write your code here
        int lo = 1, hi = n;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2, x = guess(mid);
            if (x > 0)
                lo = mid + 1;
            else if (x < 0)
                hi = mid - 1;
            else
                return mid;
        }
        return 0;
    }

    static int pn = 0; // picked number

    public static int guess(int val) {
        if (val == pn) {
            return 0;
        } else if (val < pn) {
            return 1;
        } else {
            return -1;
        }
    }

    public static void solve(int n, int pick) {
        pn = pick;
        System.out.println(guessNumber(n));
    }

    public static void main(String[] args) {
        // input work
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int pick = scn.nextInt();
        scn.close();
        solve(n, pick);
    }
}