
/*
1. IntervalList & a newInterval will be given as input.
2. IntervalList is a sequence of sorted(on the basis of start time) & non-overlapping intervals.
3. any interval[i] (from IntervalList) = [startTime,endTime].
4. a newInterval will also be passed as input.
Task is to "Insert this newInterval to the given sorted IntervalList".
NOTE : Inserting this newInterval may lead to merging of intervals.

Example 1 : 
    IntervalList = [[1,5][8,10]]
    newInterval = [3,8]
    OUTPUT : [[1,10]].
    Explanation : after inserting newInterval (3,8) ,every interval can now be merged to (1,10).

Example 2 : 
    IntervalList = [[1,5][8,10]]
    newInterval = [3,6]
    OUTPUT : [[1,6][8,10]].

Example 3 :
    IntervalList = [[3,5][8,10]]
    newInterval = [1,2]
    OUTPUT : [[1,2][3,5][8,10]].
    
Example 4 : 
    IntervalList = []
    newInterval = [3,8]
    OUTPUT : [[3,8]].
*/

import java.util.*;

public class insertIntervals {
    static class Pair {
        int start, end;

        Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static int[][] solve(int[][] intervals, int[] newInterval) {
        // write your code here
        int[][] finalIntervals = new int[intervals.length + 1][2];
        for (int i = 0; i < intervals.length; i++) {
            finalIntervals[i][0] = intervals[i][0];
            finalIntervals[i][1] = intervals[i][1];
        }
        finalIntervals[finalIntervals.length - 1][0] = newInterval[0];
        finalIntervals[finalIntervals.length - 1][1] = newInterval[1];
        Arrays.sort(finalIntervals, (i1, i2) -> i1[0] - i2[0]);
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(finalIntervals[0][0], finalIntervals[0][1]));
        for (int i = 1; i < finalIntervals.length; i++) {
            Pair p = st.pop();
            if (p.end >= finalIntervals[i][0]) {
                p.end = Math.max(finalIntervals[i][1], p.end);
                st.push(p);
            } else {
                st.push(p);
                st.push(new Pair(finalIntervals[i][0], finalIntervals[i][1]));
            }
        }
        int[][] res = new int[st.size()][2];
        for (int i = res.length - 1; i >= 0; i--) {
            Pair p = st.pop();
            res[i][0] = p.start;
            res[i][1] = p.end;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int intervalList[][] = new int[n][2];
        for (int i = 0; i < n; i++) {
            int st = scn.nextInt();
            int et = scn.nextInt();

            intervalList[i][0] = st;
            intervalList[i][1] = et;
        }
        int newInterval[] = new int[2];
        newInterval[0] = scn.nextInt();
        newInterval[1] = scn.nextInt();
        scn.close();
        int ans[][] = solve(intervalList, newInterval);

        System.out.print("[");
        for (int interval[] : ans) {
            System.out.print(Arrays.toString(interval));
        }
        System.out.println("]");

    }
}