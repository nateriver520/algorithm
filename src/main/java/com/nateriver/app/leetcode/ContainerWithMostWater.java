package com.nateriver.app.leetcode;

/**
 Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai).
 n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
 Find two lines, which together with x-axis forms a container, such that the container contains the most water.

 Note: You may not slant the container.
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length -1;
        int max = Integer.MIN_VALUE;

        while (l < r){
            max = Math.max(Math.min(height[l], height[r])* (r-l), max);
            if(height[l] < height[r])
                l++;
            else
                r--;
        }

        return max;
    }
}
