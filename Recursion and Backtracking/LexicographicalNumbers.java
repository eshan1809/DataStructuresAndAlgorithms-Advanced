/*
1. You are given a number.
2. You have to print all the numbers from 1 to n in lexicographical order.
*/

import java.io.*;
import java.util.*;

public class LexicographicalNumbers {

    public static void printLexi(int n, int i) {
        if (i > n) {
            return;
        }
        System.out.println(i);
        for (int j = 0; j < 10; j++) {
            printLexi(n, i * 10 + j);
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        for (int i = 1; i < 10; i++) {
            printLexi(n, i);
        }
        scn.close();
    }
}