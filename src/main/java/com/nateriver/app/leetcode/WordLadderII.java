package com.nateriver.app.leetcode;

import java.util.*;

/**
 * Given two words (start and end), and a dictionary, find all shortest transformation sequence(s) from start to end, such that:
 * <p/>
 * Only one letter can be changed at a time
 * Each intermediate word must exist in the dictionary
 * For example,
 * <p/>
 * Given:
 * start = "hit"
 * end = "cog"
 * dict = ["hot","dot","dog","lot","log"]
 * Return
 * [
 * ["hit","hot","dot","dog","cog"],
 * ["hit","hot","lot","log","cog"]
 * ]
 * Note:
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 */
public class WordLadderII {
    private Map<String, Integer> dicHash = new HashMap<>();
    private List<List<String>> res = new LinkedList<>();
    private int minLen =- 1;

    public List<List<String>> findLadders(String start, String end, Set<String> dict) {

        buildDicHash(dict,start,end);
        char[] startChars = start.toCharArray();
        char[] endChars = end.toCharArray();
        Stack<String> s = new Stack<>();
        s.push(start);
        transform(startChars, endChars, s);
        return filter(res);
    }

    public void transform(char[] start, char[] end, Stack<String> words){
        if(minLen != -1 && words.size() > minLen) return;
        if( !dicHash.containsKey(String.valueOf(start)))
            return;

        if(String.valueOf(start).equals(String.valueOf(end))){
            if(minLen ==-1)
                minLen = words.size();
            else if(words.size() < minLen)
                minLen = words.size();

            List<String> temp = new LinkedList<>();
            for (String w : words) {
                temp.add(w);
            }
            res.add(temp);
            return;
        }

        for(int i = 0; i < start.length; i++) {
            for (char a = 'a'; a <= 'z'; a++) {
                char replaceChar = start[i];
                start[i] = a;
                String next = String.valueOf(start);
                if(!words.contains(next)){
                    words.push(next);
                    transform(start, end, words);
                    words.pop();
                }
                start[i] = replaceChar;
            }
        }
    }

    public void buildDicHash(Set<String> dic ,String start, String end) {
        dicHash.put(start,1);
        dicHash.put(end,1);
        for (String w : dic) {
            dicHash.put(w, 1);
        }
    }

    public List<List<String>> filter(List<List<String>> res){
        List<List<String>> temp = new LinkedList<>();
        for(List<String> words : res){
            if(words.size() == minLen){
                temp.add(words);
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        WordLadderII ladder = new WordLadderII();
        Set<String> dic = new HashSet<>();

        dic.add("hot");
        dic.add("dot");
        dic.add("dog");
        dic.add("lot");
        dic.add("log");
        System.out.println(ladder.findLadders("hit", "cog", dic));
    }
}
