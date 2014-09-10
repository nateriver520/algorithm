package com.nateriver.app.leetcode;

/**
 * Reverse Integer
 * Reverse digits of an integer.
 * <p/>
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 * <p/>
 * click to show spoilers.
 * <p/>
 * Have you thought about this?
 * Here are some good questions to ask before coding. Bonus points for you if you have already thought through this!
 * <p/>
 * If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100.
 * <p/>
 * Did you notice that the reversed integer might overflow? Assume the input is a 32-bit integer, then the reverse of 1000000003 overflows. How should you handle such cases?
 * <p/>
 * Throw an exception? Good, but what if throwing an exception is not an option? You would then have to re-design the function (ie, add an extra parameter).
 */
public class ReverseInteger {
    public int reverse(int x) {
        int sign = 1;
        int _x = x;
        if (x < 0) sign = -1;
        int ret = 0;
        while (x != 0) {
            ret = ret * 10 + Math.abs(x % 10) * sign;
            x /= 10;
        }

        if (_x > 0 && ret < 0 || _x < 0 && ret > 0) return -1;
        return ret;
    }

    public static void main(String[] args) {
        ReverseInteger ri = new ReverseInteger();
        System.out.println(ri.reverse(123));
    }
}
