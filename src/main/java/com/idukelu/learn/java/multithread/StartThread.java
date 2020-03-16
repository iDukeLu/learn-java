package com.idukelu.learn.java.multithread;

import org.junit.jupiter.api.Test;

public class StartThread {

    /**
     * 创建线程：
     * - 继承 Thread 类
     * - 实现 Runnable 接口
     *
     * 启动线程:
     * 调用 start() 方法后，线程会进入就绪状态，等待线程调度器分配线程调用 run() 方法
     */
    @Test
    public void startThread () {
        // 三种方式
        new Thread1().start();
        new Thread(new Thread1()).start();
        new Thread(new Thread2()).start();
    }
}

/**
 * 继承 Thread 类
 */
class Thread1 extends Thread {

    @Override
    public void run() {
        System.err.println("当前线程：Thread1");
    }
}

/**
 * 实现 Runnable 接口
 */
class Thread2 implements Runnable {

    @Override
    public void run() {
        System.err.println("当前线程：Thread2");
    }
}
