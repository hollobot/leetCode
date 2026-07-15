package com.example.LeetCode75.前缀和;

public class 找到最高海拔 {

    public static void main(String[] args) {
        largestAltitude(new int[]{28,0,-8,-99,11,62,-35,68,2,12,-71,13,66,-28});
    }

    public static int largestAltitude(int[] gain) {
        int max = 0;
        int pre = 0;
        for (int i = 1; i < gain.length - 1; i++) {
            int tem = gain[i - 1];
            gain[i - 1] = pre;
            pre = tem + gain[i - 1];
            max = Math.max(max, pre);
        }
        return max;
    }
}
