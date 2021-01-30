import java.util.*;

public class goldMine {
    static int max = 0;

    public static void getMaxGold(int[][] arr) {
        boolean[][] visited = new boolean[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                ArrayList<Integer> bag = new ArrayList<>();
                tsg(arr, i, j, visited, bag);
                int sum = 0;
                for (int gold : bag) {
                    sum += gold;
                }
                if (sum > max) {
                    max = sum;
                }
            }
        }
    }

    public static void tsg(int[][] arr, int i, int j, boolean[][] visited, ArrayList<Integer> bag) {
        if (i < 0 || i >= arr.length || j < 0 || j >= arr[0].length || visited[i][j] == true || arr[i][j] == 0) {
            return;
        }
        bag.add(arr[i][j]);
        visited[i][j] = true;
        tsg(arr, i + 1, j, visited, bag);
        tsg(arr, i - 1, j, visited, bag);
        tsg(arr, i, j + 1, visited, bag);
        tsg(arr, i, j - 1, visited, bag);
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] arr = new int[m][n];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = scn.nextInt();
            }
        }
        getMaxGold(arr);
        System.out.println(max);
        scn.close();
    }

}