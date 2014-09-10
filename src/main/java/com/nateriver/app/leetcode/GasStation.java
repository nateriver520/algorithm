package com.nateriver.app.leetcode;

/**
 * https://oj.leetcode.com/problems/gas-station/
 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
 * <p/>
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.
 * <p/>
 * Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
 * <p/>
 * Note:
 * The solution is guaranteed to be unique.
 */
public class GasStation {
    /**
     * http://blog.csdn.net/xuqingict/article/details/18840947
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int stationNum = gas.length;
        int[] rest = new int[stationNum];
        for (int i = 0; i < stationNum; i++)
            rest[i] = gas[i] - cost[i];

        int sum = 0;
        int total = 0;
        int pre = -1;

        for (int i = 0; i < stationNum; i++) {
            sum += rest[i];
            total += rest[i];

            if (sum < 0) {
                pre = i;
                sum = 0;
            }
        }
        return total >= 0 ? pre + 1 : -1;
    }

    public static void main(String[] args) throws Exception {
        GasStation gs = new GasStation();
        System.out.println(gs.canCompleteCircuit(new int[]{4}, new int[]{5}));
    }
}
