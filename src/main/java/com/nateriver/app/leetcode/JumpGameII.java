package com.nateriver.app.leetcode;

/**
 * https://oj.leetcode.com/problems/jump-game-ii/
 * Jump Game II
 * <p/>
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * <p/>
 * Each element in the array represents your maximum jump length at that position.
 * <p/>
 * Your goal is to reach the last index in the minimum number of jumps.
 * <p/>
 * For example:
 * Given array A = [2,3,1,1,4]
 * <p/>
 * The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
 */

/**
 * http://blog.csdn.net/AIvin24/article/details/33774891
 */
public class JumpGameII {
    public int jump(int[] A) {
        int[] jumpStep = new int[A.length];
        for (int i = 0; i < jumpStep.length; i++)
            jumpStep[i] = Integer.MAX_VALUE;
        jumpStep[0] = 0;

        for(int i = 1; i < jumpStep.length; i++){
            for(int j = 0; j < i; j++){
                if(A[j] + j >= i){
                    if(jumpStep[j] + 1 < jumpStep[i]){
                        jumpStep[i] = jumpStep[j] +1;
                        break;
                    }
                }
            }
        }
        return jumpStep[jumpStep.length - 1];
    }

    public static void main(String[] args) throws Exception {
        JumpGameII jg = new JumpGameII();
        System.out.println(jg.jump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(jg.jump(new int[]{2, 3}));
        System.out.println(jg.jump(new int[]{1, 0, 0, 3}));
    }

}
