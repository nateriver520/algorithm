package com.nateriver.app.quiz;

/**
 * 给定一个源串和目标串，能够对源串进行如下操作：
 1. 在给定位置上插入一个字符
 2. 替换任意字符
 3. 删除任意字符

 写一个程序，返回最小操作数，使得对源串进行这些操作后等于目标串，源串和目标串的长度都小于2000。
 *
 */
public class EditDistance {

    public static int edit(char[] pSource, char[] pTarget)
    {
        int srcLength = pSource.length;
        int targetLength = pTarget.length;
        int i, j;
        int[][] dp = new int[srcLength+1][targetLength+1];
        for (i = 1; i <= srcLength; ++i)
        {
            dp[i][0] = i;
        }
        for (j = 1; j <= targetLength; ++j)
        {
            dp[0][j] = j;
        }
        for (i = 1; i <= srcLength; ++i)
        {
            for (j = 1; j <= targetLength; ++j)
            {
                if (pSource[i - 1] == pTarget[j - 1])
                {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                else
                {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[srcLength][targetLength];
    }

    public static void main(String[] args) throws Exception {
        char[] a = new char[]{'d','o','e','b'};
        char[] b = new char[] {'d','o','n','e'};
        System.out.println(edit(a,b));
    }
}
