package com.nateriver.app.leetcode;

/**
 Follow up for N-Queens problem.

 Now, instead outputting board configurations, return the total number of distinct solutions.

 */

public class NQueensII {
    int totalSize;
    public int totalNQueens(int n) {
        helper(n, 0, new int[n]);
        return totalSize;
    }

    private void helper(int n, int row, int[] columnForRow) {
        if (row == n) {
            totalSize++;
            return;
        }
        for (int i = 0; i < n; i++) {
            columnForRow[row] = i;
            if (check(row, columnForRow)) {
                helper(n, row + 1, columnForRow);
            }
        }
    }

    private boolean check(int row, int[] columnForRow) {
        for (int i = 0; i < row; i++) {
            if (columnForRow[row] == columnForRow[i] || Math.abs(columnForRow[row] - columnForRow[i]) == row - i)
                return false;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        NQueensII nq = new NQueensII();
        System.out.println(nq.totalNQueens(4));
    }
}
