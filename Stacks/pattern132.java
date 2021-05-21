/*
Given an array of n integers nums, a 132 pattern is a subsequence of three integers nums[i], nums[j] and nums[k] such that i < j < k and nums[i] < nums[k] < nums[j].
Return true if there is a 132 pattern in nums, otherwise, return false.
*/

import java.io.*;
import java.util.*;

public class pattern132 {
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt(), flag = 0;
        int[] arr = new int[n], small = new int[n];
        small[0] = arr[0] = scn.nextInt();
        for (int i = 1; i < n; i++) {
            arr[i] = scn.nextInt();
            small[i] = Math.min(small[i - 1], arr[i]);
        }
        scn.close();
        Stack<Integer> st = new Stack<>();
        st.push(arr[n - 1]);
        for (int i = n - 2; i >= 0; i--) {
            while (st.size() > 0 && st.peek() <= small[i])
                st.pop();
            if (st.size() > 0 && arr[i] > st.peek() && arr[i] > small[i]) {
                System.out.println(true);
                flag = 1;
                break;
            }
            st.push(arr[i]);
        }
        if (flag == 0)
            System.out.println(false);
    }
}
