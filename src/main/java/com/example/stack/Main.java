package com.example.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        longestValidParentheses("(()");

    }



    public static int longestValidParentheses(String s) {
        Deque<Integer> deque = new ArrayDeque();
        int len = s.length();
        int max = 0;
        for(int i=0;i<len;i++){
            char c = s.charAt(i);
            if(c == '('){
                deque.push(i);
                continue;
            }
            if(deque.isEmpty()){
                deque.push(i);
                continue;
            }
            int index = deque.peek();
            if(s.charAt(index)=='('){
                deque.pop();
                index = -1;
                if(!deque.isEmpty()){
                    index = deque.peek();
                }
                max = Math.max(max,i-index);
                continue;
            }

            deque.push(i);
        }

        return max;
    }

    public String decodeString(String s) {
        Stack<String> stack = new Stack();
        StringBuffer str = new StringBuffer();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);

            if (c == ']') {

            }
            stack.push(c + "");
        }

        return null;
    }

    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Deque<Integer> st = new ArrayDeque<>();
        st.push(-1); // 在栈中只有一个数的时候，栈顶的「下面那个数」是 -1，对应 left[i] = -1 的情况
        int ans = 0;
        for (int right = 0; right <= n; right++) {
            int h = right < n ? heights[right] : -1;
            while (st.size() > 1 && heights[st.peek()] >= h) {
                int i = st.pop(); // 矩形的高（的下标）
                int left = st.peek(); // 栈顶下面那个数就是 left
                ans = Math.max(ans, heights[i] * (right - left - 1));
            }
            st.push(right);
        }
        return ans;
    }

    /**
     * 快速排序
     */
    class Quick {
        public static void quickSort(int[] arr, int left, int right) {
            if (left >= right) {
                return;
            }
            int index = partition(arr, left, right);
            quickSort(arr, left, index - 1);
            quickSort(arr, index + 1, right);
        }

        /**
         * 划分函数 2、4、1、0、3、5
         *
         * @param arr 原数组
         * @param left 左边界
         * @param right 有边界
         * @return 划分点
         */
        public static int partition(int[] arr, int left, int right) {
            int i = left, j = right;
            while (i <= j) {
                while (i <= j && arr[j] >= arr[left]) {
                    j--;
                }
                while (i <= j && arr[i] <= arr[left]) {
                    i++;
                }
                swap(arr, i, j);
            }
            swap(arr, left, i);
            return i;
        }

        public static void swap(int[] arr, int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

}

