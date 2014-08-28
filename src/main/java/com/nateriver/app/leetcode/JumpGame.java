package com.nateriver.app.leetcode;

/**
 * https://oj.leetcode.com/problems/jump-game/
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * <p/>
 * Each element in the array represents your maximum jump length at that position.
 * <p/>
 * Determine if you are able to reach the last index.
 * <p/>
 * For example:
 * A = [2,3,1,1,4], return true.
 * <p/>
 * A = [3,2,1,0,4], return false.
 */
public class JumpGame {
    public boolean canJump(int[] A) {
        boolean[] isReach = new boolean[A.length];
        isReach[A.length - 1] = true;

        for (int i = A.length - 2; i >= 0; i--) {
            int start = i;
            int end = start + A[i];
            while (start < end){
                if(isReach[++start]){
                    isReach[i] = true;
                    break;
                }
            }
        }

        return isReach[0];
    }

    public static void main(String[] args) throws Exception {
        JumpGame jumpGame = new JumpGame();
        System.out.println(jumpGame.canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(jumpGame.canJump(new int[]{3, 2, 1, 0, 4}));
        System.out.println(jumpGame.canJump(new int[]{2, 0}));
    }
}
