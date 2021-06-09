/*
1. You are given a string s determine if it is valid or not.
2. A valid string is a string that can be created by inserting abc at any index any number of times.

Example:
aabcbc can be created 
"" -> "abc" -> "aabcbc"

while it is impossible to create abccba.
*/

import java.io.*;
import java.util.*;

public class checkIfWordIsValidAfterInsertion {
    public static boolean isValid(String s) {
        // write your code here
        if (s.length() < 3 || s.charAt(0) != 'a' || s.charAt(s.length() - 1) != 'c')
            return false;
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'c') {
                if (st.size() == 0 || st.pop() != 'b' || st.size() == 0 || st.pop() != 'a')
                    return false;
            } else
                st.push(s.charAt(i));
        }
        return st.size() == 0;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        boolean result = isValid(read.readLine());
        System.out.println(result);

    }
}
