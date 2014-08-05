package com.nateriver.app.leetcode;

/**
 Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

 Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

 Note:
 You are not suppose to use the library's sort function for this problem.

 click to show follow up.

 Follow up:
 A rather straight forward solution is a two-pass algorithm using counting sort.
 First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.

 Could you come up with an one-pass algorithm using only constant space?
 */

public class SortColors {
    public void sortColors(int[] A) {
        if(A == null || A.length == 0) return;
        int first = 0;
        int end = A.length -1;
        while (first <= end &&A[first] == 0) first++;
        first--;
        while (end >= 0 && A[end] == 2) end--;
        end++;

        int i = first+1;
        while (i < end){
            if(A[i] == 2){
                swap(A,i,--end);
            }
            else if(A[i] == 0){
                swap(A, i++, ++first);
            }
            else {
                i++;
            }
        }
    }

    public void swap(int[]A,int i ,int j){
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

    public static void main(String[] args) {
        int[] A = {0};
        SortColors sorter = new SortColors();
        sorter.sortColors(A);
        for(int i: A){
            System.out.print(i + " ");
        }
    }
}
