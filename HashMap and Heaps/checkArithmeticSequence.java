/*
1. You are given an array(arr) of integers.
2. You have to find if the elements of the given array can be arranged to form an arithmetic progression.
3. Arithmetic progression is defined as a sequence of numbers where the difference between any two consecutive numbers is the same. 
*/

import java.util.*;

public class checkArithmeticSequence {
    public static boolean solution(int[] arr) {
        // write your code here
        int len = arr.length;
        if (len == 1)
            return true;
        int min = arr[0], max = arr[0];
        Set<Integer> set = new HashSet<>();
        set.add(arr[0]);
        for (int i = 1; i < len; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
            set.add(arr[i]);
        }
        int cd = (max - min) / (len - 1);
        for (int i = 0; i < len; i++) {
            int ai = min + i * cd;
            if (!set.contains(ai))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        scn.close();
        System.out.println(solution(arr));
    }

}
