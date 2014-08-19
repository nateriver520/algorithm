package com.nateriver.app.leetcode;

import java.util.*;

/**
 Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.

 Return all such possible sentences.

 For example, given
 s = "catsanddog",
 dict = ["cat", "cats", "and", "sand", "dog"].

 A solution is ["cats and dog", "cat sand dog"].
 */
public class WordBreakII {
    List<String> matchWords = new LinkedList<>();
    public List<String> wordBreak(String s, Set<String> dict) {
        if(s.trim().equals("")) return matchWords;
        int maxDicLen = -1;
        for(String d : dict){
            if(d.length()>maxDicLen)
                maxDicLen = d.length();
        }
        match(s,0,dict,maxDicLen,new Stack<String>());
        return matchWords;
    }


    public void match(String s, int offset, Set<String> dict, int maxDicLen, Stack<String> stack){
        if(offset == s.length()){
            String res = "";
            // find match
            for(String sub : stack){
                res += sub + " ";
            }
            matchWords.add(res.trim());
        }
        int end = offset + maxDicLen > s.length() ? s.length() : offset + maxDicLen;
        for(int i = end; i >= offset; i--){
            String judge = s.substring(offset,i);
            if(dict.contains(judge)){
                stack.push(judge);
                match(s, i, dict, maxDicLen, stack);
                stack.pop();
            }
        }
    }

    public static void main(String[] args) {
        Set<String> dict = new HashSet<>();
        dict.add("cat");
        dict.add("cats");
        dict.add("and");
        dict.add("sand");
        dict.add("dog");


        WordBreakII wb = new WordBreakII();
        System.out.println(wb.wordBreak("catsanddog", dict));
    }
}
