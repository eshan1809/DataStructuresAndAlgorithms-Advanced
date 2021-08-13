/*
1. A complex number can be represented as a string on the form "Real + Imaginary i" where:
    1.1 Real is the real part and is an integer in the range [-100, 100].
    1.2 Imaginary is the imaginary part and is an integer in the range [-100, 100].
    1.3 i^2 == -1.
2. Given two complex numbers num1 and num2 as strings, return a string of the complex number that represents their multiplications.
*/

import java.util.*;

public class complexNumberMultiplication {

    // ~~~~~~~~~~~~~User's Section~~~~~~~~~~~~~
    public static String complexNumberMultiply(String num1, String num2) {
        // write your code here
        String[] str1 = num1.split("\\+|i"), str2 = num2.split("\\+|i");
        int real1 = Integer.parseInt(str1[0]), real2 = Integer.parseInt(str2[0]);
        int img1 = Integer.parseInt(str1[1]);
        int img2 = Integer.parseInt(str2[1]);
        int realAns = real1 * real2 - img1 * img2;
        int imgAns = real1 * img2 + real2 * img1;
        return realAns + "+" + imgAns + "i";
    }

    // ~~~~~~~~~~~~Input Management~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String num1 = scn.nextLine();
        String num2 = scn.nextLine();
        scn.close();
        String res = complexNumberMultiply(num1, num2);
        System.out.println(res);
    }
}