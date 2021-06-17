/*
1: Given a string s of '(' , ')' and lowercase English characters
2: Your task is to remove the minimum number of parentheses ( '(' or ')') so that the resulting parentheses string is valid and return it.
3: In case of multiple valid strings give precedence in keeping innermost parenthesis.

example
(a(b(c)d) this string has (a(bc)d), (ab(c)d) and a(b(c)d) 3 valid strings.
Among all 3 valid strings a(b(c)d) has the innermost parentheses.
*/

import java.io.*;
import java.util.*;

public class minimumRemoveToMakeValidParentheses {
    public static String reverseParentheses(String s) {
        Stack<String> st = new Stack<>();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                st.push(ch + "");
                count++;
            } else if (ch == ')') {
                if (count > 0) {
                    String str = "";
                    while (!st.peek().equals("("))
                        str = st.pop() + str;
                    st.pop();
                    st.push('(' + str + ')');
                    count--;
                }
            } else
                st.push(ch + "");
        }
        String str = "";
        while (st.size() > 0) {
            String a = st.pop();
            if (count > 0 && a.equals("("))
                count--;
            else
                str = a + str;
        }
        return str;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        String result = reverseParentheses(read.readLine());
        System.out.println(result);

    }
}
