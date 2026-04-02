package com.example.区间;

import java.util.ArrayList;
import java.util.List;

public class 插入区间 {

    public static void main(String[] args) {
//        int[][] intervals = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[][] intervals = {{2, 3}, {5, 7}};
        int[] newInterval = {0, 6};
        insert(intervals, newInterval);
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        int len = intervals.length;
        List<int[]> list = new ArrayList();

        int count = -1;
        for (int i = 0; i < len; i++) {
            int[] nums = intervals[i];
            if (count == -1) {
                if (newInterval[1] < nums[0]) {
                    list.add(newInterval);
                    list.add(nums);
                    count = -2;
                } else if (newInterval[1] <= nums[1]) {
                    intervals[i] = new int[] { Math.min(newInterval[0], nums[0]), nums[1] };
                    return intervals;
                } else if (newInterval[0] >= nums[0] && newInterval[1] <= nums[1]) {
                    return intervals;
                } else if (newInterval[0] > nums[1]) {
                    list.add(nums);
                }  else if (newInterval[0] <= nums[1]) {
                    count =  Math.min(newInterval[0], nums[0]);
                }
            } else if (count > -1) {
                if (nums[0] > newInterval[1]) {
                    list.add(new int[] { count, newInterval[1] });
                    list.add(nums);
                    count = -2;
                } else if (nums[0] <= newInterval[1] && newInterval[1] <= nums[1]) {
                    list.add(new int[] { count, nums[1] });
                    count = -2;
                }
            } else {
                list.add(nums);
            }
        }

        if (count == -1) {
            list.add(newInterval);
        } else if (count > -1) {
            list.add(new int[] { count, newInterval[1] });
        }
        int size = list.size();
        int[][] result = new int[size][2];

        for (int i = 0; i < size; i++) {
            result[i] = list.get(i);
        }

        return result;
    }
}
