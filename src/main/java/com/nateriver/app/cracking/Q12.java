package com.nateriver.app.cracking;

/**
 * Write code to reverse a C-Style String.
 * (C-String means that “abcd” is represented as five characters, including the null character.)
 */
public class Q12 {

  /**
   * from head to tail to swap , once head < tail
   * means swap finish
   */
  public static String reverse(String s){
    char[] arr = s.toCharArray();
    for(int i = 0, j = arr.length - 1; i < j; i ++,j--){
      char a = arr[i];
      arr[i] = arr[j];
      arr[j] = a;
    }
    return new String(arr);
  }

  public static void main(String[] args) {
    String testCase1 = "abcd";
    String testCase2 = "abcde";

    System.out.println(reverse(testCase1));
    System.out.println(reverse(testCase2));

  }
}
