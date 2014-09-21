package com.nateriver.app.leetcode;

/**
 * Given two binary strings, return their sum (also a binary string).
 * <p/>
 * For example,
 * a = "11"
 * b = "1"
 * Return "100".
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        int plus = 0;
        String res = "";
        int size = a.length() > b.length() ? a.length()-1 : b.length()-1;
        int startA = a.length() - 1;
        int startB = b.length() - 1;

        for (; size >= 0; size--) {
            int tmpA = startA < 0 ? 0 : a.charAt(startA) - '0';
            int tmpB = startB < 0 ? 0 : b.charAt(startB) - '0';
            int tmp = tmpA + tmpB + plus;

            if (tmp / 2 >= 1)
                plus = 1;
            else
                plus = 0;

            res = tmp % 2 + res;
            startA--;
            startB--;
        }

        if(plus == 1)
            res = "1" + res;

        return res;
    }

    public static void main(String[] args) {
        AddBinary ab = new AddBinary();

        System.out.println(ab.addBinary("11", "0"));
        System.out.println(ab.addBinary("11", "1"));
        System.out.println(ab.addBinary("11", "11"));


    }
}
