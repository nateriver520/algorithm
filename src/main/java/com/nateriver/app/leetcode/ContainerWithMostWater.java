package com.nateriver.app.leetcode;

/**
 Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai).
 n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
 Find two lines, which together with x-axis forms a container, such that the container contains the most water.

 Note: You may not slant the container.
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < height.length -1; i++)
            for(int j = i+1; j < height.length; j++){
                int area = (j-i) * Math.min(height[i],height[j]);
                if(area > max)
                    max = area;
            }

        return max;
    }
}
