package com.example.dp.最大子数组和;

import java.util.HashMap;
import java.util.Map;

public class 找到最大开销的子字符串 {

    public static void main(String[] args) {
        int[] a = new int[] {-1,-1,-1};
        maximumCostSubstring("abc", "abc", a);
    }

    public static int maximumCostSubstring(String s, String chars, int[] vals) {
        Map<Character, Integer> map = new HashMap();
        int len = chars.length();
        for (int i = 0; i < len; i++) {
            map.put(chars.charAt(i), vals[i]);
        }

        for (int i = 'a'; i <= 'z'; i++) {
            map.put((char)i, map.getOrDefault((char)i, i - 'a' + 1));
        }

        int size = s.length();
        int d = 0, p = Integer.MIN_VALUE;
        for (int i = 0; i < size; i++) {
            d = Math.max(d, 0) + map.get(s.charAt(i));
            p = Math.max(d, p);
        }

        return p;
    }
}
