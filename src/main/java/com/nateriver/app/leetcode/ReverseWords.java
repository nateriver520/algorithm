package com.nateriver.app.leetcode;

/**
 Given an input string, reverse the string word by word.

 For example,
 Given s = "the sky is blue",
 return "blue is sky the".

 click to show clarification.

 Clarification:
 What constitutes a word?
 A sequence of non-space characters constitutes a word.
 Could the input string contain leading or trailing spaces?
 Yes. However, your reversed string should not contain leading or trailing spaces.
 How about multiple spaces between two words?
 Reduce them to a single space in the reversed string.
 */
public class ReverseWords {
    /**
     Given s = "the sky is blue",
     to eht yks si eulb
     blue is sky the
     */
    public String reverseWords(String s) {
        if(s == null) return null;
        char[] chars = s.trim().toCharArray();

        for(int i =0; i < chars.length; i++){
            if(chars[i] == ' ') continue;
            int start = i++;
            while (i < chars.length && chars[i] != ' ' )
                i++;
            int end = i-1;
            reverseString(chars,start,end);
        }

        reverseString(chars,0, chars.length-1);

        String res = "";

        for(int i =0; i< chars.length; i++){
            if(chars[i] == ' '){
                res += chars[i];
                while (chars[++i] == ' ');
                i--;
            }
            else {
                res += chars[i];
            }
        }
        return res;
    }

    public String reverseWords1(String s) {
        if(s == null) return null;
        String[] words = s.trim().split("\\s+");
        String res = "";
        for(int i = words.length -1 ; i >=0; i--){
            res += words[i] + " ";
        }
        return res.trim();
    }


    public void reverseString(char[] chars, int start, int end){
        while (start < end){
            char temp = chars[start];
            chars[start++] = chars[end];
            chars[end--] = temp;
        }
    }

    public static void main(String[] args) {
        ReverseWords revert = new ReverseWords();
        System.out.println(revert.reverseWords("the sky is blue"));
        System.out.println(revert.reverseWords("  the sky is blue  "));
        System.out.println(revert.reverseWords("  the sky   is blue  "));
        System.out.println(revert.reverseWords("   p"));


        System.out.println(revert.reverseWords1("the sky is blue"));
        System.out.println(revert.reverseWords1("  the sky is blue  "));
        System.out.println(revert.reverseWords1("  the sky   is blue  "));
        System.out.println(revert.reverseWords1("   p"));
        System.out.println(revert.reverseWords1("  "));



    }
}
