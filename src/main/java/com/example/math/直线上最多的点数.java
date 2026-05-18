package com.example.math;

import java.util.HashMap;
import java.util.Map;

public class 直线上最多的点数 {

    public int maxPoints(int[][] points) {
        int len = points.length;
        int ans = 0;
        for (int i = 0; i < len; i++) {
            int[] arr = points[i];
            Map<Double, Integer> hash = new HashMap<>();
            for (int j = 0; j < len; j++) {
                if (j == i) {
                    continue;
                }
                Double k = (double)(arr[1] - points[j][1]) / (arr[0] - points[j][0]);
                Integer count = hash.get(k);
                if (count == null) {
                    count = 2;
                } else {
                    count++;
                }
                hash.put(k, count);
                ans = Math.max(ans, count);
            }
        }

        return ans;
    }
}
