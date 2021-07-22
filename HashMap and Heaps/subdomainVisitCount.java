/*
1. A website domain like "www.pepcoding.com" consists of various subdomains like 
   "com" at the topmost level, "pepcoding.com" at the next level, and "www.pepcoding.com" at the lowest level.
2. When you visit a domain like "www.pepcoding.com", you will also visit its parent domains "pepcoding.com" and "com".   
3. You are given N number of strings where every string contains a number and a domain separated by a space, where the number represents the visit count of the domain.
4. You have to find the number of visits for each sub-domain.
*/

import java.util.*;

public class subdomainVisitCount {

    private static String getSubDomain(String website) {
        int i = 0;
        while (i < website.length())
            if (website.charAt(i++) == '.')
                return website.substring(i);
        return "";
    }

    public static List<String> subdomainVisits(String[] cpdomains) {
        // write your code here
        Map<String, Integer> map = new HashMap<>();
        for (String domain : cpdomains) {
            int num = Integer.parseInt(domain.split(" ")[0]);
            String website = domain.split(" ")[1];
            while (website.length() > 0) {
                map.put(website, map.getOrDefault(website, 0) + num);
                website = getSubDomain(website);
            }
        }
        List<String> list = new ArrayList<>();
        for (String s : map.keySet())
            list.add(map.get(s) + " " + s);
        return list;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());
        String[] cpd = new String[n];
        for (int i = 0; i < cpd.length; i++) {
            cpd[i] = s.nextLine();
        }
        List<String> ans = subdomainVisits(cpd);
        Collections.sort(ans);
        System.out.println(ans);
        s.close();
    }

}
