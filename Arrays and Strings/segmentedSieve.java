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
    public static ArrayList<Integer> sieve(int n) {
        // write your code here
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        for (int i = 2; i * i <= n + 1; i++) {
            if (isPrime[i])
                for (int j = 2; j * i <= n; j++)
                    isPrime[i * j] = false;
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 2; i <= n; i++)
            if (isPrime[i])
                list.add(i);
        return list;
    }

    public static void segmentedSieveAlgo(int a, int b) {
        // write your code here
        boolean[] arr = new boolean[b - a + 1];
        Arrays.fill(arr, true);
        ArrayList<Integer> primes = sieve((int) Math.sqrt(b));
        for (int prime : primes) {
            int multiple = (int) Math.ceil((double) a / prime);
            if (multiple == 1)
                multiple++;
            int idx = multiple * prime - a;
            for (int j = idx; j < arr.length; j += prime)
                arr[j] = false;
        }
        for (int i = 0; i < arr.length; i++)
            if (arr[i] && i + a != 1)
                System.out.println(a + i);
    }

    // ~~~~~~~~~~~~Input Management~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int a = scn.nextInt();
        int b = scn.nextInt();
        scn.close();
        segmentedSieveAlgo(a, b);
    }
}
