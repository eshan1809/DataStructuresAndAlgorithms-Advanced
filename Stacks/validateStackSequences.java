/*
1: Given two sequences pushed and popped with distinct values.
2: You have to return true if and only if this could have been the result of a sequence of push and pop operations on an initially empty stack
*/

import java.io.*;
import java.util.*;

public class validateStackSequences {
    public static boolean isValidateStackSequences(int[] pushed, int[] popped) {
        // Write Your's code here
        Stack<Integer> st = new Stack<>();
        int i = 0, j = 0;
        while (i < pushed.length) {
            st.push(pushed[i]);
            i++;
            while (j < i && popped[j] == st.peek()) {
                st.pop();
                j++;
            }
        }
        while (j < popped.length) {
            if (st.peek() == popped[j]) {
                st.pop();
                j++;
            } else
                return false;
        }
        return true;
    }

    public static int[] getArr(String s) {
        String nums[] = s.split(" ");
        int n = nums.length;
        int ar[] = new int[n];
        for (int i = 0; i < n; i++) {
            ar[i] = Integer.parseInt(nums[i]);
        }
        return ar;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int pushed[] = getArr(read.readLine());
        int popped[] = getArr(read.readLine());

        boolean result = isValidateStackSequences(pushed, popped);

        System.out.println(result);
    }
}
