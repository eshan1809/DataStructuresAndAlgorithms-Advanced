/*
1. You are given an array asteroids of integers representing asteroids in a row.
2. For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left).
3. Each asteroid moves at the same speed.
4. You need to find out the state of the asteroids after all collisions.
5. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.
*/

import java.io.*;
import java.util.*;

public class asteroidCollision {
    static class Pair {
        int val, dir;

        Pair(int x, int y) {
            val = x;
            dir = y;
        }
    }

    public static int[] collision(int[] asteroids) {
        // complete this function
        Stack<Pair> st = new Stack<>();
        for (int i = 0; i < asteroids.length; i++) {
            if (asteroids[i] > 0) {
                st.push(new Pair(asteroids[i], 1));
            } else {
                while (st.size() > 0 && st.peek().dir == 1 && st.peek().val < Math.abs(asteroids[i]))
                    st.pop();
                if (st.size() > 0 && st.peek().dir == 1 && st.peek().val == Math.abs(asteroids[i]))
                    st.pop();
                else if ((st.size() > 0 && st.peek().dir == -1) || st.size() == 0)
                    st.push(new Pair(Math.abs(asteroids[i]), -1));
            }
        }
        int[] result = new int[st.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            Pair p = st.pop();
            result[i] = p.val * p.dir;
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(read.readLine());
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(read.readLine());
        int result[] = collision(arr);

        System.out.println(result.length);
        for (int e : result) {
            System.out.println(e);
        }
    }
}
