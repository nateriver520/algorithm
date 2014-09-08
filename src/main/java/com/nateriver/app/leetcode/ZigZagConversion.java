package com.nateriver.app.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://oj.leetcode.com/problems/zigzag-conversion/
 * ZigZag Conversion
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 * <p/>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion given a number of rows:
 * <p/>
 * string convert(string text, int nRows);
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 */
public class ZigZagConversion {
    public String convert(String s, int nRows) {
        List<List<Character>> charList = new ArrayList<>();
        for (int i = 0; i < nRows; i++)
            charList.add(new ArrayList<Character>());

        String res = "";
        if(s.trim().isEmpty() || nRows <= 1) return s;

        char[] chars = s.toCharArray();
        boolean isAscending = false;
        int pre = 0;
        charList.get(0).add(chars[0]);
        for (int i = 1; i < chars.length; i++) {
            if (pre + 1 == nRows || pre == 0) isAscending = !isAscending;
            int cur = isAscending ? ++pre : --pre;
            charList.get(cur).add(chars[i]);
        }

        for (List<Character> l : charList)
            for (Character c : l)
                res += c;
        return res;
    }

    public static void main(String[] args) {
        ZigZagConversion zz = new ZigZagConversion();
        System.out.println(zz.convert("PAYPALISHIRING", 3));
        System.out.println(zz.convert("", 1));
        System.out.println(zz.convert("AB", 1));
    }
}
