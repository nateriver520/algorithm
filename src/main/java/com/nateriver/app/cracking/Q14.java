package com.nateriver.app.cracking;

import com.nateriver.app.sort.DictionarySort;
import java.util.HashMap;

/**
 * Write a method to decide if two strings are anagrams or not.
 * anagrams means characters are same, but the position changed
 * like: abbcd and abcdb
 */
public class Q14 {
  /**
   * first sort by dictionary,then compare each char
   */
  public static boolean isAnagrams1(String s1,String s2){
    if(s1.isEmpty()||s2.isEmpty()||s1.length()!=s2.length())
      return false;

    char[] chars1 = DictionarySort.sort(s1.toCharArray(),true);
    char[] chars2 = DictionarySort.sort(s2.toCharArray(),true);

    for(int i = 0; i < chars1.length;i++){
      if(chars1[i] != chars2[i])
        return false;
    }

    return true;
  }

  /**
   *  use int[256] to count char count
   */
  public static boolean isAnagrams2(String s1,String s2){
    if(s1.isEmpty()||s2.isEmpty()||s1.length()!=s2.length())
      return false;

    int[] mark = new int[256];

    for(char c:s1.toCharArray()){
      mark[c] += 1;
    }

    for(char c:s2.toCharArray()){
      mark[c] -= 1;
    }

    for(int m:mark){
      if(m != 0)
        return false;
    }

    return true;
  }

  /**
   * another way is use every char => [prime number]
   * then multiply s1's chars and divide s2's chars
   * to judge the result
   */
  public static boolean isAnagrams3(String s1,String s2){
    //todo:need to think about big number multiply
    return false;
  }


  public static void main(String[] args) {
    String testCase1_1 = "bb",testCase1_2 = "bb";
    String testCase2_1 = "a", testCase2_2 = "CC";
    String testCase3_1 = "bb  a",testCase3_2 = "a bb";
    String testCase4_1 = "asasas", testCase4_2 = "sssaaa";

    System.out.println(isAnagrams1(testCase1_1,testCase1_2));
    System.out.println(isAnagrams1(testCase2_1,testCase2_2));
    System.out.println(isAnagrams1(testCase3_1,testCase3_2));
    System.out.println(isAnagrams1(testCase4_1,testCase4_2));

    System.out.println(isAnagrams2(testCase1_1,testCase1_2));
    System.out.println(isAnagrams2(testCase2_1,testCase2_2));
    System.out.println(isAnagrams2(testCase3_1,testCase3_2));
    System.out.println(isAnagrams2(testCase4_1,testCase4_2));
  }
}
