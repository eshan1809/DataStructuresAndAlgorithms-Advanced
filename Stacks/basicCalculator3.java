/*
1. Implement a basic calculator to evaluate a simple expression string.
2. String will contain only non-negative integers, '+', '-', '*', '/' operators, and open '(' and closing parentheses ')'. 
3. All intermediate results will be in the range of [-2^31, 2^31 - 1].
*/

import java.io.*;

public class basicCalculator3 {
    public static int calculate(String s) {
        int n = s.length(), currNum = 0, prevNum = 0, ans = 0;
        char op = '+';
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                int j = i, count = 1;
                while (count != 0) {
                    j++;
                    if (s.charAt(j) == '(')
                        count++;
                    else if (s.charAt(j) == ')')
                        count--;
                }
                int x = calculate(s.substring(i + 1, j));
                i = j;
                currNum += x;
            }
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
