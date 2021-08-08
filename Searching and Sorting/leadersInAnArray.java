/*
Given an array A of positive integers. Your task is to find the leaders in the array. An element of array is leader if it is greater than or equal to all the elements to its right side. The rightmost element is always a leader. 
*/

import java.util.*;
import java.io.*;

public class leadersInAnArray {

    public static ArrayList<Integer> leaders(int[] arr) {
        int max = 0, n = arr.length;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = n - 1; i >= 0; i--)
            if (arr[i] >= max) {
                max = arr[i];
                list.add(max);
            }
        Collections.reverse(list);
        return list;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        scn.close();
        ArrayList<Integer> ans = leaders(arr);

        for (int val : ans) {
            System.out.print(val + " ");
        }
    }
}