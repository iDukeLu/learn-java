package com.idukelu.learn.java.multithread;

import org.junit.jupiter.api.Test;

import java.util.function.BiPredicate;

/**
 * 停止线程：
 * - 自然停止：run() 方法执行完后线程自动停止
 * - 暴力停止：thread.stop()
 * - 使用标识停止：thread.interrupt()（需配合异常和 sleep() 方法）
 */
public class StopThread {

    private int ticket = 10000;

    @Test
    public void interruptThread() throws InterruptedException {

    }

    @Test
    public void stopThread() throws InterruptedException {
        // 创建一个线程
        Thread thread = new Thread(() -> {
            while (ticket > 0) {
                System.err.println(Thread.currentThread().getName() + ": " + ticket--);
            }
        });

        thread.start();
        Thread.sleep(1);
        thread.stop();
        thread.interrupt();
    }


}
