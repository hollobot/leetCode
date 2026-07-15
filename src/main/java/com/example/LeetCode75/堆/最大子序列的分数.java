package com.example.LeetCode75.堆;

import java.util.PriorityQueue;

public class 最大子序列的分数 {
    public static void main(String[] args) {
        maxScore(new int[] {22, 5, 25, 15, 28, 1}, new int[] {22, 30, 25, 25, 9, 18}, 3);
    }

    public static long maxScore(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pq1 = new PriorityQueue<int[]>((e1, e2) -> e2[1] - e1[1]);
        PriorityQueue<int[]> pq2 = new PriorityQueue<int[]>((e1, e2) -> e2[1] - e1[1]);

        for (int i = 0; i < nums1.length; i++) {
            pq1.add(new int[] {i, nums1[i]});
            pq2.add(new int[] {i, nums2[i]});
        }

        long num1 = 0, min1 = 100000, num2 = 0, min2 = 100000;
        for (int i = 0; i < k; i++) {
            int[] poll1 = pq1.poll();
            num1 += poll1[1];
            min1 = Math.min(min1, nums2[poll1[0]]);
            int[] poll2 = pq2.poll();
            min2 = Math.min(min2, poll2[1]);
            num2 += nums1[poll2[0]];
        }
        return Math.max(num1 * min1, num2 * min2);
    }

}
