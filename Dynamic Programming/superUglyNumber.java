/*
1. You are given an array(arr) of size k which contains prime numbers in ascending order, and an integer N.
2. You have to find Nth super ugly number.
3. Super ugly number is defined as the number whose prime factors are elements of the given array.

Assumption -> 1 is the first super ugly number.
*/

import java.util.*;

public class superUglyNumber {

    static class Pair implements Comparable<Pair> {
        int prime, ptr, val;

        Pair(int p, int pt, int val) {
            prime = p;
            ptr = pt;
            this.val = val;
        }

        public int compareTo(Pair o) {
            return this.val - o.val;
        }
    }

    public static int solution(int[] primes, int n) {
        // write your code here
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for (int i : primes)
            pq.add(new Pair(i, 0, i));
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            while (dp[i - 1] == pq.peek().val) {
                Pair p = pq.remove();
                pq.add(new Pair(p.prime, p.ptr + 1, p.prime * dp[p.ptr]));
            }
            Pair p = pq.remove();
            dp[i] = p.val;
            pq.add(new Pair(p.prime, p.ptr + 1, p.prime * dp[p.ptr]));
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int k = scn.nextInt();
        int[] primes = new int[k];
        for (int i = 0; i < k; i++) {
            primes[i] = scn.nextInt();
        }
        int n = scn.nextInt();
        scn.close();
        System.out.println(solution(primes, n));
    }
}
