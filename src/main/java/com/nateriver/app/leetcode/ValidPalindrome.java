package com.nateriver.app.leetcode;

/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * <p/>
 * For example,
 * "A man, a plan, a canal: Panama" is a palindrome.
 * "race a car" is not a palindrome.
 * <p/>
 * Note:
 * Have you consider that the string might be empty? This is a good question to ask during an interview.
 * <p/>
 * For the purpose of this problem, we define empty string as valid palindrome.
 */
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if (s == null) return true;
        s = s.toLowerCase();
        int start = 0, end = s.length() - 1;
        while (start < end) {

            if (!isCharOrNumber(s.charAt(start)))
                start++;
            else if (!isCharOrNumber(s.charAt(end)))
                end--;
            else if (s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
            } else
                return false;
        }
        return true;
    }

    private boolean isCharOrNumber(char c){
        return c >= 'a' && c <= 'z' || c >= '0' && c <= '9';
    }

    public static void main(String[] args) {
        ValidPalindrome vp = new ValidPalindrome();
        System.out.println(vp.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(vp.isPalindrome("race a car"));
        System.out.println(vp.isPalindrome("1a2"));

    }
}
