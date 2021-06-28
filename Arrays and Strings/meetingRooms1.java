/*
1. Question will be provided with "n" meeting-schedules. A meeting-schedule is defined as (sp,ep) i.e. sp --> starting point &  ep --> ending point of an meeting. Some meeting-schedules may or maynot overlap each other.
2. MeetingIntervals[i] = [startingPointi,endingPointi]
3. A meeting-schedule represents meeting time(i.e. starting time & ending time).

Task is to "figure out, whether is it possible to attend all meetings or not".
*/

import java.util.Arrays;
import java.util.Scanner;

public class meetingRooms1 {
    public static boolean meetingRooms(int intervals[][]) {
        // write code here
        Arrays.sort(intervals, (int[] a, int[] b) -> {
            return a[0] - b[0];
        });
        for (int i = 1; i < intervals.length; i++)
            if (intervals[i][0] < intervals[i - 1][1])
                return false;
        return true;
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
        boolean res = meetingRooms(input);
        System.out.println(res);
    }
}