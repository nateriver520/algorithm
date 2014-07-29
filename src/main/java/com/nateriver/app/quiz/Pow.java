package com.nateriver.app.quiz;


/**
 * Calculate pow
 * like pow(2,3) = 8
 */
public class Pow {

    static int calPow(int x, int n) {
        if (n == 0) return 0;
        if (n == 1) return x;

        if (n % 2 == 1) return calPow(x, n / 2) * calPow(x, n / 2) * x;
        return calPow(x, n / 2) * calPow(x, n / 2);
    }


    public static double pow(double x, int n) {
        boolean NegExp = false;
        double result = 1;
        if (n == 0)
            return 1;
        if (n < 0) {
            NegExp = true;
            n *= -1;
        }
        while (n > 0) {
            if ((n & 1) == 1)
                result *= x;
            x *= x;
            n = n >> 1;
        }
        if (NegExp)
            result = 1 / result;
        return result;
    }

    public static void main(String[] args) {
        System.out.println(pow(2, 3));
    }

}
