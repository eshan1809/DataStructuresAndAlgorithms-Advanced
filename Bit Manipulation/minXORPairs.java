/*
1. You are given an array of distinct integers.
2. You have to print all pairs of integers in the array whose XOR value is minimum.
*/

import java.util.*;

public class minXORPairs {

    public static void solution(int[] arr) {
        // write your code here
        Arrays.sort(arr);
        List<String> list = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - 1; i++) {
            if ((arr[i] ^ arr[i + 1]) < min) {
                min = (arr[i] ^ arr[i + 1]);
                list = new ArrayList<>();
                list.add(arr[i] + ", " + arr[i + 1]);
            } else if ((arr[i] ^ arr[i + 1]) == min)
                list.add(arr[i] + ", " + arr[i + 1]);
        }
        for (String ans : list)
            System.out.println(ans);
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        scn.close();
        solution(arr);
    }

}