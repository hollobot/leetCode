package com.example.heap;

import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        // Queue<Integer> queue = new PriorityQueue((a,b)-> a - b);
        Queue<Integer> queue = new PriorityQueue<>((a, b) -> a - b);
    }


    public int lastStoneWeight(int[] stones) {
        Queue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        for (int num : stones) {
            queue.offer(num);
        }

        while (queue.size() > 1) {
            int sum = (queue.poll() - queue.poll());
            queue.offer(Math.abs(sum));
        }
        return queue.peek();
    }
}
