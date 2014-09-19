package com.nateriver.app.leetcode;

/**
 * Given a non-negative number represented as an array of digits, plus one to the number.
 * The digits are stored such that the most significant digit is at the head of the list.
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] res = new int[digits.length + 1];
        res[0] = 1;
        System.arraycopy(digits, 0, res, 1, digits.length);
        return res;
    }

    public static void main(String[] args) {
        PlusOne po = new PlusOne();
        int[] res = po.plusOne(new int[]{9});
        for (int re : res) {
            System.out.print(re + " ");
        }
    }
}
