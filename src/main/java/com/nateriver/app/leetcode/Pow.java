package com.nateriver.app.leetcode;

/**
 * Implement pow(x, n).
 */
public class Pow {
    public double pow(double x, int n) {
        if (n == 0) return 1;
        if (n < 0){
            if(n == Integer.MIN_VALUE)
                return 1 / (pow(x, Integer.MAX_VALUE) * x);
            else
                return 1 / pow(x, -n);
        }
        double ans = 1.0;

        for (; n > 0; x *= x, n >>= 1) {
            if ((n & 1) > 0)
                ans *= x;
        }
        return ans;
    }
    public static void main(String[] args) {
        Pow pow = new Pow();
        System.out.println(pow.pow(1,-2147483648));
    }
}
