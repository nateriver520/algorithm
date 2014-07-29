package com.nateriver.app.quiz;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


/**
 * Give a number N, print the number is equal or lesser than N，
 * and the order is based on alpha order
 *
 * Example
 *
 * Give N = 10
 *
 * Output:
 *  1
 *  10
 *  2
 *  3
 *  4
 *  5
 *  7
 *  8
 *  9
 */
public class AlphabetaOrderOutputer {

    static List<String> numbers = new ArrayList<>();
    public static void main(String[] args) {
        int n = 10;

        getFullAlph(String.valueOf(n).length() + 1  , new Stack<Integer>(), n);

        for(String s: numbers){
            System.out.println(s);
        }

    }

    /*public static void main(String[] args) {
        for(int i=1;i< 10;i++)
        printRec(""+i, 1000);
    }
    static void printRec(String str, int n){
        if(Integer.parseInt(str) > n)
            return;
        System.out.println(str);
        for(int i=0;i< 10;i++)
        printRec(str+i,n);
    }
    */

    static void getFullAlph(int length, Stack<Integer> tmp, int n){

        if(length == 0){
            return;
        }
        String tempRes = listToString(tmp);
        if(!tempRes.isEmpty() && !tempRes.startsWith("0") && Integer.valueOf(tempRes) <= n)
            numbers.add(listToString(tmp));

        for(int i = 0; i <= 9; i++){
            tmp.push(i);
            getFullAlph(length -1, tmp, n);
            tmp.pop();
        }
    }

    static String listToString( List<Integer> l){
        String res = "";
        for(Integer i : l){
            res += i;
        }
        return  res;
    }

}
