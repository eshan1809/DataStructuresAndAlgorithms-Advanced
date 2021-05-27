/*
1. Given a string s which represents an expression, evaluate this expression and return its value. 
2. while dividing (/) numbers discard the decimal part.Example 3/2 should be 1 instead of 1.5
*/

import java.io.*;

public class basicCalculator2 {
    public static int calculate(String s) {
        int n = s.length(), currNum = 0, prevNum = 0, ans = 0;
        char op = '+';
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch))
                currNum = currNum * 10 + (ch - '0');
            if (!Character.isDigit(ch) && ch != ' ' || i == n - 1) {
                if (op == '+' || op == '-') {
                    ans += prevNum;
                    prevNum = op == '+' ? currNum : -currNum;
                } else if (op == '*')
                    prevNum *= currNum;
                else if (op == '/')
                    prevNum /= currNum;
                op = ch;
                currNum = 0;
            }
        }
        return ans + prevNum;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int result = calculate(read.readLine());
        System.out.println(result);

    }
}
