/*
1. You are given an array(arr) which contains only 0's and 1's.
2. You have to find the maximum number of consecutive 1's in the given array if you can flip at most one zero.
*/

import java.util.*;

public class maximumConsecutiveOnes_1 {
    public static int solution(int[] arr) {
        // write your code here
        int zero = 0, i = 0, j = 0, ans = 0;
        while (true) {
            while (j < arr.length && zero < 2) {
                if (arr[j] == 0)
                    zero++;
                if (arr[j] == 1 || zero < 2)
                    ans = Math.max(ans, j - i + 1);
                j++;
            }
            while (i < arr.length && arr[i] == 1)
                i++;
            i++;
            zero--;
            if (i >= arr.length)
                break;
        }
        return ans;
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
