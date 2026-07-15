package com.example.LeetCode75.字符串和数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class 递增的三元子序列 {

    public static void main(String[] args) {
        List<Integer> g = new ArrayList<>(Arrays.asList(20, 100));
        递增的三元子序列 递增的三元子序列 = new 递增的三元子序列();
        System.out.println(递增的三元子序列.twoQ(99, g));
    }

    public boolean increasingTriplet(int[] nums) {
        List<Integer> g = new ArrayList<>();
        for (int num : nums) {
            int i = twoQ(num, g);
            if (i == g.size()) {
                g.add(num);
            } else {
                g.set(i, num);
            }
            if (g.size() == 3) {
                return true;
            }
        }
        return false;
    }

    public int twoQ(int num, List<Integer> list) {
        int left = -1, right = list.size();
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) >= num) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return right;
    }
}
