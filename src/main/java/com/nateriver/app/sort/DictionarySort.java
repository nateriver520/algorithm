package com.nateriver.app.sort;

import java.util.Arrays;
import java.util.Comparator;

public class DictionarySort {
  /**
   * sort chars by dictionary
   */
  public static char[] sort(char[] chs, final boolean upperFisrt)
  {
    Character[] srcArray = new Character[chs.length];
    char[] retArray = new char[chs.length];
    int index = 0;

    for(char ch: chs)
    {
      srcArray[index++] = ch;
    }


    Arrays.sort(srcArray, new Comparator<Character>() {
      public int compare(Character c1, Character c2) {

        char ch1 = Character.toUpperCase(c1);
        char ch2 = Character.toUpperCase(c2);

        if (ch1 == ch2) {
          int tempRet = c1.charValue() - c2.charValue();
          return upperFisrt ? tempRet : -tempRet;
        } else {
          return ch1 - ch2;
        }
      }
    });

    index = 0;

    for(char ch: srcArray)
    {
      retArray[index++] = ch;
    }

    return retArray;
  }


  public static void main(String[] args) {
    String testCase1 = "bdascsasA";
    System.out.println(new String(sort(testCase1.toCharArray(),true)));
  }

}
