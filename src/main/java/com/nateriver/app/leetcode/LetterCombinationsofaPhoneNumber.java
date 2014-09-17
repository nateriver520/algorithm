package com.nateriver.app.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://oj.leetcode.com/problems/letter-combinations-of-a-phone-number/
 * Given a digit string, return all possible letter combinations that the number could represent.
 * <p/>
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * <p/>
 * <p/>
 * Input:Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * Note:
 * Although the above answer is in lexicographical order, your answer could be in any order you want.
 */

public class LetterCombinationsofaPhoneNumber {
    String numap[] = {" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    List<String> result = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        char[] chars = new char[digits.length()];
        help(digits, 0, chars);
        return result;
    }

    public void help(String digits, int idx, char[] chars) {
        if (digits.length() == idx) {
            result.add(new String(chars));
            return;
        }
        int num = Integer.valueOf(digits.charAt(idx) + "");
        String responseChars = numap[num];

        for (int i = 0; i < responseChars.length(); i++) {
            chars[idx] = responseChars.charAt(i);
            help(digits, idx + 1, chars);
            chars[idx] = ' ';
        }
    }

    public static void main(String[] args) {
        LetterCombinationsofaPhoneNumber lh = new LetterCombinationsofaPhoneNumber();
        System.out.println(lh.letterCombinations("23"));
    }
}
