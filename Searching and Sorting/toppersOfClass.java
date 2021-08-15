/*
1. There is a class of N students and the task is to find the top K marks scorers. 
2. You need to print the index of the toppers of the class which will be same as the index of the student in the input array (use 0-based indexing). 
3. First print the index of the students having highest marks then the students with second highest and so on. If there are more than one students having same marks then print their indices in ascending order.Suppose k = 2 and the students having highest marks have indices 0 and 5 and students having second highest marks have indices 6 and 7 then output will be 0 5 6 7.
*/

import java.util.*;

public class toppersOfClass {
    static class Pair implements Comparable<Pair> {
        int idx, val;

        Pair(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }

        public int compareTo(Pair o) {
            if (this.val != o.val)
                return this.val - o.val;
            return o.idx - this.idx;
        }
    }

    public static int[] kToppers(int[] marks, int k) {
        // write your code here
        int n = marks.length;
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.add(new Pair(i, marks[i]));
            if (pq.size() > k)
                pq.remove();
        }
        int[] ans = new int[k];
        for (int i = k - 1; i >= 0; i--)
            ans[i] = pq.remove().idx;
        return ans;
    }

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] marks = new int[n];

        for (int i = 0; i < n; i++) {
            marks[i] = scn.nextInt();
        }

        int k = scn.nextInt();
        scn.close();
        int[] ans = kToppers(marks, k);

        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }

    }
}
