/*
Given string num representing a non-negative integer num, and an integer k, print the smallest possible integer after removing k digits from num.
*/

import java.io.*;
import java.util.*;

public class removeKDigits {
    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        String num = read.readLine();
        int k = Integer.parseInt(read.readLine());

        // write your code here
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < num.length(); i++) {
            int x = num.charAt(i) - '0';
            while (st.size() > 0 && st.peek() > x && k > 0) {
                st.pop();
                k--;
            }
            st.push(x);
        }
        while (k > 0 && st.size() > 0) {
            st.pop();
            k--;
        }
        if (st.size() == 0)
            System.out.println(0);
        else {
            String ans = "";
            while (st.size() > 0)
                ans = st.pop() + ans;
            int i = 0;
            while (i < ans.length() && ans.charAt(i) == '0')
                i++;
            if (i == ans.length())
                System.out.println(0);
            else
                System.out.println(ans.substring(i));
        }
    }
}
