package com.nateriver.app.leetcode;

/**
 * https://oj.leetcode.com/problems/palindrome-partitioning-ii/
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * <p/>
 * Return the minimum cuts needed for a palindrome partitioning of s.
 * <p/>
 * For example, given s = "aab",
 * Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
 */
public class PalindromePartitioningII {
    /**
     * Great answer
     * http://blog.csdn.net/yutianzuijin/article/details/16850031
     */
    public int minCut(String s) {
        int[][] dp = new int[s.length()][s.length()];
        int[] count = new int[s.length() + 1];

        for (int i = s.length() - 1; i >= 0; i--) {
            count[i] = Integer.MAX_VALUE;
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1] == 1)){
                    dp[i][j] = 1;
                    count[i] = Math.min(count[i], count[j+1] + 1);
                }
            }
        }

        return count[0] - 1;
    }

    public static void main(String[] args) throws Exception {
        PalindromePartitioningII pp = new PalindromePartitioningII();
        System.out.println(pp.minCut("aab"));
    }
}
