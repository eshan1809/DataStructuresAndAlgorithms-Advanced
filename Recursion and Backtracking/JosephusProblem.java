/*
1. You are given two numbers N and K.
2. N represents the total number of soldiers standing in a circle having position marked from 0 
     to N-1.
3. A cruel king wants to execute them but in a different way.
4. He starts executing soldiers from 0th position and proceeds around the circle in clockwise 
     direction.
5. In each step, k-1 soldiers are skipped and the k-th soldier is executed.
6. The elimination proceeds around the circle (which is becoming smaller and smaller as the 
     executed soldiers are removed), until only the last soldier remains, who is given freedom.
7. You have to find the position of that lucky soldier.
*/

import java.util.*;

public class JosephusProblem {
    public static int solution(int n, int k) {
        // write your code here
        if (n == 0) {
            return 0;
        }
        int x = (solution(n - 1, k) + k) % n;
        return x;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        System.out.println(solution(n, k));
        scn.close();
    }
}