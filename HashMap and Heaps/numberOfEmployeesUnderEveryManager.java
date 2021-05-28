/*
1. You are given number N and 2*N number of strings that contains mapping of the employee and his manager.
2. An employee directly reports to only one manager. 
3. All managers are employees but the reverse is not true.
4. An employee reporting to himself is the CEO of the company.
5. You have to find the number of employees under each manager in the hierarchy not just their direct reports.
*/

import java.util.*;

public class numberOfEmployeesUnderEveryManager {
    public static void solve(Map<String, String> map) {
        Map<String, Set<String>> tree = new HashMap<>();
        String ceo = "";
        for (String emp : map.keySet()) {
            String man = map.get(emp);
            if (man.equals(emp))
                ceo = man;
            else {
                if (tree.containsKey(man))
                    tree.get(man).add(emp);
                else {
                    Set<String> set = new HashSet<>();
                    set.add(emp);
                    tree.put(man, set);
                }
            }
        }
        Map<String, Integer> ans = new HashMap<>();
        getAns(tree, ceo, ans);
        for (String emp : ans.keySet())
            System.out.println(emp + " " + ans.get(emp));

    }

    public static int getAns(Map<String, Set<String>> tree, String man, Map<String, Integer> ans) {
        if (!tree.containsKey(man)) {
            ans.put(man, 0);
            return 1;
        }
        int res = 0;
        for (String emp : tree.get(man))
            res += getAns(tree, emp, ans);
        ans.put(man, res);
        return res + 1;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = Integer.parseInt(scn.next());

        // write your code here
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < n; i++)
            map.put(scn.next(), scn.next());
        solve(map);
        scn.close();
    }
}