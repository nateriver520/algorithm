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
public class JumpGameII {
    public int jump(int[] A) {
        int[] jumpStep = new int[A.length];
        jumpStep[jumpStep.length - 1] = 1;
        for (int i = A.length - 2; i >= 0; i--) {
            int canStep = A[i];
            int minStep = Integer.MAX_VALUE;
            for (int j = i; j <= i + canStep & j < A.length; j++) {
                if (jumpStep[j] == 0) continue;
                if (jumpStep[j] + 1 < minStep)
                    minStep = jumpStep[j] + 1;
            }
            jumpStep[i] = minStep;
        }

        return jumpStep[0] - 1;
    }

    public static void main(String[] args) throws Exception {
        JumpGameII jg = new JumpGameII();
        System.out.println(jg.jump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(jg.jump(new int[]{2, 3}));
        System.out.println(jg.jump(new int[]{1, 0, 0, 3}));
    }

}
