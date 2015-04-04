package com.nateriver.app.quiz;

/**
 * Given a sequence of integers, find the longest increasing subsequence (LIS).
 * <p/>
 * You code should return the length of the LIS.
 * <p/>
 * Example
 * For [5, 4, 1, 2, 3], the LIS  is [1, 2, 3], return 3
 * <p/>
 * For [4, 2, 4, 5, 3, 7], the LIS is [4, 4, 5, 7], return 4
 */
public class LIS {
    public int getLISLength(int[] a) {
        if (a == null || a.length == 0) return 0;
        int[] b = new int[a.length + 1];
        int maxLen = 0;

        for (int i = 0; i < a.length; i++) {
            if (a[i] > b[maxLen]) {
                b[++maxLen] = a[i];
            } else {
                int mid = 1, high = maxLen, low = 1;
                while (low < high) {
                    mid = (low + high) / 2;
                    if (a[i] > mid)
                        low = mid + 1;
                    else if (a[i] < mid)
                        high = mid - 1;
                    else
                        break;
                }
                b[mid] = a[i];
            }
        }
        return maxLen;
    }

    public static void main(String[] args) throws Exception {
        LIS lis = new LIS();
        System.out.println(lis.getLISLength(new int[]{5, 4, 1, 2, 3}));
        System.out.println(lis.getLISLength(new int[]{4, 2, 4, 5, 3, 7}));
        System.out.println(lis.getLISLength(new int[]{4}));

    }
}
