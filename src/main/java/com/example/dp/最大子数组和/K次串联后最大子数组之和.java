package com.example.dp.最大子数组和;

/**
 * https://leetcode.cn/problems/k-concatenation-maximum-sum
 */

public class K次串联后最大子数组之和 {

    public static void main(String[] args) {
        int num = 10000;
        int sum = 0;
        for(int i=0;i<1000000;i++){
            sum = (sum + num)%MOD;
        }
        System.out.println(sum);
        int[] a = new int[]{10000,10000,10000,10000,10000,10000,10000,10000,10000,10000};
//        kConcatenationMaxSum(a,10000);
    }

    private static final int MOD = 1_000_000_007;

    public static int kConcatenationMaxSum(int[] arr, int k) {
        int len = arr.length;
        int size = len * Math.min(k, 2);

        long d = 0, p = 0;

        for (int i = 0; i < size; i++) {
            d = Math.max(d, 0) + arr[i % len];
            p = Math.max(p, d);
        }

        if (k == 1) {
            return (int) (p % MOD);
        }

        long sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return (int) ((Math.max(sum, 0) * (k - 2) + p) % MOD);
    }
}
