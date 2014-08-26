package com.nateriver.app.leetcode;

/**
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 * <p/>
 * For example,
 * Given:
 * s1 = "aabcc",
 * s2 = "dbbca",
 * <p/>
 * When s3 = "aadbbcbcac", return true.
 * When s3 = "aadbbbaccc", return false.
 */

public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        boolean[][] isInterLeaveBoard = new boolean[s1.length() + 1][s2.length() + 1];

        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 && j == 0)
                    isInterLeaveBoard[i][j] = true;
                else if (i == 0 && s2.charAt(j - 1) == s3.charAt(j - 1))
                    isInterLeaveBoard[0][j] = isInterLeaveBoard[0][j - 1];
                else if (j == 0 && s1.charAt(i - 1) == s3.charAt(i - 1))
                    isInterLeaveBoard[i][0] = isInterLeaveBoard[i - 1][0];

                if (i != 0 && j != 0) {
                    if (s1.charAt(i - 1) == s3.charAt(i + j - 1) && s2.charAt(j - 1) != s3.charAt(i + j - 1))
                        isInterLeaveBoard[i][j] = isInterLeaveBoard[i - 1][j];
                    else if (s1.charAt(i - 1) != s3.charAt(i + j - 1) && s2.charAt(j - 1) == s3.charAt(i + j - 1))
                        isInterLeaveBoard[i][j] = isInterLeaveBoard[i][j - 1];
                    else if (s1.charAt(i - 1) == s3.charAt(i + j - 1) && s2.charAt(j - 1) == s3.charAt(i + j - 1))
                        isInterLeaveBoard[i][j] = isInterLeaveBoard[i - 1][j] || isInterLeaveBoard[i][j - 1];
                }
            }
        }

        return isInterLeaveBoard[s1.length()][s2.length()];
    }

    public static void main(String[] args) throws Exception {
        InterleavingString is = new InterleavingString();
        System.out.println(is.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
        System.out.println(is.isInterleave("aabcc", "dbbca", "aadbbbaccc"));

    }


}
