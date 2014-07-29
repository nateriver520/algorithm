package com.nateriver.app.quiz;


public class LCS {

    public static void getLCString(char[] str1, char[] str2) {
        int i, j;
        int len1, len2;
        len1 = str1.length;
        len2 = str2.length;
        int maxLen = len1 > len2 ? len1 : len2;
        int[] max = new int[maxLen];
        int[] maxIndex = new int[maxLen];
        int[] c = new int[maxLen];

        for (i = 0; i < len2; i++) {
            for (j = len1 - 1; j >= 0; j--) {
                if (str2[i] == str1[j]) {
                    if ((i == 0) || (j == 0))
                        c[j] = 1;
                    else
                        c[j] = c[j - 1] + 1;
                } else {
                    c[j] = 0;
                }

                if (c[j] > max[0]) {
                    max[0] = c[j];
                    maxIndex[0] = j;
                    for (int k = 1; k < maxLen; k++) {
                        max[k] = 0;
                        maxIndex[k] = 0;
                    }
                } else if (c[j] == max[0]) {
                    for (int k = 1; k < maxLen; k++) {
                        if (max[k] == 0) {
                            max[k] = c[j];
                            maxIndex[k] = j;
                            break; // 在后面加一个就要退出循环了
                        }

                    }
                }
            }
        }

        for (j = 0; j < maxLen; j++) {
            if (max[j] > 0) {
                System.out.println("第" + (j + 1) + "个公共子串:");
                for (i = maxIndex[j] - max[j] + 1; i <= maxIndex[j]; i++)
                    System.out.print(str1[i]);
                System.out.println(" ");
            }
        }
    }

    public static void getMaxSubSeq(char[] str1, char[] str2){
        int length1 = str1.length;
        int length2 = str2.length;

        int[][] opt = new int[length1 + 1][length2 + 1];

        for (int i = length1 - 1; i >= 0; i--) {
            for (int j = length2 - 1; j >= 0; j--) {
                if (str1[i] == str2[j])
                    opt[i][j] = opt[i + 1][j + 1] + 1;
                else
                    opt[i][j] = Math.max(opt[i + 1][j], opt[i][j + 1]);
            }
        }

        int i = 0, j = 0;
        while (i < length1 && j < length2) {
            if (str1[i] == str2[j]) {
                System.out.print(str1[i]);
                i++;
                j++;
            } else if (opt[i + 1][j] >= opt[i][j + 1])
                i++;
            else
                j++;
        }
    }

    public static void main(String[] args) {

        String str1 = "123456abcd567";
        String str2 = "234dddabc45678";
        getMaxSubSeq(str1.toCharArray(),str2.toCharArray());
    }
}
