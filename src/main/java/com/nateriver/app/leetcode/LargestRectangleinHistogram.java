package com.nateriver.app.leetcode;

/**
 * https://oj.leetcode.com/problems/largest-rectangle-in-histogram/
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1,
 * find the area of largest rectangle in the histogram.
 * <p/>
 * <p/>
 * Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
 * <p/>
 * <p/>
 * The largest rectangle is shown in the shaded area, which has area = 10 unit.
 * <p/>
 * For example,
 * Given height = [2,1,5,6,2,3],
 * return 10.
 */
public class LargestRectangleinHistogram {
    public int largestRectangleArea(int[] height) {
        if (height.length == 0) return 0;
        int[] maxArea = new int[height.length];
        maxArea[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            maxArea[i] = height[i];
            int curHeight = height[i];
            for (int j = i - 1; j >= 0; j--) {
                curHeight = Math.min(height[j], curHeight);
                int curArea = (i - j + 1) * curHeight;
                if (curArea >= maxArea[i])
                    maxArea[i] = curArea;
                else
                    break;
            }
            maxArea[i] = maxArea[i] > maxArea[i - 1] ? maxArea[i] : maxArea[i - 1];
        }
        return maxArea[height.length - 1];
    }

    public static void main(String[] args) {
        LargestRectangleinHistogram lh = new LargestRectangleinHistogram();
        System.out.println(lh.largestRectangleArea(new int[]{3, 4, 4, 4, 4, 1}));
    }
}
