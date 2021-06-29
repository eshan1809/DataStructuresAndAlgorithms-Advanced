/*
1. You are given an array which represents heights of consecutive buildings.
2. You can move from the roof of a building to the roof of next adjacent building. 
3. You need to find the maximum number of consecutive steps you can put forward such that you gain an increase in altitude with each step.
*/

import java.util.*;

public class roofTop {

    public static int findMaxSteps(int[] arr) {
        // write your code here
        int curr = 0, ans = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1])
                curr++;
            else
                curr = 0;
            ans = Math.max(ans, curr);
        }
        return ans;
    }

    public static void main(String[] args) {
        // input work
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        scn.close();
        int ans = findMaxSteps(arr);
        System.out.println(ans);
    }
}