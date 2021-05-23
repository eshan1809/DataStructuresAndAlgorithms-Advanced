/*
1. Given a rows x cols binary matrix filled with 0's and 1's.
2. Find the largest rectangle containing only 1's and return its area.
*/

import java.io.*;
import java.util.*;

public class maximalRectangle {
    public static int maxArea(int[] arr) {
        int[] rb = new int[arr.length], lb = new int[arr.length];

        Stack<Integer> st = new Stack<>();
        st.push(arr.length - 1);
        rb[arr.length - 1] = arr.length;
        for (int i = arr.length - 2; i >= 0; i--) {
            while (st.size() > 0 && arr[i] <= arr[st.peek()])
                st.pop();
            if (st.size() == 0)
                rb[i] = arr.length;
            else
                rb[i] = st.peek();
            st.push(i);
        }

        st = new Stack<>();
        st.push(0);
        lb[0] = -1;
        for (int i = 1; i < arr.length; i++) {
            while (st.size() > 0 && arr[i] <= arr[st.peek()])
                st.pop();
            if (st.size() == 0)
                lb[i] = -1;
            else
                lb[i] = st.peek();
            st.push(i);
        }

        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            int area = (rb[i] - lb[i] - 1) * arr[i];
            if (area > max)
                max = area;
        }

        return max;
    }

    public static int maxRectangle(int[][] arr) {
        if (arr.length == 0)
            return 0;
        int max = 0;
        int[][] dp = new int[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                dp[i][j] = arr[i][j];
                if (i > 0 && dp[i][j] != 0)
                    dp[i][j] += dp[i - 1][j];
            }
            max = Math.max(max, maxArea(dp[i]));
        }
        return max;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int row = Integer.parseInt(read.readLine());
        int col = Integer.parseInt(read.readLine());

        int bmat[][] = new int[row][col];

        for (int i = 0; i < row; i++) {
            String s = read.readLine();
            for (int j = 0; j < col; j++) {
                bmat[i][j] = s.charAt(j) - '0';
            }
        }

        int result = maxRectangle(bmat);
        System.out.println(result);

    }
}
