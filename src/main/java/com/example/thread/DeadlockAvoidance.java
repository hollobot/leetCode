package com.example.thread;

/**
 * 死锁避免示例
 */
public class DeadlockAvoidance {
    private final Object lock1 = new Object();
    private final Object lock2 = new Object();

    // ❌ 可能导致死锁
    public void method1() {
        synchronized (lock1) {
            synchronized (lock2) {
                // 业务逻辑
            }
        }
    }

    public void method2() {
        synchronized (lock2) {
            synchronized (lock1) {
                // 业务逻辑
            }
        }
    }

    // ✅ 正确做法：统一锁的获取顺序
    public void safeMethod1() {
        synchronized (lock1) {
            synchronized (lock2) {
                // 业务逻辑
            }
        }
    }

    public void safeMethod2() {
        synchronized (lock1) { // 保持相同顺序
            synchronized (lock2) {
                // 业务逻辑
            }
        }
    }
}