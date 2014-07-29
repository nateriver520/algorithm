package com.nateriver.app.quiz;


/**
 *  一个数组是由一个递减数列左移若干位形成的，比如{4，3，2，1，6，5}是由{6，5，4，3，2，1}左移两位形成的，在这种数组中查找某一个数。
 */

public class BinarySearch {
    static int biSearch(int a[], int num, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = left + (right - left) / 2;
        if (a[mid] == num) {
            return mid;
        }
        if (a[left] <= a[mid]) {
            if (num >= a[left] && num < a[mid])
            {
                return biSearch(a, num, left, mid - 1);
            } else
            {
                return biSearch(a, num, mid + 1, right);
            }
        }
        else {
            if (num > a[mid] && num <= a[right])
            {
                return biSearch(a, num, mid + 1, right);
            } else
            {
                return biSearch(a, num, left, mid - 1);
            }
        }
    }

    public static void main(String[] args) {
        int a[] = {5, 7, 8, 9, 1, 2, 3, 4, 5};
        for (int i = 1; i < 10; ++i) {
            System.out.println(String.format("search i: %s, position: %s", i, biSearch(a, i, 0, 8)));
        }
    }
}
