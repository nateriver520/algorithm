package com.nateriver.app.leetcode;

import java.util.HashMap;

/**
 * https://oj.leetcode.com/problems/minimum-window-substring/
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 * <p/>
 * For example,
 * S = "ADOBECODEBANC"
 * T = "ABC"
 * Minimum window is "BANC".
 * <p/>
 * Note:
 * If there is no such window in S that covers all characters in T, return the emtpy string "".
 * <p/>
 * If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
 */
public class MinimumWindowSubstring {
    /**
     * Good answer http://blog.csdn.net/flymu0808/article/details/37844105
     */
    public String minWindow(String S, String T) {
        HashMap<Character, Integer> needFind = new HashMap<>();
        HashMap<Character, Integer> find = new HashMap<>();

        int start = 0;
        int end;
        String window = "";
        Integer minWindowLen = Integer.MAX_VALUE;

        for (char a : T.toCharArray()) {
            if (needFind.containsKey(a))
                needFind.put(a, needFind.get(a) + 1);
            else
                needFind.put(a, 1);
            find.put(a, 0);
        }

        char[] chars = S.toCharArray();
        int count = 0;
        for (end = 0; end < chars.length; end++) {
            char cur = chars[end];
            if (!needFind.containsKey(cur)) continue;
            if (find.get(cur) < needFind.get(cur)) {
                count++;
            }
            find.put(cur, find.get(cur) + 1);

            // mean we find one
            if (count == T.length()) {
                while (!needFind.containsKey(chars[start]) || find.get(chars[start]) > needFind.get(chars[start])) {
                    if (needFind.containsKey(chars[start]) && find.get(chars[start]) > needFind.get(chars[start]))
                        find.put(chars[start], find.get(chars[start]) - 1);
                    start++;
                }

                if (end - start + 1 < minWindowLen) {
                    minWindowLen = end - start + 1;
                    window = S.substring(start, end + 1);
                }

            }
        }
        return window;
    }

    public static void main(String[] args) {
        MinimumWindowSubstring ms = new MinimumWindowSubstring();
        System.out.println(ms.minWindow("bba", "ab"));
        System.out.println(ms.minWindow("ADOBECODEBANC", "ABC"));

    }
}
