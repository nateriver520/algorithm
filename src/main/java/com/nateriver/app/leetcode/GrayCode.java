package com.nateriver.app.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * The gray code is a binary numeral system where two successive values differ in only one bit.
 * <p/>
 * Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.
 * <p/>
 * For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
 * <p/>
 * 00 - 0
 * 01 - 1
 * 11 - 3
 * 10 - 2
 * <p/>
 * 0000
 * 1000
 * 1100
 * 1110
 * 1111
 * 1101
 * 1001
 * 0001
 * 0101
 * 0111
 * 0110
 * 0100
 * 0000
 * <p/>
 * <p/>
 * Note:
 * For a given n, a gray code sequence is not uniquely defined.
 * <p/>
 * For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.
 * <p/>
 * For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.
 */
public class GrayCode {
    /**
     * Great answer http://www.cnblogs.com/lihaozy/archive/2012/12/31/2840437.html
     * http://blog.csdn.net/jellyyin/article/details/12995271
     */
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        int size = (int) Math.pow(2, n);
        for (int i = 0; i < size; i++) {
            res.add((i >> 1) ^ i);
        }
        return res;
    }

    public List<Integer> grayCode2(int n) {
        List<Integer> res = new ArrayList<>();
        res.add(0);
        if(n == 0) return res;
        res.add(1);
        int plus = 1;
        for (int i = 2; i <= n; i++) {
            plus *= 2;
            for (int j = res.size() - 1; j >= 0; j--) {
                res.add(plus + res.get(j));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        GrayCode gc = new GrayCode();
        System.out.println(gc.grayCode2(4));
    }

}
