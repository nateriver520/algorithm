package com.nateriver.app.leetcode;

/**
 * Edit Distance
 * Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)
 * <p/>
 * You have the following 3 operations permitted on a word:
 * <p/>
 * a) Insert a character
 * b) Delete a character
 * c) Replace a character
 */
public class EditDistance {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        dp[0][0] = 0;
        for (int i = 1; i <= word1.length(); i++)
            dp[i][0] = dp[i - 1][0] + 1;
        for (int i = 1; i <= word2.length(); i++)
            dp[0][i] = dp[0][i - 1] + 1;

        for (int i = 1; i <= word1.length(); i++)
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]),dp[i-1][j-1]) + 1;
            }

        return dp[word1.length()][word2.length()];
    }

    public static void main(String[] args) throws Exception {
        EditDistance ed = new EditDistance();
        System.out.println(ed.minDistance("doeb", "done"));
        System.out.println(ed.minDistance(" ", ""));
        System.out.println(ed.minDistance("a", "b"));

    }
}
