package com.example.数组;

public class H指数 {

    public static void main(String[] args) {
        int[] arr = new int[] {7, 7, 9, 5, 5, 10};
        System.out.println(hIndex(arr));
    }

    public static int hIndex(int[] citations) {
        int max = 0;
        for (int num : citations) {
            max = Math.max(max, num);
        }
        int[] ans = new int[max + 1];
        for (int num : citations) {
            ans[num]++;
        }
        int count = citations.length;
        int len = ans.length;
        for (int i = 0; i < len; i++) {
            int c = ans[i];

            if (count == i) {
                return i;
            }

            count -= c;

            if (count < i) {
                return Math.min(i, count + c);
            } else if (count == i) {
                return i;
            }
        }

        return count;
    }
}
