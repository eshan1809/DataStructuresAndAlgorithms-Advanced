/*
1. You are given a binary string which represents a number.
2. You have to check whether this number is divisible by 3 or not.
3. Print 'true' if it is divisible by 3, otherwise print 'false'.
*/

import java.util.*;

public class checkDivisibilityBy3 {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        scn.close();
        // write your code here
        int odd = 0, even = 0;
        for (int i = 0; i < str.length(); i++) {
            if (i % 2 == 0)
                even += str.charAt(i) - '0';
            else
                odd += str.charAt(i) - '0';
        }
        System.out.println((even - odd) % 11 == 0);
    }

}