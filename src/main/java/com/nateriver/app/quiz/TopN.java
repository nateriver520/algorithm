package com.nateriver.app.quiz;

import java.util.*;

/**
 * There is an array of 10000000 different int numbers.
 * Find out its largest 100 elements.
 * The implementation should be optimized for executing speed
 */
public class TopN extends Object {
    public Integer[] getTopNFromUniqArray(Integer[] numbers, Integer topN) throws Exception {
        if (numbers == null) throw new Exception("Array cannot be null");
        if (numbers.length <= topN) {
            System.out.println("The number of array less than or equal to topN, so return numbers");
            return numbers;
        }

        TreeSet<Integer> sets = new TreeSet<>();
        for (Integer num : numbers) {
            sets.add(num);
            if (sets.size() == topN + 1) {
                sets.pollFirst();
            }
        }
        List<Integer> array = new ArrayList(sets);

        return array.toArray(new Integer[array.size()]);
    }


    public static void main(String[] args) throws Exception {
        TopN top = new TopN();
        Integer[] uniqNumbers = top.getTopNFromUniqArray(new Integer[]{1, 2, 5, 7, 2, 8}, 2);
        System.out.println(uniqNumbers);
    }

}
