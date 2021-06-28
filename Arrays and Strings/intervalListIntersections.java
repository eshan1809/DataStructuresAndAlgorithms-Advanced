/*
1. Question will be provided with two Intervals Lists.
2. An interval is is defined as (sp,ep) i.e. sp --> starting point &  ep --> ending point of an interval
3. All intervals are closed in nature
4. Intervals[i] = [startingPointi,endingPointi]
5. Both interval lists are sorted in nature(sorted based upon starting time of each interval).

Task is to "find & print all intersection of intervals from both interval lists(intervals from list 1 & list 2).".

Example 1 : 
    list_1 : [[1,3]] 
    list_2 : [[2,5]]
    Output : [[2,3]]
    Explanation : interval from list 1 starts @ 1 & ends @ 3 where as interval from list 2 starts @ 2 & ends @ 5 thus intersection(time span common in intervals from both lists) is {2,3}.

Example 2 : 
    list_1 : [[1,3]] 
    list_2 : [[4,5]]
    Output : []
    Explanation : there is no common time-span(i.e. no intersection)  between intervals from both given list.
Example 3 : 
    list_1 : [[1,3] [5,10] [12,17]] 
    list_2 : [[2,4] [5,7] [9,13]]
    Output : [[2,3] [5,7] [9,10] [12,13]]
*/

import java.util.*;

public class intervalListIntersections {
    static class Pair {
        int st, et;

        Pair(int a, int b) {
            st = a;
            et = b;
        }
    }

    public static int[][] intersection(int intervalList1[][], int intervalList2[][]) {
        // write your code here
        List<Pair> list = new ArrayList<>();
        int i = 0, j = 0;
        while (i < intervalList1.length && j < intervalList2.length) {
            int st = Math.max(intervalList1[i][0], intervalList2[j][0]);
            int et = Math.min(intervalList1[i][1], intervalList2[j][1]);
            if (st <= et)
                list.add(new Pair(st, et));
            if (et == intervalList1[i][1])
                i++;
            else
                j++;
        }
        int[][] arr = new int[list.size()][2];
        for (i = 0; i < list.size(); i++) {
            arr[i][0] = list.get(i).st;
            arr[i][1] = list.get(i).et;
        }
        return arr;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        // Input format
        int n = scn.nextInt();
        int list1[][] = new int[n][2];
        for (int i = 0; i < n; i++) {
            list1[i][0] = scn.nextInt();
            list1[i][1] = scn.nextInt();
        }

        int m = scn.nextInt();
        int list2[][] = new int[m][2];
        for (int i = 0; i < m; i++) {
            list2[i][0] = scn.nextInt();
            list2[i][1] = scn.nextInt();
        }
        scn.close();
        // output
        int ans[][] = intersection(list1, list2);
        System.out.print("[");
        for (int interval[] : ans) {
            System.out.print(Arrays.toString(interval));
        }
        System.out.println("]");
    }
}
