package com.nateriver.app.leetcode;

import java.util.*;

/**
 Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that:

 Only one letter can be changed at a time
 Each intermediate word must exist in the dictionary
 For example,

 Given:
 start = "hit"
 end = "cog"
 dict = ["hot","dot","dog","lot","log"]
 As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 return its length 5.

 Note:
 Return 0 if there is no such transformation sequence.
 All words have the same length.
 All words contain only lowercase alphabetic characters.
 */

public class WordLadder {
    class Word{
        String value;
        Integer level;

        Word(String value, Integer level) {
            this.value = value;
            this.level = level;
        }
    }

    Map<String, Integer> visited = new HashMap<>();
    public int ladderLength(String start, String end, Set<String> dict) {
        Queue<Word> q = new ArrayDeque<>();
        q.add(new Word(start,1));
        while (!q.isEmpty()){
            Word curWord = q.poll();
            visited.put(curWord.value,1);
            char[] chars = curWord.value.toCharArray();
            for(int i = 0; i < chars.length; i++){
                char orgC = chars[i];
                for (char c = 'a'; c <= 'z'; ++c) {
                    chars[i] = c;
                    String judge = String.valueOf(chars);
                    if(judge.equals(end)){
                        return curWord.level + 1;
                    }
                    if(dict.contains(judge) && !visited.containsKey(judge)){
                        q.add(new Word(judge,curWord.level+1));
                    }
                    chars[i] = orgC;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        WordLadder ladder = new WordLadder();
        HashSet<String> dic = new HashSet<>();

        dic.add("hot");
        dic.add("dot");
        dic.add("dog");
        dic.add("lot");
        dic.add("log");
        System.out.println(ladder.ladderLength("hit", "cog", dic));
    }

}

