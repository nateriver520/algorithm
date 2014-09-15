package com.nateriver.app.leetcode;

import java.util.Stack;

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
    /**
     * Answer : http://www.cnblogs.com/avril/archive/2013/08/24/3278873.html
     */
    public int largestRectangleArea(int[] height) {
        int area = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < height.length; i++) {
            if (stack.empty() || height[stack.peek()] < height[i]) {
                stack.push(i);
            } else {
                int start = stack.pop();
                int width = stack.empty() ? i : i - stack.peek() - 1;
                area = Math.max(area, height[start] * width);
                i--;
            }
        }
        while (!stack.empty()) {
            int start = stack.pop();
            int width = stack.empty() ? height.length : height.length - stack.peek() - 1;
            area = Math.max(area, height[start] * width);
        }
        return area;
    }

    public static void main(String[] args) {
        LargestRectangleinHistogram lh = new LargestRectangleinHistogram();
        System.out.println(lh.largestRectangleArea(new int[]{3, 4, 4, 4, 4, 1}));
    }
}
