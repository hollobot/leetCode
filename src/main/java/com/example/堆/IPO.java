package com.example.堆;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class IPO {

    public static void main(String[] args) {
        IPO ipo = new IPO();
        ipo.findMaximizedCapital(2, 0, new int[] {1, 2, 3}, new int[] {0, 1, 1});
    }

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int len = profits.length;
        int[][] tab = new int[len][2];
        for (int i = 0; i < len; i++) {
            tab[i][0] = profits[i];
            tab[i][1] = capital[i];
        }
        Arrays.sort(tab, (a, b) -> a[1] - b[1]);

        int index = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(k, (a, b) -> b[0] - a[0]);
        for (int i = 0; i < k; i++) {
            while (index < len && w >= tab[index][1]) {
                pq.add(tab[index]);
                index++;
            }
            if (!pq.isEmpty()) {
                w += pq.poll()[0];
            }else{
                break;
            }
        }

        return w;
    }
}
