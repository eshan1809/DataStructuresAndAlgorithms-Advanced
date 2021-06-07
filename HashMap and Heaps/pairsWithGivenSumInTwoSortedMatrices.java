/*
1. You are given a number N and two sorted matrices(A and B) of N*N dimensions.
2. You are also given a number X.
3. You have to find the count of all valid pairs from matrices whose sum is equal to X.
4. A pair is called valid if one element of the pair is selected from A and the second element is selected from B.
*/

import java.util.*;

public class pairsWithGivenSumInTwoSortedMatrices {
    public static int solve(int[][] num1, int[][] num2, int k) {
        // write your code here
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] num : num1)
            for (int i : num)
                map.put(i, map.getOrDefault(i, 0) + 1);
        int ans = 0;
        for (int[] num : num2)
            for (int i : num)
                ans += map.getOrDefault(k - i, 0);
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] mat1 = new int[N][N];
        for (int i = 0; i < mat1.length; i++) {
            for (int j = 0; j < mat1[0].length; j++) {
                mat1[i][j] = sc.nextInt();
            }
        }

        int[][] mat2 = new int[N][N];
        for (int i = 0; i < mat2.length; i++) {
            for (int j = 0; j < mat2[0].length; j++) {
                mat2[i][j] = sc.nextInt();
            }
        }
        int K = sc.nextInt();
        sc.close();
        System.out.println(solve(mat1, mat2, K));

    }
}
