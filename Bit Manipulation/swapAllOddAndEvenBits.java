/*
1. You are given a number n.
2. You have to swap all odd position bits with even position bits.
3. Every odd position bit is swapped with adjacent bit on left side.
4. Every even position bit is swapped with adjacent bit on right side.
5. Print the number formed after swapping.
*/

import java.util.*;

public class swapAllOddAndEvenBits {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        scn.close();
        // write your code here
        int maskodd = 0x55555555, maskeven = 0xAAAAAAAA;
        int odds = n & maskodd, evens = n & maskeven;
        odds <<= 1;
        evens >>= 1;
        System.out.println(odds | evens);
    }

}