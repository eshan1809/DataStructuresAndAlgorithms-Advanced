/*
1. Given an integers X. 
2. The task is to find the minimum number of jumps to reach a point X in the number line starting from zero.
3. The first jump made can be of length one unit and each successive jump will be exactly one unit longer than the previous jump in length. 
4. It is allowed to go either left or right in each jump.
*/

import java.util.*;

public class minJumpsWith_i_Moves {
    // ~~~~~~~~~~~~User Section~~~~~~~~~~~
    public static int minJumps(int x) {
        // Write your code here
        int pos = 0, jump = 1;
        while (pos < x)
            pos += jump++;
        while ((pos - x) % 2 != 0)
            pos += jump++;
        return jump - 1;
    }

    // ~~~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int x = scn.nextInt();
        scn.close();
        int jumps = minJumps(x);
        System.out.println(jumps);
    }
}