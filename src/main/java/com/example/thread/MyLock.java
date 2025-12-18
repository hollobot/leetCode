package com.example.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyLock extends Thread {
    // 仓库剩余票数
    private static int ticket = 100;

    // 使用 ReentrantLock 替代 synchronized
    private static Lock lock = new ReentrantLock();

    public MyLock(String name,int level){
        super(name); // 设置线程名称
        super.setPriority(level); // 设置线程优先级
    }

    public static void main(String[] args) {
        new MyLock("小明",1).start();
        new MyLock("小红",1).start();
        new MyLock("小绿",1).start();
    }


    @Override
    public void run() {
        while(true){
            lock.lock(); // 上锁
            try {
                Thread.sleep(10);
                if(ticket>0){
                    Thread currentThread =  Thread.currentThread();
                    System.out.println(currentThread.getName()+":"+ticket--+"张票");
                }else{
                    break;
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }finally {
                lock.unlock(); // 确保解锁操作一定会执行
            }

        }
    }
}
