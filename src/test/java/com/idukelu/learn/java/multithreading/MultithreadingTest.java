package com.idukelu.learn.java.multithreading;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MultithreadingTest {

    @Test
    public void test () {
        startThread();
    }

    /**
     * 启动线程
     * 调用 start() 方法后，线程会进入就绪状态，等待线程调度器分配线程调用 run() 方法
     */
    public void startThread () {
        System.err.println("当前线程：" + Thread.currentThread().getName());
        new Thread1().start();
        new Thread(new Thread2()).start();
        System.err.println("当前线程：" + Thread.currentThread().getName());
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
