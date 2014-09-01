package com.nateriver.app.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://oj.leetcode.com/problems/pascals-triangle-ii/
 * Given an index k, return the kth row of the Pascal's triangle.
 * <p/>
 * For example, given k = 3,
 * Return [1,3,3,1].
 * <p/>
 * Note:
 * Could you optimize your algorithm to use only O(k) extra space?
 */
public class PascalTriangleII {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();

        if (rowIndex < 0)
            return res;
        res.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            for (int j = res.size() - 2; j >= 0; j--)
                res.set(j + 1, res.get(j) + res.get(j + 1));
            res.add(1);
        }

        return res;
    }
}
