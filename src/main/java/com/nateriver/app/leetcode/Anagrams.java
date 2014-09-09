package com.nateriver.app.leetcode;

import java.util.*;

/**
 * https://oj.leetcode.com/problems/anagrams/
 * Anagrams Total Accepted: 14723 Total Submissions: 62272 My Submissions
 * Given an array of strings, return all groups of strings that are anagrams.
 * <p/>
 * Note: All inputs will be in lower-case.
 */
public class Anagrams {
    public List<String> anagrams(String[] strs) {
        List<String> res = new ArrayList<>();
        Map<String, List<String>> resHash = new HashMap<>();

        for (String s : strs) {
            String key = calKey(s);
            List<String> tmp = resHash.get(key);
            if (tmp == null) {
                tmp = new ArrayList<>();
                resHash.put(key, tmp);
            }
            tmp.add(s);
        }

        for (List<String> l : resHash.values()) {
            if (l.size() >= 2)
                res.addAll(l);
        }

        return res;
    }

    public String calKey(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        String key = "";
        for (char c : chars) {
            key += c;
        }
        return key;
    }

    public static void main(String[] args) {
        Anagrams ar = new Anagrams();
        System.out.println(ar.anagrams(new String[]{"ate","eta"," "," ","ck"}));
    }

}
