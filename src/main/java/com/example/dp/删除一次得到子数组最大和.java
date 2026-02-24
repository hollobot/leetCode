package com.example.dp;

/**
 * https://leetcode.cn/problems/maximum-subarray-sum-with-one-deletion
 */
public class 删除一次得到子数组最大和 {

    public static void main(String[] args) {
        int[] a = new int[]{11,-10,-11,8,7,-6,9,4,11,6,5,0};
        maximumSum(a);
    }

    public static int maximumSum(int[] arr) {
        int len = arr.length;
        int dp1 = arr[0]; // 不删除
        int dp2 = 0; // 删除
        int ans = arr[0];
        for (int i = 1; i < len; i++) {
            // 必须删除一个情况有两种：
            // 1、i-1前面某个删除情况也就是dp2
            // 2、当前索引为i的这个删除,那么就是i-1不删除的情况也就是dp1
            dp2 = Math.max(dp2 + arr[i], dp1);
            // 一定不删除情况也就是dp1+arr[i]
            dp1 = Math.max(dp1, 0) + arr[i];
            ans = Math.max(ans, Math.max(dp1, dp2));
        }
        return ans;
    }
}
