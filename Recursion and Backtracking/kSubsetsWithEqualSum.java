
import java.util.*;

public class kSubsetsWithEqualSum {
    public static void solution(int[] arr, int vidx, int n, int k, int[] subsetSum, int ssssf,
            ArrayList<ArrayList<Integer>> ans) {
        if (vidx == n) {
            int c = subsetSum[0];
            if (ssssf != k) {
                return;
            }
            for (int j = 1; j < k; j++) {
                if (c != subsetSum[j]) {
                    return;
                }
            }
            for (ArrayList<Integer> al : ans) {
                System.out.print(al + " ");
            }
            System.out.println();
            return;
        }
        for (int j = 0; j < k; j++) {
            if (ans.get(j).size() > 0) {
                ans.get(j).add(arr[vidx]);
                subsetSum[j] += arr[vidx];
                solution(arr, vidx + 1, n, k, subsetSum, ssssf, ans);
                subsetSum[j] -= arr[vidx];
                ans.get(j).remove(ans.get(j).size() - 1);
            } else {
                ans.get(j).add(arr[vidx]);
                subsetSum[j] += arr[vidx];
                solution(arr, vidx + 1, n, k, subsetSum, ssssf + 1, ans);
                subsetSum[j] -= arr[vidx];
                ans.get(j).remove(ans.get(j).size() - 1);
                break;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
            sum += arr[i];
        }
        int k = scn.nextInt();
        scn.close();
        if (k == 1) {
            System.out.print("[");
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + ", ");
            }
            System.out.println("]");
            return;
        }
        if (k > n || sum % k != 0) {
            System.out.println("-1");
            return;
        }
        int[] subsetSum = new int[k];
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            ans.add(new ArrayList<>());
        }
        solution(arr, 0, n, k, subsetSum, 0, ans);
    }
}