package com.nateriver.app.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

 For example, given
 s = "leetcode",
 dict = ["leet", "code"].

 Return true because "leetcode" can be segmented as "leet code".
 */
public class WordBreak {
    public boolean wordBreak(String s, Set<String> dict) {
        if(s.trim().equals("")) return false;
        int maxDicLen = -1;
        for(String d : dict){
            if(d.length()>maxDicLen)
                maxDicLen = d.length();
        }
        return isMatch(s, 0, dict, maxDicLen);
    }

    public boolean isMatch(String s, int offset, Set<String> dict, int maxDicLen){
        if(offset == s.length()) return true;
        int end = offset + maxDicLen > s.length() ? s.length() : offset + maxDicLen;
        for(int i = end; i >= offset; i--){
            String judge = s.substring(offset,i);
            if(dict.contains(judge) && isMatch(s, i, dict, maxDicLen))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Set<String> dict = new HashSet<>();
        dict.add("leet");
        dict.add("code");

        WordBreak wb = new WordBreak();
        System.out.println(wb.wordBreak("leetcode",dict));
    }
}
