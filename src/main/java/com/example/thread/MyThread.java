package com.example.thread;

/**
 * 多线程买票程序
 */
public class MyThread extends Thread{

    // 仓库剩余票数
    private static int ticket = 100;

    public MyThread(String name,int level){
        super(name); // 设置线程名称
        super.setPriority(level); // 设置线程优先级
    }

    public static void main(String[] args) {
        new MyThread("小明",1).start();
        new MyThread("小红",1).start();
        new MyThread("小绿",1).start();
    }


    @Override
    public void run() {
        while(ticket>0){
            // 同步代码块 synchronized 传入的锁需要是唯一的
            synchronized (MyThread.class) {
                if(ticket>0){
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    Thread currentThread =  Thread.currentThread();
                    System.out.println(currentThread.getName()+":"+ticket--+"张票");
                }
            }
        }
    }
}
