package com.example.queue;

import org.junit.Test;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class MyPriorityQueue {


    private static PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);

    public static void main(String[] args) {
        queue = new PriorityQueue<Integer>((a,b)->b-a);
        queue.offer(1);
        queue.offer(2);
        offers(queue);

    }

    public static void offers(PriorityQueue queue) {
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }



}
