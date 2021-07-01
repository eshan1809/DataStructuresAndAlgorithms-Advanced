/*
1. Given an array nums of 'n' integers and a variable 'K'.
2. You have to return an array of all the unique set [nums[a], nums[b], nums[c], nums[d] . . . K Elements] such that: 
    2.1 a, b, c, d . . . K Elements are less than 'n' and greater than 0.
    2.2 a,. b, c, d upto K different indexes are Unique.
    2.3 nums[a] + nums[b] + nums[c] + nums[d] + . . . + nums[K distinct indexes] == target.
3. You can return answer in any order.
*/

import java.util.*;

public class KSumTargetSumUniqueSet {
    public static void helper(int[] arr, int ssf, int target, int idx, int k, Set<List<Integer>> set,
            List<Integer> al) {
        if (k == 0) {
            if (target == ssf) {
                List<Integer> ans = new ArrayList<>(al);
                Collections.sort(ans);
                set.add(ans);
            }
            return;
        }
        if (idx == arr.length)
            return;
        helper(arr, ssf, target, idx + 1, k, set, al);
        al.add(arr[idx]);
        helper(arr, ssf + arr[idx], target, idx + 1, k - 1, set, al);
        al.remove(al.size() - 1);
    }

    public static List<List<Integer>> kSum(int[] arr, int target, int k) {
        // write your code here
        Set<List<Integer>> set = new HashSet<>();
        helper(arr, 0, target, 0, k, set, new ArrayList<>());
        List<List<Integer>> list = new ArrayList<>();
        for (List<Integer> al : set)
            list.add(al);
        return list;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int target = scn.nextInt();
        int k = scn.nextInt();
        List<List<Integer>> res = kSum(arr, target, k);
        ArrayList<String> finalResult = new ArrayList<>();
        for (List<Integer> list : res) {
            Collections.sort(list);
            String ans = "";
            for (int val : list) {
                ans += val + " ";
            }
            finalResult.add(ans);
        }
        scn.close();
        Collections.sort(finalResult);
        for (String str : finalResult) {
            System.out.println(str);
        }
    }

}