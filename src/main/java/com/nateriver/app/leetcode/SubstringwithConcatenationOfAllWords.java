package com.nateriver.app.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * https://oj.leetcode.com/problems/substring-with-concatenation-of-all-words/
 * You are given a string, S, and a list of words, L, that are all of the same length. Find all starting indices of substring(s) in S that is a concatenation of each word in L exactly once and without any intervening characters.
 * For example, given:
 * S: "barfoothefoobarman"
 * L: ["foo", "bar"]
 * <p/>
 * You should return the indices: [0,9].
 * (order does not matter).
 */
public class SubstringwithConcatenationOfAllWords {
    /**
     * Great answer : http://blog.csdn.net/erorr/article/details/29241719
     */
    public List<Integer> findSubstring(String S, String[] L) {
        List<Integer> result = new ArrayList<>();

        if(S == null || S.length() == 0 || L == null|| L.length == 0)
            return result;

        Integer singleWorldLen = L[0].length();
        Integer allWordsLen = L.length * singleWorldLen;
        Integer targetHashSum = 0;
        HashSet<String> dic = new HashSet<>();


        for (String w : L) {
            targetHashSum += w.hashCode();
            dic.add(w);
        }

        for (int i = 0; i < S.length() - allWordsLen + 1; i++) {
            String judge = S.substring(i, i + singleWorldLen);
            if (!dic.contains(judge)) continue;
            Integer diffHashSum = judge.hashCode();
            int j = 1;
            while (j < L.length) {
                int start = i + j * singleWorldLen;
                String sub = S.substring(start, start + singleWorldLen);
                j++;
                if (!dic.contains(sub)) break;
                diffHashSum += sub.hashCode();
            }

            if (diffHashSum.equals(targetHashSum))
                result.add(i);
        }

        return result;
    }

    public static void main(String[] args) {
        SubstringwithConcatenationOfAllWords sl = new SubstringwithConcatenationOfAllWords();

        System.out.println(sl.findSubstring("barfoothefoobarman", new String[]{"bar", "foo"}));
        System.out.println(sl.findSubstring("lingmindraboofooowingdingbarrwingmonkeypoundcake", new String[]{"fooo","barr","wing","ding","wing"}));

    }
}
