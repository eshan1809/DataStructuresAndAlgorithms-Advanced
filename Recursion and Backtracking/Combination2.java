/*
 * 1. You are give a number of boxes (nboxes) and number of identical items
 * (ritems). 2. You are required to place the items in those boxes and print all
 * such configurations possible.
 */

import java.io.*;
import java.util.*;

public class Combination2 {

    public static int checkone(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                count++;
            }
        }
        return count;
    }

    public static void combinations(int[] boxes, int ci, int ti, int lb) {
        if (ci > ti) {

            for (int i : boxes) {
                if (i == 1) {
                    System.out.print("i");
                } else {
                    System.out.print("-");
                }
            }
            System.out.println();
            return;
        }
        for (int i = lb + 1; i < boxes.length; i++) {
            boxes[i] = 1;
            combinations(boxes, ci + 1, ti, i);
            boxes[i] = 0;
        }
        // combinations(boxes, ci + 1, ti, lb);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nboxes = Integer.parseInt(br.readLine());
        int ritems = Integer.parseInt(br.readLine());
        combinations(new int[nboxes], 1, ritems, -1);
    }

}