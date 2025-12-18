package com.example.sort;

/**
 * 归并排序
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {5, 4, 1, 8, 3, 1, 6, -7};

        mergeSort(arr, 0, arr.length - 1);

        for(int i = 0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }

    /* 归并 */
    public static void merge(int[] arr, int left, int mid, int right) {
        // 创建临时数组
        int[] temp = new int[right - left + 1];
        // 初始化数据
        int i = left, j = mid + 1, k = 0;
        /* 归并排序 */
        while (i <= mid && j <= right) {
            if(arr[i]<arr[j]){
                temp[k++] = arr[i++];
            }else{
                temp[k++] = arr[j++];
            }
        }
        // 处理左剩余元素
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        // 处理右剩余元素
        while (j <= right) {
            temp[k++] = arr[j++];
        }
        // 赋值
        for(k=0;k<temp.length;k++){
            arr[left + k] = temp[k];
        }
    }

    /* 归并排序 */
    public static void mergeSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        // 递归左半部分
        mergeSort(arr, start, mid);
        // 递归右半部分
        mergeSort(arr, mid + 1, end);
        // 合并
        merge(arr, start, mid, end);
    }

}
