package com.nateriver.app.cracking;

/**
 * Implement an algorithm to determine if a string has all unique characters.
 * What if you can not use additional data structures?
 */

public class Q11 {

  /**
   * use 256 length array to judge if a char is unique
   */
  public static boolean isUnique1(String s){
    boolean[] markArr = new boolean[256];
    char[] chars = s.toCharArray();
    for(char c: chars){
      int asciiCode = (int) c;
      if(markArr[asciiCode]==true)
        return false;
      else
        markArr[asciiCode] = true;
    }
    return true;
  }

  /**
   * 1 int = 32 bit, so 256 can use int[8] replace
   */
  public static boolean isUnique2(String s){
    int[] mark = new int[8];
    for(char c: s.toCharArray()){
      int asciiCode = (int) c;
      int idx = asciiCode / 32;
      int position = asciiCode % 32;
      int res = mark[idx] & (1 << position);
      if( res != 0 )
        return false;
      mark[idx] |= (1 << position);
    }
    return  true;
  }

  public static void main(String[] args) {
    String test = "assdsdsdsd";
    String test1 = "jksdopmn [i";

    System.out.println("isUnique1 test result: " + isUnique1(test));
    System.out.println("isUnique1 test1 result: " + isUnique1(test1));

    System.out.println("isUnique1 test result: " + isUnique2(test));
    System.out.println("isUnique1 test1 result: " + isUnique2(test1));

  }


}
