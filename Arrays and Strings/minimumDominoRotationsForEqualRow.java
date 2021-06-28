/*
1. In a row of dominoes, tops[i] and bottoms[i] represent the top and bottom halves of the ith domino. 
2. A domino(Dice Structured) is a tile with two numbers from 1 to 6 - one on each half of the tile.
3. We may rotate the ith domino, so that tops[i] and bottoms[i] swap values.
4. Return the minimum number of rotations so that all the values in tops are the same, or all the values in bottoms are the same.
5. If it cannot be done, return -1.
*/

import java.util.*;

public class minimumDominoRotationsForEqualRow {

    // ~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~
    public static int minDominoRotations(int[] tops, int[] bottoms) {
        // write your code here
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < tops.length; i++) {
            map.put(tops[i], map.getOrDefault(tops[i], 0) + 1);
            map.put(bottoms[i], map.getOrDefault(bottoms[i], 0) + 1);
        }
        int max = -1, appear = 0, count1 = 0, count2 = 0;
        for (int i : map.keySet())
            if (map.get(i) > appear) {
                appear = map.get(i);
                max = i;
            }
        for (int i = 0; i < tops.length; i++) {
            if (tops[i] != max && bottoms[i] != max)
                return -1;
            if (tops[i] == max && bottoms[i] != max)
                count1++;
            if (tops[i] != max && bottoms[i] == max)
                count2++;
        }
        return Math.min(count1, count2);
    }

    // ~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] top = new int[n];
        int[] bottom = new int[n];

        // read top
        for (int i = 0; i < top.length; i++) {
            top[i] = scn.nextInt();
        }
        // read bottom
        for (int i = 0; i < bottom.length; i++) {
            bottom[i] = scn.nextInt();
        }
        scn.close();
        int rotation = minDominoRotations(top, bottom);
        System.out.println(rotation);
    }
}