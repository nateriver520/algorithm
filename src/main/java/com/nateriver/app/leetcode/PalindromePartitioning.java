package com.nateriver.app.leetcode;

import java.util.*;

/**
 * https://oj.leetcode.com/problems/palindrome-partitioning/
 Given a string s, partition s such that every substring of the partition is a palindrome.

 Return all possible palindrome partitioning of s.

 For example, given s = "aab",
 Return

 [
 ["aa","b"],
 ["a","a","b"]
 ]
 */
public class PalindromePartitioning {
    Map<Integer,List<List<String>>> result = new HashMap<>();
    public List<List<String>> partition(String s) {
        char[] chars = s.toCharArray();
        // init 0
        List<List<String>> result0 = new ArrayList<>();
        List<String> re0 = new ArrayList<>();
        re0.add(String.valueOf(chars[0]));
        result0.add(re0);
        result.put(0, result0);

        for(int i = 1; i < chars.length; i++){
            char cur = chars[i];
            // judge palindrome contains cur
            List<List<String>> tmp = new ArrayList<>();
            for(int j = 0; j <= i; j++){
                if(chars[j] != cur) continue;
                if(isPalindrome(chars,j,i)){
                    if(result.containsKey(j-1)){
                        for(List<String> l : result.get(j-1)){
                            List<String> t = new ArrayList<>();
                            t.addAll(l);
                            t.add(s.substring(j,i+1));
                            tmp.add(t);
                        }
                    }
                    else {
                        List<String> t = new ArrayList<>();
                        t.add(s.substring(j,i+1));
                        tmp.add(t);
                    }
                }
            }
            result.put(i,tmp);
        }

        return result.get(s.length() -1);
    }

    public boolean isPalindrome(char[] A, int start, int end){
        while (start < end){
            if(A[start] != A[end]) return false;
            start++;
            end--;
        }

        return true;
    }

    public static void main(String[] args) throws Exception {
        PalindromePartitioning pp = new PalindromePartitioning();
        System.out.println(pp.partition("aabcb"));
    }
}
