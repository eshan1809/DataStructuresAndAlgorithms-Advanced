/*
1. You are given an array of integers.
2. You are required to test whether the array represents a valid sequence of UTF-8 characters or 
     not.
3. A character in UTF-8 can be from 1 to 4 bytes long and follows some rules - 
       (i)  For 1-byte long character, first bit will be 0 and rest represents its unicode code.
       (ii) For n-bytes long character, first n-bits will be 1's, the n+1th bit is 0, followed by n-1 bytes 
             with most significant 2 bits being 10.

Note -> Only the least significant 8 bits of each element in array is used for data.
Note -> Check out the question video for details.
*/

import java.util.*;

public class UTF8Encoding {

    public static boolean solution(int[] arr) {
        // write your code here
        int rem = 0;
        for (int val : arr) {
            if ((val >> 7) == 0b0) {
                if (rem > 0)
                    return false;
            } else if ((val >> 5) == 0b110) {
                if (rem > 0)
                    return false;
                rem = 1;
            } else if ((val >> 4) == 0b1110) {
                if (rem > 0)
                    return false;
                rem = 2;
            } else if ((val >> 3) == 0b11110) {
                if (rem > 0)
                    return false;
                rem = 3;
            } else {
                if ((val >> 6) == 0b10 && rem > 0)
                    rem--;
                else
                    return false;
            }
        }
        return rem == 0;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        scn.close();
        System.out.println(solution(arr));
    }

}