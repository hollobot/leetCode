package com.example.区间;

import java.util.Arrays;
import java.util.Comparator;

public class 用最少数量的箭引爆气球 {

    public static void main(String[] args) {

    }

    public int findMinArrowShots(int[][] points) {
        // 排序
        Arrays.sort(points, Comparator.comparing(p -> p[1]));
        int len = points.length;
        int count = 0;
        int last = 0;
        for (int i = 0; i < len; i++) {
            if (last<points[i][0]) {
                last = points[i][1];
                count++;
            }
        }

        return count;
    }
}
