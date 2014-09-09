package com.nateriver.app.leetcode;

/**
 * https://oj.leetcode.com/problems/climbing-stairs/
 * You are climbing a stair case. It takes n steps to reach to the top.
 * <p/>
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */
public class ClimbingStairs {
    public int climbStairs(int n) {
        if(n <= 0) return 0;
        if(n == 1) return 1;
        int cur = 1;
        int pre = 1;

        for(int i = 2; i <= n; i++){
            int tmp = cur + pre;
            pre = cur;
            cur = tmp;
        }
        return cur;
    }

    public static void main(String[] args) {
        ClimbingStairs cs = new ClimbingStairs();
        System.out.println(cs.climbStairs(1));
        System.out.println(cs.climbStairs(2)); // 1,1 * 2
        System.out.println(cs.climbStairs(3));
        System.out.println(cs.climbStairs(4));  // 1,1,1,1 * 2,1,1 * 1,2,1  * 2,2 * 1,1,2
        System.out.println(cs.climbStairs(5));  // 1,1,1,1 * 2,1,1 * 1,2,1  * 2,2 * 1,1,2

    }

}
