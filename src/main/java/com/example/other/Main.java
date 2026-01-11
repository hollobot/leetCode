package com.example.other;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] nums = {4,3,2,1,1};
        int duplicate = findDuplicate(nums);
        System.out.println(duplicate);
        System.out.println(Arrays.toString(nums));
    }
    public static int findDuplicate(int[] nums) {
        int slow = nums[0], fast = nums[nums[0]];

        // 快慢指针找到相遇点 假设环长为 l，从起点到环的入口的步数是 a
        // 如果slow = a+c 则 fast = (a+c)*2 。c:慢指针在圆环里面走的步数
        // fast 又可以等于 a+c+k*l 。 k为遍历圆环的次数
        // 所有有 k*l = a+c => a = k*l - c 所以再慢走a步一定会回到环的路口
        while (slow != fast) {
            slow = nums[slow]; // nums.next()
            fast = nums[nums[fast]]; // nums.next().next()
        }

        // 再慢走a步一定会回到环的路口
        fast = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
