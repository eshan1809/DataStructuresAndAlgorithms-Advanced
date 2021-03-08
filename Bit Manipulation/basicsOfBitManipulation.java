import java.io.*;
import java.util.*;

public class basicsOfBitManipulation {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int i = scn.nextInt();
        int j = scn.nextInt();
        int k = scn.nextInt();
        int m = scn.nextInt();

        // write your code here
        int onmask = (1 << i);
        int offmask = ~(1 << j);
        int togglemask = (1 << k);
        int checkmask = (1 << m);

        System.out.println(n | onmask);
        System.out.println(n & offmask);
        System.out.println(n ^ togglemask);
        System.out.println((n & checkmask) == 0 ? false : true);
        scn.close();
    }
}