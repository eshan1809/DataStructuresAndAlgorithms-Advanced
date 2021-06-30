/*
Given an array ht representing heights of buildings. You have to count the buildings which will see the sunrise (Assume : Sun rise on the side of array starting point).
*/

import java.util.*;

public class facingTheSun {
    public static int countBuildings(int[] ht) {
        // write your code here
        int count = 0, max = 0;
        for (int i : ht)
            if (i > max) {
                count++;
                max = i;
            }
        return count;
    }

    public static void main(String[] args) {
        // input work
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] ht = new int[n];

        for (int i = 0; i < n; i++) {
            ht[i] = scn.nextInt();
        }
        scn.close();
        System.out.println(countBuildings(ht));
    }
}