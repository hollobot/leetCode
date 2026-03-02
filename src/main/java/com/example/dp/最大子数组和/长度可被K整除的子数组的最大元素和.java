package com.example.dp.最大子数组和;

import java.util.Arrays;

public class 长度可被K整除的子数组的最大元素和 {

    public static void main(String[] args) {
        int[] arr = new int[] {-17,-10,-7};
        maxSubarraySum(arr, 2);
    }

    public static long maxSubarraySum(int[] nums, int k) {
        int len = nums.length;
        int[] sum = new int[len+1];
        for(int i=0;i<len;i++){
            sum[i+1] = sum[i] + nums[i];
        }

        int[] dp = new int[k];
        for(int i=0;i<k;i++){
            dp[i] = sum[i+1];
        }
        int mx = dp[k-1];
        for(int i=k;i<len;i++){
            int index = i % k;
            mx = Math.max(mx,sum[i+1]-dp[index]);
            // 跟新最小前缀和
            dp[index] = Math.min(dp[index],sum[index]);
        }

        return mx;
    }
}
