/*
1. Question will be provided with "n" Intervals. An Interval is defined as (sp,ep) i.e. sp --> starting point &  ep --> ending point of an Interval (sp/ep are inclusive). Some Intervals may or maynot overlap eachother.
2. Intervals[i] = [startingPoint,endingPoint]
Task is to "Merge all Overlapping Intervals".

Example 1 : 
    Input : [[1,3],[2,4],[6,8],[10,14],[7,9]]
    Output : [[1,4],[6,9],[10,14]]

Example 2 : 
    Input : [[1,3],[3,15],[6,8],[10,14],[7,9]]
    Output : [[1,15][3,15]]
Example 3 : 
    Input : [[1,3],[5,8],[10,19],[15,20],[9,9]]
    Output : [[1,3],[5,8],[9,9],[10,20]]
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class mergeIntervals {
    static class Pair {
        int start, end;

        Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static int[][] merge(int intervals[][]) {
        // write your code here
        if (intervals.length == 0)
            return new int[0][0];
        Arrays.sort(intervals, (i1, i2) -> i1[0] - i2[0]);
        ArrayList<Pair> st = new ArrayList<>();
        st.add(new Pair(intervals[0][0], intervals[0][1]));
        for (int i = 1; i < intervals.length; i++) {
            Pair p = st.remove(st.size() - 1);
            if (p.end > intervals[i][0]) {
                p.end = Math.max(intervals[i][1], p.end);
                st.add(p);
            } else {
                st.add(p);
                st.add(new Pair(intervals[i][0], intervals[i][1]));
            }
        }
        int[][] res = new int[st.size()][2];
        for (int i = res.length - 1; i >= 0; i--) {
            Pair p = st.remove(st.size() - 1);
            res[i][0] = p.start;
            res[i][1] = p.end;
        }
        return res;
    }

    public static void main(String args[]) {
        Scanner scn = new Scanner(System.in);

        // Input Format
        int n = scn.nextInt();
        int input[][] = new int[n][2];

        for (int i = 0; i < n; i++) {
            int sp = scn.nextInt();
            int ep = scn.nextInt();

            input[i][0] = sp;
            input[i][1] = ep;
        }
        scn.close();
        // Output Format
        int[][] output = merge(input);

        System.out.print("[");
        for (int arr[] : output) {
            System.out.print(Arrays.toString(arr));
        }
        System.out.println("]");
    }
}