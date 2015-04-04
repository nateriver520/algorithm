package com.nateriver.app.quiz;


import com.nateriver.app.utils.CompareUtil;

import java.util.ArrayList;


public class MaxSubString {
    public static double maxMultiplySubStr(double[] a, int length) {
        double maxEnd = a[0];
        double minEnd = a[0];
        double maxResult = a[0];
        for (int i = 1; i < length; ++i) {
            double end1 = maxEnd * a[i], end2 = minEnd * a[i];
            maxEnd = Math.max(Math.max(end1, end2), a[i]);
            minEnd = Math.min(CompareUtil.min(end1, end2), a[i]);
            maxResult = Math.max(maxResult, maxEnd);
        }
        return maxResult;
    }

    public static double maxPlusSubStr(double a[], int len) {
        double maxsum, maxhere;
        ArrayList<Double> tempList = new ArrayList<>();
        ArrayList<Double> maxList = new ArrayList<>();

        maxsum = maxhere = a[0];
        for (int i = 1; i < len; i++) {
            if (maxhere <= 0) {
                maxhere = a[i];
                tempList.clear();
                tempList.add(a[i]);
            } else {
                maxhere += a[i];
                tempList.add(a[i]);
            }
            if (maxhere > maxsum) {
                maxsum = maxhere;
                maxList = (ArrayList) tempList.clone();
            }
        }

        for (Double d : maxList) {
            System.out.println(d);
        }
        return maxsum;
    }

    public static void main(String[] args) throws Exception {
        double[] a = new double[]{-2.5, 4, 0, 3, 0.5, 8, -1};
        System.out.println(maxMultiplySubStr(a, a.length));
        System.out.println(maxPlusSubStr(a, a.length));
    }
}
