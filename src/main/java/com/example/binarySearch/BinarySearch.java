package com.example.binarySearch;

import org.junit.Test;

public class BinarySearch {

    public static void main(String[] args) {
        int[] nums = {1,3,5};
        System.out.println(new BinarySearch().search(nums,3));
    }

    public int search(int[] nums, int target) {
        int len = nums.length;
        int l = 0,r = len-1;
        // 查找旋转位置
        int maxIndex = maxIndex(nums);
        if(nums[0]>target){
            l = maxIndex;
        }else{
            r = maxIndex;
        }
        return pointsSearch(nums,l,r,target);
    }

    // 查询旋转排序数组的最大值 {4,5,6,7,0,1,2}，{1,2,3,4}
    public int maxIndex(int[] nums){
        int len = nums.length-1;
        int l = 0,r = len;
        if(nums[l]<nums[r]) return r;
        while(l+1<r){
            int mid = (l+r)>>>1; // 除2
            if(nums[mid]<nums[len]){
                r = mid-1;
            }else{
                l = mid;
            }
        }
        return r;
    }

    // 二分查找
    public int pointsSearch(int[] nums,int l,int r,int target){
        while(l<=r){
            int mid = (l+r)>>>1;
            if(nums[mid]>target){
                r = mid-1;
                continue;
            }else if(nums[mid]<target){
                l = mid+1;
                continue;
            }
            return mid;
        }
        return -1;
    }



    @Test
    public void fun01() {
        int[] nums1 = {};
        int[] nums2 = {1};
        System.out.println(new BinarySearch().findMedianSortedArrays(nums1,nums2));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int num1 = 0, num2 = 0;
        int index1 = 0, index2 = 0;
        int index = ((len1 + len2 - 1) >>> 1) + 1;
        int count = 0;
        while (count <= index && (index1 < len1 || index2 < len2)) {
            if (index2 >= len2 || (index1 < len1 && nums1[index1] <= nums2[index2])) {
                // 第一个数组移动
                num1 = num2;
                num2 = nums1[index1++];
                count++;
                continue;

            }

            if (index1 >= len1 || (index2 < len2 && nums1[index1] > nums2[index2])) {
                // 第二个数组移动
                num1 = num2;
                num2 = nums2[index2++];
                count++;
            }
        }

        if (((len1 + len2) & 1) == 0) {
            return (float) (num1 + num2) / 2;
        }
        return num1;
    }
}
