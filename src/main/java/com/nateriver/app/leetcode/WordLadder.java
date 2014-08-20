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



    public int ladderLength(String start, String end, Set<String> dict) {
        Map<String, Integer> startVisited = new HashMap<>();
        Map<String, Integer> endVisited = new HashMap<>();
        Queue<Word> startQ = new ArrayDeque<>();
        Queue<Word> endQ = new ArrayDeque<>();

        dict.remove(start);
        startQ.add(new Word(start, 0));
        endQ.add(new Word(end,0));
        endVisited.put(end, 0);

        while (!startQ.isEmpty() && !endQ.isEmpty()){
            Word startWord = startQ.poll();
            Word endWord = endQ.poll();

            int res = handleSingleWord(startWord, startVisited,startQ,endVisited,dict);
            if(res > 0) return res;

            res =   handleSingleWord(endWord, endVisited,endQ,startVisited,dict);
            if(res > 0) return res;

        }
        return 0;
    }

    public int handleSingleWord(Word word, Map<String, Integer> orgMap,Queue<Word> orgQ, Map<String, Integer> diffMap, Set<String> dict){
        char[] chars = word.value.toCharArray();
        for(int i = 0; i < chars.length; i++){
            char orgC = chars[i];
            for (char c = 'a'; c <= 'z'; ++c) {
                chars[i] = c;
                String judge = String.valueOf(chars);
                if(diffMap.containsKey(judge)){
                    return word.level + 1  + diffMap.get(judge) + 1;
                }
                if(dict.contains(judge) && !orgMap.containsKey(judge)){
                    orgMap.put(judge, word.level + 1);
                    orgQ.add(new Word(judge, word.level +1));
                }
                chars[i] = orgC;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        WordLadder ladder = new WordLadder();
        HashSet<String> dic = new HashSet<>();

        dic.add("hot");
        dic.add("dot");
        dic.add("dog");
        dic.add("lot");
        dic.add("log");
        System.out.println(ladder.ladderLength("hit", "cog", dic)); //5

        dic.clear();
        dic.add("a");
        dic.add("b");
        dic.add("c");
        System.out.println(ladder.ladderLength("a", "c", dic)); //2



        dic.clear();
        dic.add("hot");
        dic.add("dog");
        dic.add("dot");
        System.out.println(ladder.ladderLength("hot", "dog", dic)); //3
    }

}

