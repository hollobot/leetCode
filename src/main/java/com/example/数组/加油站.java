package com.example.数组;

public class 加油站 {

    public static void main(String[] args) {
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
        System.out.println(canCompleteCircuit(gas, cost));
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            ans[i] = gas[i] - cost[i];
        }

        int l = 0;
        int index = 1;
        int sum = ans[0];
        for (int i = 1; i < 2 * len; i++) {

            // last 点
            if (index >= len) {
                index = 0;
            }

            if (index == l && sum >= 0) {
                return index;
            }

            if (sum < 0) {
                l = index;
                sum = ans[l];
                index = l + 1;
            } else {
                sum += ans[index];
                index++;
            }

        }

        return -1;
    }
}
