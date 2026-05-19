package com.example.滑动窗口;

import java.util.*;

public class 串联所有单词的子串 {

    public static void main(String[] args) {
        String s = "wordgoodgoodgoodbestword";
        String[] words = {"word","good","best","good"};

        new 串联所有单词的子串().findSubstring(s, words);

    }

    public List<Integer> findSubstring(String s, String[] words) {

        Map<String, Integer> target = new HashMap<>();
        for (String w : words) {
            target.put(w, target.getOrDefault(w, 0) + 1);
        }

        List<Integer> ans = new ArrayList<>();
        int wordSize = words[0].length();
        int windowLen = wordSize * words.length;
        for (int start = 0; start < wordSize; start++) {
            Map<String, Integer> cut = new HashMap<>();
            int flag = 0;
            for (int r = start + wordSize; r <= s.length(); r += wordSize) {
                String str = s.substring(r - wordSize, r);
                if (cut.getOrDefault(str, 0).equals(target.getOrDefault(str, 0))) {
                    flag++;
                }
                cut.put(str, cut.getOrDefault(str, 0) + 1);
                int l = r - windowLen;
                if (l < 0) {
                    continue;
                }

                if (flag == 0) {
                    ans.add(l);
                }

                str = s.substring(l, l + wordSize);
                cut.put(str, cut.get(str) - 1);
                if (cut.get(str).equals(target.getOrDefault(str, 0))) {
                    flag--;
                }
            }
        }
        return ans;
    }

}
