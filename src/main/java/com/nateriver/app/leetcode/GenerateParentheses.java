package com.nateriver.app.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://oj.leetcode.com/problems/generate-parentheses/
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * <p/>
 * For example, given n = 3, a solution set is:
 * <p/>
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 */
public class GenerateParentheses {
    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        if (n <= 0) return res;
        generate(0, 0, n, "");
        return res;
    }

    public void generate(int left, int right, int n, String tmp) {
        if (left == n && right == n) {
            res.add(tmp);
            return;
        }

        if (left < n) {
            generate(left + 1, right, n, tmp + "(");
            if (left > right)
                generate(left, right + 1, n, tmp + ")");
        } else {
            generate(left, right + 1, n, tmp + ")");
        }
    }

    public static void main(String[] args) throws Exception {
        GenerateParentheses gp = new GenerateParentheses();
        System.out.println(gp.generateParenthesis(3));
    }
}


