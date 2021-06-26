/*
1. Generate all primes between 'a'  and 'b'(both are included).
2. Print every number in new line.
3. Allowed time Complexity : O(nlog(log n)), where n = b - a.
4. Allowed Space Complexity : O(n), where n = b -a;
Note : Please focus on constraints.
*/

import java.util.*;

public class segmentedSieve {

    // ~~~~~~~~~~~~~User Section~~~~~~~~~~~~

    public static void segmentedSieveAlgo(int a, int b) {
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

    // ~~~~~~~~~~~~Input Management~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int a = scn.nextInt();
        int b = scn.nextInt();
        segmentedSieveAlgo(a, b);
    }
}
