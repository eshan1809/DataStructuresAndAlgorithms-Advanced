/*
1. Given an integer array 'nums', and a 'target', return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k.
2. Another thing is nums[i] + nums[j] + nums[k] == target.
3. Notice that the solution set must not contain duplicate triplets.
*/

import java.util.*;

public class threeSumTargetSumUniqueTriplet {
    // ~~~~~~~~~~~~User Section~~~~~~~~~~~~
    public static List<List<Integer>> threeSum(int[] nums, int target) {
        // write your code here
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int k = 0; k < n - 2; k++) {
            int i = k + 1, j = n - 1;
            while (i < j) {
                if (nums[i] + nums[j] + nums[k] == target) {
                    List<Integer> al = new ArrayList<>();
                    al.add(nums[k]);
                    al.add(nums[i]);
                    al.add(nums[j]);
                    set.add(al);
                    j--;
                    i++;
                } else if (nums[i] + nums[j] + nums[k] > target) {
                    j--;
                } else {
                    i++;
                }
            }
        }
        List<List<Integer>> list = new ArrayList<>();
        for (List<Integer> al : set)
            list.add(al);
        return list;
    }

    // ~~~~~~~~~~Input Management~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int target = scn.nextInt();
        scn.close();
        List<List<Integer>> res = threeSum(arr, target);
        ArrayList<String> finalResult = new ArrayList<>();
        for (List<Integer> list : res) {
            Collections.sort(list);
            String ans = "";
            for (int val : list) {
                ans += val + " ";
            }
            finalResult.add(ans);
        }
        Collections.sort(finalResult);
        for (String str : finalResult) {
            System.out.println(str);
        }
    }
}
