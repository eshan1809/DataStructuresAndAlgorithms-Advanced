/*
Description : 
1. Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.
2. In Pascal's triangle, each number is the sum of the two numbers directly above OR it is also a pattern which can be made from combination maths
3. For More clearance, watch video till explanation of question.
eg. 
row 0 -> 1
row 1 -> 1 1
row 2 -> 1 2 1
row 3 -> 1 3 3 1
row 4 -> 1 4 6 4 1
*/

import java.util.*;

public class pascalsTriangle2 {

    // ~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~
    public static ArrayList<Integer> pascalRow(int r) {
        // write your code here
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= r; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    temp.add(1);
                } else {
                    temp.add(list.get(i - 1).get(j - 1) + list.get(i - 1).get(j));
                }
            }
            list.add(temp);
        }
        return list.get(list.size() - 1);
    }

    // ~~~~~~~~~~~Input management~~~~~~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        scn.close();
        ArrayList<Integer> res = pascalRow(n);
        for (int val : res) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}