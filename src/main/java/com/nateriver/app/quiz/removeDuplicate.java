package com.nateriver.app.quiz;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Write a function to remove duplicated objects from an array.
 * Preserve the order.
 * For example, if the input array is [1, 5, 4, 2, 7, 2, 6, 5],
 * the result should be [1, 5, 4, 2, 7, 6]. The implementation should be optimized for executing speed.
 */
public class RemoveDuplicate {
    public Integer[] uniq(Integer[] numbers) throws Exception{
        if(numbers == null) throw new Exception("Array cannot be null");

        Map<Integer,Integer> linkmap = new LinkedHashMap<>();

        for(Integer num : numbers){
            linkmap.put(num,1);
        }
        List<Integer> array = new ArrayList(linkmap.keySet());
        return array.toArray(new Integer[array.size()]);
    }


    public static void main(String[] args) throws Exception {
        RemoveDuplicate duplicater = new RemoveDuplicate();
        Integer[] uniqNumbers = duplicater.uniq(new Integer[]{1,2,5,7,2,8});
        System.out.println(uniqNumbers);
    }
}
