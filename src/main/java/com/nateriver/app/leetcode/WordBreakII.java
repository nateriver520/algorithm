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
    public List<String> wordBreak(String s, Set<String> dict) {
        if(s.trim().equals("")) return new ArrayList<>();
        if(!hasMatch(s,dict)) return new ArrayList<>();
        HashMap<Integer,List<String>> canHash = new HashMap<>();

        canHash.put(0, new ArrayList<String>());
        for(int i = 1; i <= s.length(); i++){
            for(int j = 0; j < i; j++){
                String judge = s.substring(j,i);
                if(canHash.containsKey(j) && dict.contains(judge)){
                    if(!canHash.containsKey(i))
                        canHash.put(i, new ArrayList<String>());
                    if(j == 0) canHash.get(i).add(judge);
                    for (String match : canHash.get(j)){
                        canHash.get(i).add(match + " " + judge);
                    }
                }
            }
        }

        return canHash.containsKey(s.length())? canHash.get(s.length()): new ArrayList<String>();
    }


    public boolean hasMatch(String s, Set<String> dict){
        if(s.length() == 0) {
            return false;
        }
        boolean[] canBreak = new boolean[s.length()+1];
        canBreak[0] = true;
        for(int i=1; i<=s.length(); i++) {
            boolean flag = false;
            for(int j=0; j<i; j++) {
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
        dict.add("cat");
        dict.add("cats");
        dict.add("and");
        dict.add("sand");
        dict.add("dog");


        WordBreakII wb = new WordBreakII();
        System.out.println(wb.wordBreak("catsanddog", dict));
    }
}
