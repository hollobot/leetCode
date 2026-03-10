package com.example.windowSlide.定长滑动窗口;

import java.util.HashMap;
import java.util.Map;

public class 长度为K子数组中的最大和 {

    public long maximumSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap();
        long max = 0;
        long sum = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int num = nums[i];
            sum += num;
            map.put(num, map.getOrDefault(num, 0) + 1);

            int left = i + 1 - k;

            if (left < 0) {
                continue;
            }

            if(map.size()==k){
                max = Math.max(max,sum);
            }

            num = nums[left];
            sum -= num;
            Integer index = map.get(num);
            if(index>1){
                map.put(num,index-1);
            }else{
                map.remove(num);
            }

        }

        return max;
    }
}
