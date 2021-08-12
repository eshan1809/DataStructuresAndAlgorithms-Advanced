/*
1. You are given an array of positive integers in ascending order, which represents the position of stones in the river.
2. A frog is trying to cross a river. It can jump on a stone, but it must not jump into the water.
3. You have to find if the frog can cross the river by landing on the last stone.
4. The frog is on the first stone initially, and from first stone it can jump 1 unit only.
5. The frog can only jump k-1, k, or k+1 units in the forward direction, where k is the frog's last jump.
*/

import java.util.*;

public class frogJump {
    public static boolean solution(int[] stones) {
        // write your code here
        Map<Integer, HashSet<Integer>> map = new HashMap<>();
        for (int i : stones)
            map.put(i, new HashSet<>());
        map.get(stones[0]).add(1);
        for (int i : stones) {
            Set<Integer> set = map.get(i);
            for (int j : set) {
                if (map.containsKey(i + j)) {
                    if (j - 1 > 0)
                        map.get(i + j).add(j - 1);
                    map.get(i + j).add(j);
                    map.get(i + j).add(j + 1);
                }
            }
        }
        return map.get(stones[stones.length - 1]).size() > 0;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        scn.close();
        System.out.println(solution(arr));
    }
}
