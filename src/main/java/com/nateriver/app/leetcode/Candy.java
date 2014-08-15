package com.nateriver.app.leetcode;


/**
 There are N children standing in a line. Each child is assigned a rating value.

 You are giving candies to these children subjected to the following requirements:

 Each child must have at least one candy.
 Children with a higher rating get more candies than their neighbors.
 What is the minimum candies you must give?

 3 1 2 6 9 5
 */
public class Candy {
    public int candy(int[] ratings) {
        if(ratings == null || ratings.length == 1) return  0;
        int[] candyArr = new int[ratings.length];
        for(int i = 0; i < candyArr.length; i++){
            candyArr[i] = 1;
        }

        for(int i= 0,j = i+1; j < ratings.length; i++,j++){
            if(ratings[i] < ratings[j])
                candyArr[j] = candyArr[i] + 1;
            else if(ratings[i] > ratings[j]){
                liftDown(ratings,candyArr, j);
            }
        }

        int res = 0;
        for(int i : candyArr){
            res += i;
        }
        return res;
    }

    public void liftDown(int[] ratings, int[] result, int cur){
        if(cur -1 < 0 || cur <= 0) return;
        if(ratings[cur] > ratings[cur-1]) return;
        if(ratings[cur] == ratings[cur -1])
            result[cur -1] = result[cur];
        else
            result[cur -1] = result[cur]+ 1;
        liftDown(ratings,result, cur-1);
    }

    public static void main(String[] args) {
        Candy c = new Candy();
        c.candy(new int[] { 1,1,2,6, 9,5});
    }
}
