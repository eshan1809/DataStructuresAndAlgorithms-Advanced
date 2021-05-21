/*
Given a balanced parentheses string S, compute the score of the string based on the following rule:
    () has score 1
    AB has score A + B, where A and B are balanced parentheses strings.
    (A) has score 2 * A, where A is a balanced parentheses string.

Score of ()()() string is 3 => 1 + 1 + 1
Score of (()) string is 2 => 2 * 1
*/

import java.io.*;
import java.util.*;

public class scoreOfParentheses {
    public static int getScore(String S) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(')
                st.push('(');
            else {
                char ch = st.pop();
                if (ch == '(') {
                    if (st.size() > 0 && st.peek() != '(') {
                        int y = st.pop() - '0';
                        st.push((char) ((y + 1) + '0'));
                    } else
                        st.push('1');
                } else {
                    int x = 2 * (ch - '0');
                    st.pop();
                    if (st.size() > 0 && st.peek() != '(') {
                        int y = st.pop() - '0';
                        st.push((char) ((x + y) + '0'));
                    } else
                        st.push((char) (x + '0'));
                }
            }
        }
        return (st.pop() - '0');
    }

    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int score = getScore(read.readLine());
        System.out.println(score);

    }
}
