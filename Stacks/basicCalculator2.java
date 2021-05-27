/*
1. Given a string s which represents an expression, evaluate this expression and return its value. 
2. while dividing (/) numbers discard the decimal part.Example 3/2 should be 1 instead of 1.5
*/

import java.io.*;

public class basicCalculator2 {
    public static int calculate(String s) {

    }

    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int result = calculate(read.readLine());
        System.out.println(result);

    }
}
