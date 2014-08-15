package com.nateriver.app.leetcode;


/**
 There are N children standing in a line. Each child is assigned a rating value.

 You are giving candies to these children subjected to the following requirements:

 Each child must have at least one candy.
 Children with a higher rating get more candies than their neighbors.
 What is the minimum candies you must give?

 1，5，4，3，2
 1  2 1  0  -1
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

    public int candy2(int[] ratings){
        if(ratings == null) return  0;
        int res = 1;
        int cur = 1;
        int preCur = 0;
        int dropCount = 0;

        for(int i = 0; i + 1 < ratings.length; i++){
            if(ratings[i] < ratings[i+1]){
                dropCount = 0;
                cur++;
                res += cur;
            }
            else if(ratings[i] == ratings[i+1]){
                cur =1;
                res += cur;
            }
            else{
                if(dropCount == 0){
                    preCur = cur;
                }
                dropCount ++;
                if(dropCount == 1 & preCur > 1)
                    res += 1;
                else if( dropCount < preCur)
                    res += dropCount;
                else
                    res += dropCount + 1;
                cur =1;
            }
        }
        return  res;
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
        System.out.println(c.candy(new  int[] {2,1,1,3,2,41,1,1,1,2,5,9,5,3,1}));
        System.out.println(c.candy2(new  int[] {2,1,1,3,2,41,1,1,1,2,5,9,5,3,1}));
    }
}
