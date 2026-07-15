package com.example.LeetCode75.字符串和数组;

public class 字符串的最大公因子 {

    public static void main(String[] args) {
        System.out.println(new 字符串的最大公因子().gcdOfStrings("ABCABC", "ABC"));
    }

    private int l1, l2, min, max;

    public String gcdOfStrings(String str1, String str2) {
        l1 = str1.length();
        l2 = str2.length();
        min = l1;
        max = l2;
        if (l1 > l2) {
            min = l2;
            max = l1;
        }

        if (!str1.substring(0, min).equals(str2.substring(0, min))) {
            return "";
        }

        int maxIndex = 0;
        for (int i = 1; i <= min; i++) {
            if (check(str1, str2, i, str1.substring(0, i))) {
                maxIndex = Math.max(maxIndex, i);
            }
        }

        return str1.substring(0, maxIndex);
    }

    public boolean check(String str1, String str2, int step, String s) {
        if (l1 % step != 0 || l2 % step != 0) {
            return false;
        }

        for (int i = 0; i < max; i += step) {
            if (i < l1 && !str1.substring(i, i + step).equals(s)) {
                return false;
            }

            if (i < l2 && !str2.substring(i, i + step).equals(s)) {
                return false;
            }
        }

        return true;
    }
}
