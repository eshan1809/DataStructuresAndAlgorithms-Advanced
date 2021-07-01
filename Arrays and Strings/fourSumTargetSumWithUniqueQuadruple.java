/*
1. Given an array nums of 'n' integers.
2. You have to return an array of all the unique quadruple [nums[a], nums[b], nums[c], nums[d]] such that: 
    2.1 a, b, c, and d are less than 'n' and greater than 0
    2.2 a,. b, c, and d are Unique.
    2.3 nums[a] + nums[b] + nums[c] + nums[d] == target.
3. You can return answer in any order.
*/

import java.util.*;

public class fourSumTargetSumWithUniqueQuadruple {

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        // write your code here
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int p = 0; p < n - 3; p++) {
            for (int q = p + 1; q < n - 2; q++) {
                int i = q + 1, j = n - 1;
                while (i < j) {
                    if (nums[i] + nums[j] + nums[p] + nums[q] == target) {
                        List<Integer> al = new ArrayList<>();
                        al.add(nums[p]);
                        al.add(nums[q]);
                        al.add(nums[i]);
                        al.add(nums[j]);
                        set.add(al);
                        j--;
                        i++;
                    } else if (nums[i] + nums[j] + nums[p] + nums[q] > target)
                        j--;
                    else
                        i++;
                }
            }
        }
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
        List<List<Integer>> res = fourSum(arr, target);
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