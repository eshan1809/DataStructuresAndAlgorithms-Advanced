/*
1. Assume you have an array of length 'n' initialized with all 0's and are given 'q' queries to update.
2. Each query is represented as a triplet: [startIndex, endIndex, inc] which increments each element of subarray A[startIndex ... endIndex] (startIndex and endIndex inclusive) with inc.
3. Return the modified array after all 'q' queries were executed.
*/

import java.util.*;

public class rangeAddition {

    // ~~~~~~~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~~~~~~

    public static int[] getModifiedArray(int length, int[][] queries) {
        // write your code here
        int[] arr = new int[length + 1], ans = new int[length];
        for (int i = 0; i < queries.length; i++) {
            arr[queries[i][0]] += queries[i][2];
            arr[queries[i][1] + 1] += -queries[i][2];
        }
        ans[0] = arr[0];
        for (int i = 1; i < length; i++)
            ans[i] = ans[i - 1] + arr[i];
        return ans;
    }

    // ~~~~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~~~~

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int length = scn.nextInt();

        int nq = scn.nextInt();

        int[][] queries = new int[nq][3];

        for (int q = 0; q < nq; q++) {
            queries[q][0] = scn.nextInt();
            queries[q][1] = scn.nextInt();
            queries[q][2] = scn.nextInt();
        }
        scn.close();
        int[] res = getModifiedArray(length, queries);

        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
}