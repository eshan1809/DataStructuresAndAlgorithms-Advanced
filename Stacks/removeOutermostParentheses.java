/*
1. You are given a valid parentheses string in form of A+B+C... where A, B and C are valid primitive strings.
2. A primitive string is a valid parentheses string which cant is split in s = x+y, with x and y nonempty valid parentheses strings.
3. You have to remove the outermost parentheses from all primitive strings.

Example "(()())(())" = "(()())" + "(())".
removing outermost parentheses from "(()())" and "(())" will result in ()()().
*/

import java.io.*;

public class removeOutermostParentheses {
    public static String removeOuterParentheses(String s) {
        // write your code here
        String str = "";
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' && count++ > 0)
                str += '(';
            if (s.charAt(i) == ')' && --count > 0)
                str += ')';
        }
        return str;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        String result = removeOuterParentheses(read.readLine());
        System.out.println(result);
    }
}
