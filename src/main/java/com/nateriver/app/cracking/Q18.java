package com.nateriver.app.cracking;

/**
 * Assume you have a method isSubstring which checks if one word is a substring of another.
 * Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using only one call to isSubstring
 * ( i.e., “waterbottle” is a rotation of “erbottlewat”).
 */
public class Q18 {

    /**
     * Take judge s1=waterbottle，s2=erbottlewat for example
     * We just make sure is s2 in s1 + s1 = waterbottlewaterbottle
     */
    public static boolean isRotation(String s1,String s2){
        if(s1.length()!= s2.length())
            return false;
        String s = s1 + s1;
        return isSubstring(s,s2);
    }


    private static boolean isSubstring(String s1,String s2){
        if(s1.contains(s2))
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        String testCase1_1 = "apple",testCase1_2 = "pplea";
        System.out.print(isRotation(testCase1_1,testCase1_2));
    }
}
