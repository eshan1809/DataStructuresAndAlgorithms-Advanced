/*
1.Given a non-empty array of integers.
2.You have to find the k most frequent elements.
3.You have to complete the topKFrequent() function which should return the list of k most frequent elements.
*/

import java.util.*;

public class TopKFrequentElements {

    static class Pair implements Comparable<Pair> {
        int val, freq;

        Pair(int val, int freq) {
            this.val = val;
            this.freq = freq;
        }

        public int compareTo(Pair o) {
            return o.freq - this.freq;
        }
    }

    public static ArrayList<Integer> topKFrequent(int n, int[] nums, int k) {
        // Write your code here
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++)
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        for (int i : map.keySet())
            pq.add(new Pair(i, map.get(i)));
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < k; i++)
            list.add(pq.remove().val);
        return list;
    }

    // Don't make any changes here.
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] ar = new int[n];
        for (int i = 0; i < ar.length; i++) {
            ar[i] = s.nextInt();
        }
        int k = s.nextInt();
        s.close();
        ArrayList<Integer> res = topKFrequent(n, ar, k);
        Collections.sort(res);
        System.out.println(res);
    }

}