package com.nateriver.app.leetcode;

import java.util.Arrays;

/**
 * https://oj.leetcode.com/problems/scramble-string/
 Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.

 Below is one possible representation of s1 = "great":

 great
 /    \
 gr    eat
 / \    /  \
 g   r  e   at
 / \
 a   t
 To scramble the string, we may choose any non-leaf node and swap its two children.

 For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".

 rgeat
 /    \
 rg    eat
 / \    /  \
 r   g  e   at
 / \
 a   t
 We say that "rgeat" is a scrambled string of "great".

 Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".

 rgtae
 /    \
 rg    tae
 / \    /  \
 r   g  ta  e
 / \
 t   a
 We say that "rgtae" is a scrambled string of "great".

 Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.
 */

/**
 * Great answer http://blog.csdn.net/flyupliu/article/details/26818803
 */
public class ScrambleString {
    //TODO: need no recursive solution
    public boolean isScramble(String s1, String s2) {
        if(s1.length() != s2.length()) return false;
        if(s1.equals(s2)) return true;
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();

        Arrays.sort(chars1);
        Arrays.sort(chars2);

        if(!new String(chars1).equals(new String(chars2)))
            return false;

        for(int i = 1; i < s1.length(); i++){

            if(isScramble(s1.substring(0,i),s2.substring(0,i)) && isScramble(s1.substring(i), s2.substring(i)))
                return true;

            if(isScramble(s1.substring(0,i),s2.substring(s2.length()-i)) && isScramble(s1.substring(i),s2.substring(0,s2.length() - i)))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ScrambleString ss = new ScrambleString();
        System.out.println(ss.isScramble("great","rgeat"));
        System.out.println(ss.isScramble("great","rgtae"));
        System.out.println(ss.isScramble("great","eartg"));
        System.out.println(ss.isScramble("abcd","adcb"));

    }
}
