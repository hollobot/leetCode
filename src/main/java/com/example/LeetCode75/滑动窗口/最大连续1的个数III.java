package com.example.LeetCode75.滑动窗口;

public class 最大连续1的个数III {

    public static void main(String[] args) {
        longestOnes(new int[] {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2);
    }

    public static int longestOnes(int[] nums, int k) {
        int len = nums.length;
        int l = 0, r = 0;
        int sum = nums[0];
        int max = 0;
        while (r < len) {
            int step = r - l + 1;
            if (step - sum <= k) {
                max = Math.max(max, step);
                r++;
                if (r < len) {
                    sum += nums[r];
                }
            } else {
                if (l < len) {
                    sum -= nums[l];
                }
                l++;
            }
        }

        return max;
    }
}
