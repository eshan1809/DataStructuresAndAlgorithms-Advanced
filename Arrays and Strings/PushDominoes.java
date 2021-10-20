/*
1. There are n dominoes in a line, and we place each domino vertically upright.
2. In the beginning, we simultaneously push some of the dominoes either to the left or to the right.
3. After each second, each domino that is falling to the left pushes the adjacent domino on the left. 
4. Similarly, the dominoes falling to the right push their adjacent dominoes standing on the right.
5. When a vertical domino has dominoes falling on it from both sides, it stays still due to the balance of the forces.
6. For the purposes of this question, we will consider that a falling domino expends no additional force to a falling or already fallen domino.
7. You are given a string dominoes representing the initial state where:
    a). dominoes[i] = 'L', if the ith domino has been pushed to the left,
    b). dominoes[i] = 'R', if the ith domino has been pushed to the right, and
    c). dominoes[i] = '.', if the ith domino has not been pushed.
8. Return a string representing the final state.
*/

import java.util.*;

public class PushDominoes {
    // ~~~~~~~~~~~~~User's Section~~~~~~~~~~~~~~
    public static String pushDominoes(String dominoes) {
        int n = dominoes.length();
        char[] ch = dominoes.toCharArray();
        int[] forces = new int[n];
        int force = 0;
        for (int i = 0; i < n; i++) {
            if (ch[i] == 'R')
                force = n;
            else if (ch[i] == 'L')
                force = 0;
            else
                force = Math.max(force - 1, 0);
            forces[i] = force;
        }
        for (int i = n - 1; i >= 0; i--) {
            if (ch[i] == 'L')
                force = n;
            else if (ch[i] == 'R')
                force = 0;
            else
                force = Math.max(force - 1, 0);
            forces[i] -= force;
        }
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (forces[i] > 0)
                str.append('R');
            else if (forces[i] < 0)
                str.append('L');
            else
                str.append('.');
        }
        return str.toString();
    }

    // ~~~~~~~~~~~Input Management~~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        scn.close();
        String res = pushDominoes(str);
        System.out.println(res);
    }
}
