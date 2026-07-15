package com.example.LeetCode75.字符串和数组;

public class 压缩字符串 {

    public static void main(String[] args) {
        char[] chars = new char[] {'a', 'a'};
        int compress = compress(chars);
        System.out.println(compress);
    }

    public static int compress(char[] chars) {
        int index = 0;
        int count = 1;
        char cut = chars[index];
        int len = chars.length;
        for (int i = 1; i < len; i++) {
            char c = chars[i];
            if (cut != c) {
                chars[index++] = cut;
                if (count > 1) {
                    String s = String.valueOf(count);
                    for (char c1 : s.toCharArray()) {
                        chars[index++] = c1;
                    }
                }
                count = 1;
                cut = c;
            } else {
                count++;
            }
        }

        chars[index++] = cut;
        if (count > 1) {
            String s = String.valueOf(count);
            for (char c1 : s.toCharArray()) {
                chars[index++] = c1;
            }
        }
        return index;
    }
}
