/*
1. The gray code is a binary numeral system where two successive numbers differ in only one bit.
2. Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.
*/

import java.util.*;

public class GrayCode {
    public static List<Integer> grayCode(int n) {
        List<Integer> ans = new ArrayList<>();
        backtrack(ans, n);
        return ans;
    }

    static int temp = 0;

    private static void backtrack(List<Integer> ans, int n) {
        if (n == 0) {
            ans.add(temp);
            return;
        }

        backtrack(ans, n - 1);

        temp = temp ^ (1 << (n - 1));
        backtrack(ans, n - 1);
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        List<Integer> ans = grayCode(scn.nextInt());
        Collections.sort(ans);
        System.out.println(ans);
        scn.close();
    }
}
