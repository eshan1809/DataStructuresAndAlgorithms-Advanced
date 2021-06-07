/*
1. You are given an array(arr) of N integers and an integer X.
2. You have to find all unique quadruplets(a,b,c,d) which satisfies this condition - 
   a+b+c+d = X.
*/

import java.util.*;

public class quadrupletSum {
    public static ArrayList<ArrayList<Integer>> fourSum(int[] nums, int target, int n) {
        // write your code here
        Arrays.sort(nums);
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i != 0 && nums[i] == nums[i - 1])
                continue;
            for (int j = i + 1; j < n; j++) {
                if (j != i + 1 && nums[j] == nums[j - 1])
                    continue;
                int si = j + 1, ei = n - 1;
                while (si < ei) {
                    int sum = nums[i] + nums[j] + nums[si] + nums[ei];
                    if (sum > target)
                        ei--;
                    else if (sum < target)
                        si++;
                    else {
                        list.add(new ArrayList<Integer>(Arrays.asList(nums[i], nums[j], nums[si], nums[ei])));
                        si++;
                        ei--;
                        while (si < ei && nums[si] == nums[si - 1])
                            si++;
                        while (si < ei && nums[ei] == nums[ei + 1])
                            ei--;
                    }
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        ArrayList<ArrayList<Integer>> ans = fourSum(arr, target, n);
        Collections.sort(ans, (a, b) -> {
            int i = 0;
            int j = 0;

            while (i < a.size()) {
                if (a.get(i) == b.get(j)) {
                    i++;
                    j++;
                } else {
                    return a.get(i) - b.get(j);
                }
            }

            return 0;
        });
        for (ArrayList<Integer> a : ans) {
            for (int element : a) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}
