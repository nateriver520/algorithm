package com.nateriver.app.leetcode;

/**
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * <p/>
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given an encoded message containing digits, determine the total number of ways to decode it.
 * <p/>
 * For example,
 * Given encoded message "12",it could be decoded as "AB" (1 2) or "L" (12).
 * <p/>
 * The number of ways decoding "12" is 2.
 */
public class DecodeWay {
    public int numDecodings(String s) {
        return calWayNum(s, 0);
    }

    public int calWayNum(String msg, int offset) {
        if (msg.trim().equals("")) return 0;
        if (offset >= msg.length() - 1) return 1;
        int two = Integer.valueOf(msg.substring(offset, offset + 2));
        int one = Integer.valueOf(msg.substring(offset, offset + 1));

        if (two > 26)
            return calWayNum(msg, offset + 1);
        else if (one == 0)
            return 0;
        else
            return calWayNum(msg, offset + 1) + calWayNum(msg, offset + 2);
    }

    //todo need non-recursive ways, recursive way may cause time limit exceeded

    public static void main(String[] args) throws Exception {
        DecodeWay decoder = new DecodeWay();
        System.out.println(decoder.numDecodings("9371597631128776948387197132267188677349946742344217846154932859125134924241649584251978418763151253"));
    }
}
