package com.example.heap;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        // Queue<Integer> queue = new PriorityQueue((a,b)-> a - b);
        Queue<Integer> queue = new PriorityQueue<>((a, b) -> a - b);
    }

    public int lastStoneWeight(int[] stones) {
        Queue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        for (int num : stones) {
            queue.offer(num);
        }

        while (queue.size() > 1) {
            int sum = (queue.poll() - queue.poll());
            queue.offer(Math.abs(sum));
        }
        return queue.peek();
    }

    /** 查找和最小的 K 对数字 */
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        Queue<int[]> queue = new PriorityQueue<>((int[] a1, int[] a2) -> a1[0] - a2[0]);

        for (int i = 0; i < k; i++) {
            queue.offer(new int[] {nums1[i] + nums2[0], i, 0});
        }
        int m = nums1.length;
        List<List<Integer>> res = new ArrayList<>();
        while (k > 0) {
            int[] poll = queue.poll();
            int i = poll[0];
            int j = poll[1];
            res.add(new ArrayList<>(Arrays.asList(nums1[i], nums2[j])));
            if (++j < m) {
                queue.offer(new int[] {nums1[i] + nums2[j],i, j});
            }
        }

        return res;
    }
}
