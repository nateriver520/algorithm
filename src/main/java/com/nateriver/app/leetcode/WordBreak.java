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

    public boolean wordBreak1(String s, Set<String> dict){
        if(s.length() == 0) {
            return false;
        }
        boolean[] canBreak = new boolean[s.length()+1]; // canBreak[i]: whether s[0,i) can be break
        canBreak[0] = true;     // base case

        for(int i=1; i<=s.length(); i++) {  // last case: s[0,s.length()) == s
            boolean flag = false;
            for(int j=0; j<i; j++) {    // j should be smaller than i to include at least character
                // s[0,i) can be break only when s[0,j) can be break AND s[j,i) is in the dict
                if(canBreak[j] && dict.contains(s.substring(j, i))) {
                    flag = true;
                    break;
                }
            }
            canBreak[i] = flag;
        }

        return canBreak[s.length()];
    }

    public static void main(String[] args) {
        Set<String> dict = new HashSet<>();
        dict.add("leet");
        dict.add("code");

        WordBreak wb = new WordBreak();
        System.out.println(wb.wordBreak1("leetcode",dict));
    }
}
