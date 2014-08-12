package com.nateriver.app.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 */
public class MaxPoint {
    public int maxPoints(Point[] points) {
        if(points == null || points.length == 0) return 0;
        if(points.length == 1) return 1;
        int maxLength = 0;
        for(int i =0; i< points.length; i++){
            Map<Double,Integer> slopeMap = new HashMap<>();
            int equalPointCount = 0;
            int curMaxLength = 0;
            for(int j = 0; j < points.length; j++){
                if(i == j) continue;
                // if two point equal
                if(isEqual(points[i],points[j])){
                    equalPointCount++;
                    continue;
                }

                double slope = calSlope(points[i],points[j]);
                int cur;
                if(slopeMap.containsKey(slope))
                    cur = slopeMap.get(slope) + 1;
                else
                    cur = 1;
                if(cur > curMaxLength) curMaxLength = cur;
                slopeMap.put(slope,cur);
            }
            curMaxLength += 1 + equalPointCount;
            if( curMaxLength > maxLength) maxLength = curMaxLength;
        }

        return maxLength;
    }

    // should parse to double
    public double calSlope(Point a, Point b){
        return (double)(a.y -b.y)/(double)(a.x - b.x);
    }

    public boolean isEqual(Point a, Point b){
        return a.x == b.x && a.y == b.y;
    }

    public static void main(String[] args) throws Exception {
        Point[] points = new Point[]{
                new Point(84,250),
                new Point(0,0),
                new Point(1,0),
                new Point(0,-70),
                new Point(0,-70),
                new Point(1,-1),
                new Point(21,10),
                new Point(42,90),
                new Point(-42, -230)

        };
        MaxPoint mx = new MaxPoint();
        System.out.println(mx.maxPoints(points));
    }

}


class Point {
    int x;
    int y;
    Point() { x = 0; y = 0; }
    Point(int a, int b) { x = a; y = b; }
}
