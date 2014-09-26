package com.nateriver.app.leetcode;

import com.nateriver.app.models.Interval;

import java.util.*;

/**
 * https://oj.leetcode.com/problems/merge-intervals/
 Given a collection of intervals, merge all overlapping intervals.

 For example,
 Given [1,3],[2,6],[8,10],[15,18],
 return [1,6],[8,10],[15,18].
 */
public class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<>();
        Collections.sort(intervals,new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if(o1.start < o2.start)
                    return 1;
                if(o1.start == o2.start){
                    if(o1.end == o2.end)
                        return 0;

                    if(o1.end < o2.end)
                        return 1;
                    else
                        return -1;
                }

                if(o1.start > o2.start)
                    return -1;

                return 0;
            }
        });

        Stack<Interval> s = new Stack<>();
        s.addAll(intervals);


        while (s.size() > 1){
            Interval cur = s.pop();
            Interval next = s.pop();

            //no overlap
            if(cur.end < next.start){
                res.add(cur);
                s.push(next);
            }
            //cur contains next
            else if(next.end < cur.end){
                s.push(cur);
            }
            // merge
            else {
                Interval i = new Interval(cur.start,next.end);
                s.push(i);
            }

        }

        if(s.size() != 0) res.add(s.pop());
        return res;
    }

    public static void main(String[] args) {
        MergeIntervals mi = new MergeIntervals();
        List<Interval> is = new ArrayList<>();
        is.add(new Interval(1,3));
        is.add(new Interval(2,8));
        is.add(new Interval(8,10));
        is.add(new Interval(15,18));

        System.out.println(mi.merge(is));
    }
}

