/*
1. You are given two integers N and M, and an array(arr) of numbers with length M.
2. N represents the total number of tasks assigned to a group of 5 students.
3. Out of these five students, three students completed M number of tasks of their choices and left the group.
4. Tasks completed by these students are represented by the given array.
5. Now, the remaining two students(s1 and s2) have to complete all the remaining tasks.
6. They decided to complete the remaining tasks in an alternate way -
   First of the remaining tasks will be completed by s1
   Second of the remaining tasks will be completed by s2
   Third of the remaining tasks will be completed by s1.. and so on.    
7. You have to find the tasks that s1 and s2 have to complete.
*/

import java.util.*;

public class taskCompletion {
    public static void completeTask(int n, int m, int[] arr) {
        // write your code here
        Set<Integer> set = new HashSet<>();
        for (int i : arr)
            set.add(i);
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++)
            if (!set.contains(i))
                list.add(i);
        for (int i = 0; i < list.size(); i += 2)
            System.out.print(list.get(i) + " ");
        System.out.println();
        for (int i = 1; i < list.size(); i += 2)
            System.out.print(list.get(i) + " ");
        return;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[] num = new int[m];
        for (int i = 0; i < m; i++) {
            num[i] = scn.nextInt();
        }
        scn.close();
        completeTask(n, m, num);
    }
}
