/*
1: On a single-threaded CPU, we execute a program containing n functions. Each function has a unique ID between 0 and n-1.
2: You are required to find the total execution time of each function.
3: You are given len number of logs, where logs[i] represents the ith log message formatted as a string "{function_id}:{"start" | "end"}:{timestamp}", telling start or end time of function with id function_id.

Note that a function can be called multiple times, possibly recursively.
*/

import java.io.*;
import java.util.*;

public class exclusiveTimeOfFunctions {
    static class Pair {
        int id, st, ct;

        Pair(int x, int y, int z) {
            id = x;
            st = y;
            ct = z;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        // use read for taking input
        int n = Integer.parseInt(read.readLine()), l = Integer.parseInt(read.readLine());
        Stack<Pair> stack = new Stack<>();
        int[] arr = new int[n];
        while (l-- > 0) {
            String[] str = read.readLine().split(":");
            int id = Integer.parseInt(str[0]);
            String s = str[1];
            int time = Integer.parseInt(str[2]);
            if (s.equals("start"))
                stack.push(new Pair(id, time, 0));
            else {
                Pair p = stack.pop();
                arr[p.id] += (time - p.st + 1 - p.ct);
                if (stack.size() > 0)
                    stack.peek().ct += time - p.st + 1;
            }
        }
        for (int i : arr)
            System.out.println(i);
    }
}
