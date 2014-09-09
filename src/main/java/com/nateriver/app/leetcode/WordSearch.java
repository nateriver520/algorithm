package com.nateriver.app.leetcode;

/**
 * Word Search
 * Given a 2D board and a word, find if the word exists in the grid.
 * <p/>
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
 * <p/>
 * For example,
 * Given board =
 * <p/>
 * [
 * ["ABCE"],
 * ["SFCS"],
 * ["ADEE"]
 * ]
 * word = "ABCCED", -> returns true,
 * word = "SEE", -> returns true,
 * word = "ABCB", -> returns false.
 */


public class WordSearch {
    public boolean isExist(char[][] board, int i, int j, String word, int offset, boolean[][] used) {
        if (offset == word.length()) return true;
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || used[i][j] || board[i][j] != word.charAt(offset))
            return false;

        used[i][j] = true;
        boolean res =   isExist(board, i - 1, j, word, offset + 1, used) ||
                        isExist(board, i + 1, j, word, offset + 1, used) ||
                        isExist(board, i, j - 1, word, offset + 1, used) ||
                        isExist(board, i, j + 1, word, offset + 1, used);
        used[i][j] = false;
        return res;
    }

    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] used = new boolean[n][m];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (isExist(board, i, j, word, 0, used))
                    return true;

        return false;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'},
        };

        WordSearch ws = new WordSearch();

        System.out.println(ws.exist(board, "ABCCED"));
        System.out.println(ws.exist(board, "SEE"));
        System.out.println(ws.exist(board, "ABCB"));
    }
}
