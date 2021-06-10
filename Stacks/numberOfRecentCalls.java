/*
You have a RecentCounter class which counts the number of recent requests within a certain time frame.

Implement the RecentCounter class:
1. RecentCounter() Initializes the counter with zero recent requests.
2. int ping(int t) Adds a new request at time t, where t represents some time in milliseconds, and returns the number of requests that has happened in the past 3000 milliseconds (including the new request). Specifically, return the number of requests that have happened in the inclusive range [t - 3000, t].

It is guaranteed that every call to ping uses a strictly larger value of t than the previous call.
*/

import java.io.*;
import java.util.*;

public class numberOfRecentCalls {
    public static class RecentCounter {
        LinkedList<Integer> list;

        public RecentCounter() {
            list = new LinkedList<Integer>();
        }

        public int ping(int t) {
            list.addLast(t);
            while (list.getFirst() < t - 3000)
                list.removeFirst();
            return list.size();
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        RecentCounter obj = new RecentCounter();

        while (read.ready()) {
            int val = Integer.parseInt(read.readLine());
            int ans = obj.ping(val);
            System.out.println(ans);
        }

    }
}
