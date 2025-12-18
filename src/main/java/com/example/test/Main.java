package com.example.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class Main {


    // 1. 初始化倒计时锁，计数为 1000
    static CountDownLatch latch = new CountDownLatch(1000);

    public static void main(String[] args) throws InterruptedException {
        new Main();

        ExecutorService executorService = Executors.newFixedThreadPool(1000);

        for (int i = 0; i < 1000; i++) {
            executorService.execute(() -> {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }finally {
                    latch.countDown();
                }
            });
        }
        latch.await();
        System.out.println(latch.getCount());
        executorService.shutdown(); // 关闭线程池（不再接受新任务）
    }

    abstract class A {

    }

    private static int num;

    public static void fun01() {
        int a;
        int b = 100;
        int c;
        if (b > 20) {
            a = 10;
        }
        //        c = a + b;
        //        System.out.println(c);
    }

    /** 异常处理 */
    public static int fun02(int a, int b) {
        try {
            System.out.println("try");
            return a + b;
        } catch (Exception e) {
            System.out.println("catch");
        } finally {
            System.out.println("finally");
        }
        System.out.println("end");
        return a;
    }

    @Test
    public void fun03() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));

        /** groupingBy 支持 任意数量的 key*/
        Map<Integer, List<Integer>> a = list.stream().collect(Collectors.groupingBy(num -> num));
        System.out.println(a);

        /** partitioningBy 只能分成 2 组 */
        Map<Boolean, List<Integer>> b = list.stream().collect(Collectors.partitioningBy(num -> num % 2 == 0));
        System.out.println(b);
    }

    public Main() {
        System.out.println("构造器执行");
        System.out.println(a);
    }

    private int a = 1;

    {
        System.out.println("代码块执行");
        System.out.println(a);
    }



    private static int b =1;

    static{
        System.out.println(b);
    }

    @Test
    public void fun04() {

    }
}
