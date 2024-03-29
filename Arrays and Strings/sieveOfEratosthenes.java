/*
1. Given an Integer 'n'.
2. Print all primes from 2 to 'n'.
3. Portal is not forced you, but try to submit the problem in less than n.root(n) complexity.
*/

import java.util.*;

public class sieveOfEratosthenes {
    // ~~~~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~
    public static void printPrimeUsingSieve(int n) {
        // write your code here
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        for (int i = 2; i * i <= n + 1; i++) {
            if (isPrime[i])
                for (int j = 2; j * i <= n; j++)
                    isPrime[i * j] = false;
        }
        for (int i = 2; i <= n; i++)
            if (isPrime[i])
                System.out.print(i + " ");
    }

    // ~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        scn.close();
        printPrimeUsingSieve(n);
    }
}
