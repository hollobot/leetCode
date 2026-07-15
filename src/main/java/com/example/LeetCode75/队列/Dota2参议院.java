package com.example.LeetCode75.队列;

import java.util.LinkedList;
import java.util.Queue;

public class Dota2参议院 {

    public String predictPartyVictory(String senate) {
        Queue<Integer> rq = new LinkedList<>();
        Queue<Integer> dq = new LinkedList<>();
        int n = senate.length();
        for (int i = 0; i < n; i++) {
            char c = senate.charAt(i);
            if (c == 'R') {
                rq.offer(i);
            } else {
                dq.offer(i);
            }
        }

        while (!rq.isEmpty() && !dq.isEmpty()) {
            int r = rq.poll();
            int d = dq.poll();
            if (r < d) {
                rq.offer(r + n);
            } else {
                dq.offer(d + n);
            }
        }
        return !rq.isEmpty() ? "Radiant" : "Dire";
    }
}
