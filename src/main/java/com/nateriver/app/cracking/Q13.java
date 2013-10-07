package com.nateriver.app.cracking;

/**
 * Design an algorithm and write code to remove the duplicate characters in a string without using any additional buffer.
 * NOTE: One or two additional variables are fine. An extra copy of the array is not.
 * FOLLOW UP
 * Write the test cases for this method.
 */
public class Q13 {

  /**
   * use int[8] to mark if a char show in a string,
   * then use '\0' to remove the duplicate char
   */
  public static String removeDuplicate1(char[] chars){

    if(chars.length == 0 || chars.length ==1)
      return new String(chars);

    int[] mark = new int[8];

    for(int i = 0;i < chars.length; i++){
      int ascii = (int) chars[i];
      int idx = ascii/32;
      int position = ascii%32;

      if((mark[idx] & (1<<position)) != 0)
        chars[i] = '\0';
      else
        mark[idx]|= (1 << position);
    }

    return new String(chars);
  }

  /**
   * if do not allow to open a array to mark,
   * you can first sort the array like [heap sort]
   * then remove the duplicate char, time complexity would be O(nlogn) + O(n)
   */
  public static String removeDuplicate2(char[] chars){

    if(chars.length == 0 || chars.length ==1)
      return new String(chars);
    //todo when finish heap sort, will do this
    return new String(chars);
  }

  public static void main(String[] args) {
    String testCase1 = "bb";
    String testCase2 = "a";
    String testCase3 = "abbcde";
    String testCase4 = "addd";
    String testCase5 = "";

    System.out.println(removeDuplicate1(testCase1.toCharArray()));
    System.out.println(removeDuplicate1(testCase2.toCharArray()));
    System.out.println(removeDuplicate1(testCase3.toCharArray()));
    System.out.println(removeDuplicate1(testCase4.toCharArray()));
    System.out.println(removeDuplicate1(testCase5.toCharArray()));

  }
}
