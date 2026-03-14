package com.example.windowSlide.不定长滑动窗口;

public class 每个字符最多出现两次的最长子字符串 {
    public int maximumLengthSubstring(String s) {
        char[] chars = s.toCharArray();
        int len = s.length();
        int[] ans = new int[26];
        int left = 0;
        int max = 0;
        for (int i = 0; i < len; i++) {
            int index = chars[i] - 'a';
            ans[index]++;
            while (ans[index] > 2) {
                ans[chars[left] - 'a']--;
                left++;
            }
            max = Math.max(max, i - left);
        }

        return max + 1;
    }

}
