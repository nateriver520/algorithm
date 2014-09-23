package com.nateriver.app.leetcode;

import com.nateriver.app.models.Interval;

import java.util.*;

/**
 Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

 You may assume that the intervals were initially sorted according to their start times.

 Example 1:
 Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].

 Example 2:
 Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].

 This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 */
public class InsertInterval {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<>();
        intervals.add(newInterval);
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.start < o2.start)
                    return 1;
                if (o1.start == o2.start) {
                    if (o1.end == o2.end)
                        return 0;

                    if (o1.end < o2.end)
                        return 1;
                    else
                        return -1;
                }

                if (o1.start > o2.start)
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
}
