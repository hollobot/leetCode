package com.example.dp;

// https://leetcode.cn/problems/maximum-total-damage-with-spell-casting

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 施咒的最大总伤害 {

    public static void main(String[] args) {
        int[] a = new int[]{1,1,3,4};
        maximumTotalDamage(a);
    }

    public static long maximumTotalDamage(int[] power) {
        Map<Integer, Integer> map = new HashMap();
        for (int num : power) {
            map.put(num, map.getOrDefault(num, 0) + num);
        }

        int size = map.size();
        int[] arr = new int[size];
        int index = 0;
        for (int k : map.keySet()) {
            arr[index++] = k;
        }
        Arrays.sort(arr);
        long[] f = new long[size + 1];
        int j = 0;
        for (int i = 0; i < size; i++) {
            int c = arr[i];
            while (arr[j] < c - 2) {
                j++;
            }
            f[i + 1] = Math.max(f[i], f[j] + map.get(c));
        }
        return f[size];
    }
}
