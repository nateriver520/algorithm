package com.nateriver.app.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
     Word Search
     Given a 2D board and a word, find if the word exists in the grid.

     The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

     For example,
     Given board =

     [
        ["ABCE"],
        ["SFCS"],
        ["ADEE"]
     ]
     word = "ABCCED", -> returns true,
     word = "SEE", -> returns true,
     word = "ABCB", -> returns false.
 */


public class WordSearch {
    public static boolean exist(char[][] board, int i, int j,  String word, int offset, Map<String,Integer> stepHash ){
        if(offset == word.length()) return true;
        if(i < 0 || j <0 || i > board.length - 1 || j > board[i].length -1|| stepHash.containsKey(i + "" + j) || board[i][j] != word.toCharArray()[offset])
            return false;

        stepHash.put(i + "" + j, 1);
        if(exist(board,i -1,j,word,offset + 1, stepHash) || exist(board,i + 1,j,word,offset + 1, stepHash) ||exist(board,i,j -1,word,offset + 1, stepHash) ||exist(board, i ,j + 1 ,word,offset + 1, stepHash) )
            return true;
        stepHash.remove(i + "" + j);
        return false;
    }

    public static boolean search(char[][] board, String word){
        int n = board.length;
        int m = board[0].length;

        for(int i =0; i < n; i++){
            for(int j=0; j < m; j++){
                if(board[i][j] == word.toCharArray()[0]){
                    Map<String,Integer> ways = new HashMap<>();
                    if(exist(board, i,j, word, 0, ways))
                        return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'A','B','C','E'},
                {'S', 'F', 'C', 'S'},
                {'A','D','E','E'},
        };
        System.out.println(search(board,"ABCCED"));
        System.out.println(search(board,"SEE"));
        System.out.println(search(board,"ABCB"));
    }
}
