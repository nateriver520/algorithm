package com.nateriver.app.leetcode;

/**
 Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

 If the last word does not exist, return 0.

 Note: A word is defined as a character sequence consists of non-space characters only.

 For example,
 Given s = "Hello World",
 return 5.
 */
public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        if(s.trim().equals("")) return 0;
        String[] words = s.split("\\s+");
        return words[words.length-1].length();
    }

    public static void main(String[] args) {
        LengthOfLastWord lw = new LengthOfLastWord();
        System.out.println(lw.lengthOfLastWord("Hello World"));
    }
}
