package com.nateriver.app.leetcode;

/**
 A message containing letters from A-Z is being encoded to numbers using the following mapping:

 'A' -> 1
 'B' -> 2
 ...
 'Z' -> 26
 Given an encoded message containing digits, determine the total number of ways to decode it.

 For example,
 Given encoded message "12",it could be decoded as "AB" (1 2) or "L" (12).

 The number of ways decoding "12" is 2.
 */
public class DecodeWay {
    public static int calWayNum(String msg, int offset){
        if(offset >= msg.length() -1) return 1;
        int two = Integer.valueOf(msg.substring(offset, offset + 2));
        if(two > 26)
            return calWayNum(msg, offset + 1);
        else
            return calWayNum(msg, offset + 1) + calWayNum(msg, offset + 2);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(calWayNum("1221", 0));
    }
}
