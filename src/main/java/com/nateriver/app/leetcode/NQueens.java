package com.nateriver.app.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
 * <p/>
 * For example,
 * There exist two distinct solutions to the 4-queens puzzle:
 * <p/>
 * [
 * [".Q..",  // Solution 1
 * "...Q",
 * "Q...",
 * "..Q."],
 * <p/>
 * ["..Q.",  // Solution 2
 * "Q...",
 * "...Q",
 * ".Q.."]
 * ]
 */
public class NQueens {
    List<String[]> res = new ArrayList<>();

    public List<String[]> solveNQueens(int n) {
        if (n <= 0) return res;
        help(new boolean[n], new String[n], 0, n);
        return res;
    }

    public void help(boolean[] check, String[] sol, int cur, int n) {

        if (cur == n) {
            //find one solution
            res.add(sol.clone());
            return;
        }

        for (int i = 0; i < n; i++) {
            if (check[i]) continue;
            sol[cur] = generateRow(i, n);
            //mark check
            check[i] = true;
            help(check, sol, cur + 1, n);
            check[i] = false;
        }

    }

    public String generateRow(int pos, int n) {
        String res = "";
        for (int i = 0; i < n; i++) {
            if (i == pos)
                res += "Q";
            else
                res += ".";
        }
        return res;
    }

    public static void main(String[] args) throws Exception {
        NQueens nq = new NQueens();
        List<String[]> res = nq.solveNQueens(8);

        for(String[] sArray : res){
            for(String s: sArray){
                System.out.println(s);
            }
            System.out.println("===============");
        }

    }
}
