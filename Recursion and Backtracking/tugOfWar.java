/*
 * 1. You are given an array of n integers. 2. You have to divide these n
 * integers into 2 subsets such that the difference of sum of two subsets is as
 * minimum as possible. 3. If n is even, both set will contain exactly n/2
 * elements. If is odd, one set will contain (n-1)/2 and other set will contain
 * (n+1)/2 elements. 3. If it is not possible to divide, then print "-1".
 */

import java.util.*;

public class tugOfWar {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int[] arr = new int[scn.nextInt()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        solve(arr, 0, new ArrayList<>(), new ArrayList<>(), 0, 0);
        System.out.println(ans);
        scn.close();
    }

    static int mindiff = Integer.MAX_VALUE;
    static String ans = "";

    public static void solve(int[] arr, int vidx, ArrayList<Integer> set1, ArrayList<Integer> set2, int soset1,
            int soset2) {
        if (vidx == arr.length) {
            if (Math.abs(set1.size() - set2.size()) > 1) {
                return;
            }
            if (Math.abs(soset1 - soset2) < mindiff) {
                mindiff = Math.abs(soset1 - soset2);
                ans = set1 + " " + set2;
            }
            return;
        }
        int x = arr[vidx];
        set1.add(x);
        solve(arr, vidx + 1, set1, set2, soset1 + x, soset2);
        set1.remove(set1.size() - 1);

        set2.add(x);
        solve(arr, vidx + 1, set1, set2, soset1, soset2 + x);
        set2.remove(set2.size() - 1);
    }

}