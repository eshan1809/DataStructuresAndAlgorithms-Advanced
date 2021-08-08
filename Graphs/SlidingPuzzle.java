/*
On an 2 x 3 board, there are five tiles labeled from 1 to 5, and an empty square represented by 0. A move consists of choosing 0 and a 4 directionally adjacent number and swapping it.
Given the puzzle board, print the least number of moves required so that the state of the board is solved. If it is impossible for the state of the board to be solved, print -1.

solved state is : {{1,2,3},{4,5,0}}
*/

import java.io.*;
import java.util.*;

class SlidingPuzzle {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] arr = new int[2][3];

        for (int i = 0; i < 2; i++) {
            String[] st = br.readLine().split(" ");
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st[j]);
            }
        }

        System.out.println(slidingPuzzle(arr));
    }

    public static int slidingPuzzle(int[][] board) {
        String target = "123450", curr = "" + board[0][0] + board[0][1] + board[0][2] + board[1][0] + board[1][1] + board[1][2];
        int[][] swapIdx = {{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}};
        int level = 0;
        Set<String> set = new HashSet<>();
        Queue<String> q = new ArrayDeque<>();
        q.add(curr);
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                String rem = q.remove();
                if(rem.equals(target))
                    return level;
                int idx = -1;
                for(int i = 0; i < 6; i++)
                    if(rem.charAt(i) == '0'){
                        idx = i;
                        break;
                    }
                for(int i : swapIdx[idx]){
                    StringBuilder sb = new StringBuilder(rem);
                    sb.setCharAt(i, rem.charAt(idx));
                    sb.setCharAt(idx, rem.charAt(i));
                    String next = sb.toString();
                    if(!set.contains(next)){
                        set.add(next);
                        q.add(next);
                    }
                }
            }
            level++;
        }
        return -1;
    }
}
