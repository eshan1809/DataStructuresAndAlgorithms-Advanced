/*
1. You are given two numbers which represent the numerator and denominator of a fraction.
2. You have to convert this fraction into a decimal.
3. If the decimals are repeating recursively, then you have to put the recurring sequence inside a bracket.
*/

import java.util.*;

public class recurringSequenceInAFraction {
    public static String solution(int num, int den) {
        // write your code here
        StringBuilder ans = new StringBuilder();
        String sign = (num < 0 ^ den < 0) ? "-" : "";
        num = Math.abs(num);
        den = Math.abs(den);
        int q = num / den, r = num % den;
        ans.append(q);
        if (r != 0) {
            ans.append(".");
            Map<Integer, Integer> map = new HashMap<>();
            while (r != 0) {
                if (map.containsKey(r)) {
                    ans.insert(map.get(r), "(");
                    ans.append(")");
                    break;
                }
                map.put(r, ans.length());
                r *= 10;
                q = r / den;
                r %= den;
                ans.append(q);
            }
        }
        return sign + ans.toString();
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int num = scn.nextInt();
        int den = scn.nextInt();
        scn.close();
        System.out.println(solution(num, den));
    }
}
