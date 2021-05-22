/*
1. You are given a number n, representing the size of array a.
2. You are given n numbers, representing the height of bars in a bar chart.
3. You are required to find and print the area of largest rectangle in the histogram.
*/

import java.io.*;
import java.util.*;

public class largestAreaHistogram {
    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] nsl = new int[n], nsr = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (st.size() > 0 && heights[st.peek()] >= heights[i])
                st.pop();
            if (st.size() == 0)
                nsl[i] = i + 1;
            else
                nsl[i] = i - st.peek();
            st.push(i);
        }
        st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (st.size() > 0 && heights[st.peek()] >= heights[i])
                st.pop();
            if (st.size() == 0)
                nsr[i] = n - i;
            else
                nsr[i] = st.peek() - i;
            st.push(i);
        }
        int max = 0;
        for (int i = 0; i < n; i++)
            max = Math.max(max, (nsl[i] + nsr[i] - 1) * heights[i]);
        return max;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(read.readLine());
        int heights[] = new int[n];
        for (int i = 0; i < n; i++)
            heights[i] = Integer.parseInt(read.readLine());

        System.out.println(largestRectangleArea(heights));

    }
}
