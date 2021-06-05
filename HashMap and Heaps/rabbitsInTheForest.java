/*
1. There are some rabbits in the forest and each rabbit has some color.
2. Some(possibly all) rabbits are selected from them and they tell you about the number of other rabbits having the same color as them.
3. You are given an array(arr) that contains the answers of all selected rabbits.
4. You have to find the minimum number of rabbits that could be in the forest.
*/

import java.util.*;

public class rabbitsInTheForest {
    public static int solution(int[] arr) {
        // write your code here
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (int i : arr) {
            if (map.containsKey(i)) {
                if (map.get(i) == i + 1) {
                    ans += i + 1;
                    map.put(i, 1);
                } else
                    map.put(i, map.get(i) + 1);
            } else {
                ans += i + 1;
                map.put(i, 1);
            }
        }
        return ans;
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
