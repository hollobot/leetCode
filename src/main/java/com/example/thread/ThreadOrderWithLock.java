package com.example.thread;

public class ThreadOrderWithLock {
    // 共享锁对象
    private static final Object lock = new Object();
    // 标志位：控制当前该哪个线程执行（1: t1，2: t2，3: t3）
    private static int flag = 1;

    public static void main(String[] args) {
        // 线程1：打印A，完成后将标志位设为2
        Thread t1 = new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    try {
                        // 若标志位不是1，等待
                        while (flag != 1) {
                            lock.wait();
                        }
                        System.out.println("A");
                        flag = 2; // 切换到线程2
                        lock.notifyAll(); // 唤醒其他等待线程
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        });

        // 线程2：打印B，完成后将标志位设为3
        Thread t2 = new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    try {
                        while (flag != 2) {
                            lock.wait();
                        }
                        System.out.println("B");
                        flag = 3; // 切换到线程3
                        lock.notifyAll();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        });

        // 线程3：打印C，完成后将标志位设为1（可选）
        Thread t3 = new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    try {
                        while (flag != 3) {
                            lock.wait();
                        }
                        System.out.println("C");
                        flag = 1; // 切换到线程1
                        lock.notifyAll();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        // 启动顺序不影响执行顺序（由标志位控制）
        t3.start();
        t1.start();
        t2.start();
    }
}