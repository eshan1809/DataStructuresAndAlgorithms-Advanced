/*
1. You are given an array(arr) of integers with even length N.
2. You have to tell if it is possible to re-order the given array such that for every i in range [0,N/2)
   arr[2*i + 1] = 2 * arr[2*i], this condition holds true.
*/

import java.util.*;

public class doublePairArray {
    public static boolean solution(int[] arr) {
        // write your code here
        Arrays.sort(arr);
        int n = arr.length, k = 0;
        while (k < n && arr[k] < 0)
            k++;
        if (k % 2 != 0)
            return false;
        boolean[] used = new boolean[n];
        if (k > 0) {
            for (int i = k - 1; i >= 0; i--) {
                if (used[i])
                    continue;
                int flag = 0;
                for (int j = i - 1; j >= 0; j--) {
                    if (used[j])
                        continue;
                    if (arr[j] == 2 * arr[i]) {
                        used[j] = true;
                        flag = 1;
                        break;
                    }
                }
                if (flag == 0)
                    return false;
            }
        }
        for (int i = k; i < n; i++) {
            if (used[i])
                continue;
            int flag = 0;
            for (int j = i + 1; j < n; j++) {
                if (used[j])
                    continue;
                if (arr[j] == 2 * arr[i]) {
                    used[j] = true;
                    flag = 1;
                    break;
                }
            }
            if (flag == 0)
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
