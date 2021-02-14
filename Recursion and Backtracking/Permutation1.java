/*
 * 1. You are give a number of boxes (nboxes) and number of non-identical items
 * (ritems). 2. You are required to place the items in those boxes and print all
 * such configurations possible.
 */

import java.io.*;

public class Permutation1 {

    public static void permutations(int[] boxes, int ci, int ti) {
        if (ci > ti) {
            for (int i : boxes) {
                System.out.print(i);
            }
            System.out.println();
            return;
        }
        for (int i = 0; i < boxes.length; i++) {
            if (boxes[i] == 0) {
                boxes[i] = ci;
                permutations(boxes, ci + 1, ti);
                boxes[i] = 0;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nboxes = Integer.parseInt(br.readLine());
        int ritems = Integer.parseInt(br.readLine());
        permutations(new int[nboxes], 1, ritems);
    }

}