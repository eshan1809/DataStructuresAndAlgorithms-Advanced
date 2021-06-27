/*
Given a String of Characters.
Task is to "Find Minimum length of string after removing similar ends ?."

Example 1 : 
    Intput : "pepepep"
    Output : 1
    Explanation : After removing "pep" from start & end of String will leave only 1 length string.

Example 2 : 
    Input : "aaabbcdaoddcccbaa"
    Ouput : 2
    Explanation : 
            1. remove "aaa" from left end & "aa" from right end(as they have similar characters)
            2. remove "bb" from left end & "b" from right end(as they have similar characters)
            3. remove "c" from left end & "ccc" from right end(as they have similar characters)
            4. remove "d" from left end & "dd" from right end(as they have similar characters)
            5. removing similars will ensure a String of length 2 i.e. "ao"
Example 3 : 
    Input : "abcd"
    Output : 4
    Explanation : No similar characters on both ends.

Example 4 : 
    Input : "aabccba"
    Output : 0
*/

import java.util.Scanner;

public class minLenOfStringAfterRemovingSimilarEnds {
    public static int minLen(String s) {
        // write your code here
        int i = 0, j = s.length() - 1;
        while (i < j) {
            char ch1 = s.charAt(i);
            char ch2 = s.charAt(j);
            int x = i, y = j;
            while (x + 1 < s.length() && ch1 == s.charAt(x + 1))
                x++;
            while (y - 1 >= 0 && ch2 == s.charAt(y - 1))
                y--;
            if (ch1 == ch2) {
                i = x + 1;
                j = y - 1;
            } else
                break;
        }
        return Math.max(j - i + 1, 0);
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String inp = scn.nextLine();
        scn.close();
        int len = minLen(inp);
        System.out.println(len);
    }
}
