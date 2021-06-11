/*
Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.

Implement the MovingAverage class:
1. MovingAverage(int size) Initializes the object with the size of the window size.
2. double next(int val) Returns the moving average of the last size values of the stream.
*/

import java.io.*;

public class movingAverageFromDataStream {
    public static class MovingAverage {
        int[] arr;
        int idx, n, sum;
        boolean b;

        public MovingAverage(int size) {
            arr = new int[size];
            idx = 0;
            sum = 0;
            n = size;
            b = false;
        }

        public double next(int val) {
            sum = sum - arr[idx] + val;
            arr[idx] = val;
            idx++;
            if (idx == n) {
                idx = 0;
                b = true;
            }
            if (b)
                return (double) sum / n;
            return (double) sum / idx;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(read.readLine());
        MovingAverage obj = new MovingAverage(size);
        PrintWriter out = new PrintWriter(System.out);
        while (read.ready()) {
            int val = Integer.parseInt(read.readLine());
            double avg = obj.next(val);

            StringBuilder ans = new StringBuilder(String.format("%.5f", avg));
            while (ans.charAt(ans.length() - 2) != '.' && ans.charAt(ans.length() - 1) == '0') {
                ans.deleteCharAt(ans.length() - 1);
            }
            out.println(ans);
        }
        out.close();
    }
}
