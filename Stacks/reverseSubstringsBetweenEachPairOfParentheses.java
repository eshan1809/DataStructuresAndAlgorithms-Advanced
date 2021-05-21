/*
1: You are given a string s that consists of lower case English letters and brackets. 
2: Reverse the strings in each pair of matching parentheses, starting from the innermost one.
3: Your result should not contain any brackets.

Example
(abcd) -> dcba
(u(love)i) -> iloveu
(gni(pc(do))ep) -> pepcoding
*/

import java.io.*;
import java.util.*;

public class reverseSubstringsBetweenEachPairOfParentheses {
    public static String reverseParentheses(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ')') {
                Queue<Character> q = new ArrayDeque<Character>();
                while (st.peek() != '(')
                    q.add(st.pop());
                ;
                st.pop();
                while (q.size() > 0)
                    st.push(q.remove());
            } else
                st.push(ch);
        }
        String str = "";
        while (st.size() > 0)
            str += st.pop();
        return str;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        String result = reverseParentheses(read.readLine());
        System.out.println(result);

    }
}
