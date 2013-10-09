package com.nateriver.app.cracking;

/**
 * Write a method to replace all spaces in a string with ‘%20’.
 */
public class Q15 {

    public static char[] replace(char[] chars){
        //first get the count of space
        //we set the rule when char equals '/0' means end
        int spaceCount = 0;
        int length = 0;
        char[] replaceChars;

        for(char c: chars){
            if(c == ' ')
                spaceCount++;
            length ++;
            if(c == '\0')
                break;
        }

        //so the new space will be length * 2
        int newLength = length + spaceCount*2;
        if(chars.length >= newLength){
            //this means the old chars have enough spaces
            replaceChars = chars;
            newLength--;
        }
        else {
            //if not we should open another chars
            replaceChars = new char[newLength--];
        }

        for(int i = length -1; i >=0; --i){
            if(chars[i] == ' '){
                replaceChars[newLength--] = '0';
                replaceChars[newLength--] = '2';
                replaceChars[newLength--] = '%';
            }
            else{
                replaceChars[newLength--] = chars[i];
            }
        }
        return replaceChars;
    }

    public static void main(String[] args) {
        char[] testCase1 = new char[]{'a',' ','b',' ',' ','d'};
        char[] testCase2 = new char[10];

        testCase2[0] = ' ';
        testCase2[1] = 'a';
        testCase2[2] = 'b';
        testCase2[3] = ' ';
        testCase2[4] = '\0';

        System.out.println(new String(replace(testCase1)));
        System.out.println(new String(replace(testCase2)));

    }
}
