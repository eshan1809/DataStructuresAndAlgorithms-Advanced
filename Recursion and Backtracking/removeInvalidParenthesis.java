
import java.io.*;
import java.util.*;

public class removeInvalidParenthesis {
    public static void solution(String str, int minRemoval, HashSet<String> ans) {
        if (minRemoval == 0) {
            if (getMin(str) == 0) {
                if (!ans.contains(str)) {
                    ans.add(str);
                    System.out.println(str);
                }
            }
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            String left = str.substring(0, i);
            String right = str.substring(i + 1);
            solution(left + right, minRemoval - 1, ans);
        }
    }

    public static int getMin(String str) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(') {
                st.push(ch);
            } else {
                if (st.size() > 0 && st.peek() == '(') {
                    st.pop();
                } else {
                    st.push(ch);
                }
            }
        }
        return st.size();
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        solution(str, getMin(str), new HashSet<>());
        scn.close();
    }

}