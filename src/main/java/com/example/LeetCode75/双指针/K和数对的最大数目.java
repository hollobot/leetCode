package com.example.LeetCode75.双指针;

import java.util.Arrays;

public class K和数对的最大数目 {

    public static void main(String[] args) {
        maxOperations(new int[] {3, 1, 3, 4, 3}, 6);
    }

    public static int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int count = 0;
        int len = nums.length;
        int l = 0;
        int r = len - 1;
        while (l < r) {

            while (l < r && nums[r] == 0) {
                r--;
            }

            int sum = nums[l] + nums[r];
            if (sum == k) {
                nums[l++] = 0;
                nums[r--] = 0;
                count++;
            } else if (sum > k) {
                r--;
            } else {
                l++;
            }
        }
        return count;
    }

}
