package com.nateriver.app.leetcode;

/**
 * https://oj.leetcode.com/problems/longest-common-prefix/
 Write a function to find the longest common prefix string amongst an array of strings.
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length ==0) return "";
        if(strs.length == 1) return strs[0];
        String prefix = strs[0];
        for(int i = 1; i < strs.length; i++){
            prefix = getPrefix(prefix,strs[i]);
        }
        return prefix;
    }

    public String getPrefix(String str1, String str2){
        String res = "";
        int i = 0;
        while (i < str1.length() && i < str2.length()){
            if(str1.charAt(i) != str2.charAt(i))
                return res;
            res += str1.charAt(i++);
        }

        return res;
    }

    public static void main(String[] args) throws Exception {
        LongestCommonPrefix lp = new LongestCommonPrefix();
        System.out.println(lp.longestCommonPrefix(new String[]{"abc","ab","abcn"}));
    }

}
