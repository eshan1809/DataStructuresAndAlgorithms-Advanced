/*
1. Question will be provided with "n" meeting-schedules. A meeting-schedule is defined as (sp,ep) i.e. sp --> starting point &  ep --> ending point of an meeting. Some meeting-schedules may or maynot overlap each other.
2. MeetingIntervals[i] = [startingPointi,endingPointi]
3. A meeting-schedule represents meeting time(i.e. starting time & ending time).

Task is to "figure out, how many minimum number of meeting rooms are required to schedule all meetings?".

Example 1 : 
    Input : [[1,3],[2,4],[6,8],[10,14],[7,9]]
    Output : 2
    Explanation : Two meetings are scheduled are scheduled at a time i.e. we require atleast 2 meeting rooms to schedule meetings.

Example 2 : 
    Input : [[1,3],[3,10],[12,20]]
    Output : 1
    Explanation : There is no meeting-schedule overlap i.e. 1 meetng room can do the trick.
Example 3 : 
    Input : [[1,3],[5,8],[10,19],[15,20],[9,9]]
    Output : 2.
*/

import java.util.*;

public class meetingRooms2 {
    public static int meetingRooms(int intervals[][]) {
        // write your code here
        int n = intervals.length, curr = 0, ans = 0, j1 = 0, j2 = 0;
        int[] arr1 = new int[n], arr2 = new int[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = intervals[i][0];
            arr2[i] = intervals[i][1];
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        while (j1 < n) {
            if (arr1[j1] < arr2[j2]) {
                curr++;
                j1++;
            } else {
                curr--;
                j2++;
            }
            ans = Math.max(ans, curr);
        }
        return ans;
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
        System.out.println(meetingRooms(input));
    }
}