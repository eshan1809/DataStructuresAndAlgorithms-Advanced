/*
1. You are provided with marks of N students in Physics, Chemistry and Maths.
Perform the following 3 operations: 
a). Sort the students in Ascending order of their Physics marks.
b). Once this is done, sort the students having same marks in Physics in the descending order of their Chemistry marks.
c). Once this is also done, sort the students having same marks in Physics and Chemistry in the ascending order of their Maths marks.
2. Your task is to complete the function customSort() which takes  phy[],  chem[],  math[] .
   The function sorts the marks in the described order and the final changes should be made in the given arrays only.
*/

import java.util.*;

public class marksOfPCM {
    static class Pair implements Comparable<Pair> {
        int mp, mc, mm;

        Pair(int a, int b, int c) {
            mp = a;
            mc = b;
            mm = c;
        }

        public int compareTo(Pair o) {
            if (this.mp == o.mp) {
                if (this.mc == o.mc)
                    return this.mm - o.mm;
                return o.mc - this.mc;
            }
            return this.mp - o.mp;
        }
    }

    /*
     * You have to complete the body of customSort function, after sorting final
     * changes should be made in given arrays only.
     */
    public static void customSort(int[] phy, int[] chem, int[] math) {
        // write your code here
        int n = phy.length;
        Pair[] arr = new Pair[n];
        for (int i = 0; i < n; i++)
            arr[i] = new Pair(phy[i], chem[i], math[i]);
        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
            phy[i] = arr[i].mp;
            chem[i] = arr[i].mc;
            math[i] = arr[i].mm;
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // input work
        int N = scn.nextInt();

        int[] phy = new int[N];
        int[] chem = new int[N];
        int[] math = new int[N];

        for (int i = 0; i < N; i++) {
            phy[i] = scn.nextInt();
        }

        for (int i = 0; i < N; i++) {
            chem[i] = scn.nextInt();
        }

        for (int i = 0; i < N; i++) {
            math[i] = scn.nextInt();
        }
        scn.close();
        customSort(phy, chem, math);

        // output
        for (int i = 0; i < N; i++) {
            System.out.println(phy[i] + " " + chem[i] + " " + math[i]);
        }
    }
}