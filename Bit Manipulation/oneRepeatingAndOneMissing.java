/*
1. You are given an array of length n containing numbers from 1 to n.
2. One number is present twice in array and one is missing.
3. You have to find these two numbers.
*/

import java.util.*;

public class oneRepeatingAndOneMissing {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        scn.close();
        solution(arr);
    }

    public static void solution(int[] arr) {
        // write your code here
        int xor = 0, xor1 = 0, xor2 = 0, n = arr.length;
        for (int i = 0; i < n; i++)
            xor ^= arr[i];
        for (int i = 1; i <= n; i++)
            xor ^= i;
        int rmsbm = (xor & -xor);
        for (int i : arr) {
            if ((i & rmsbm) == 0)
                xor1 ^= i;
            else
                xor2 ^= i;
        }
        for (int i = 1; i <= n; i++) {
            if ((i & rmsbm) == 0)
                xor1 ^= i;
            else
                xor2 ^= i;
        }
        for (int i : arr) {
            if (i == xor1) {
                System.out.println("Missing Number -> " + xor2);
                System.out.println("Repeating Number -> " + xor1);
                break;
            }
            if (i == xor2) {
                System.out.println("Missing Number -> " + xor1);
                System.out.println("Repeating Number -> " + xor2);
                break;
            }
        }
    }
}