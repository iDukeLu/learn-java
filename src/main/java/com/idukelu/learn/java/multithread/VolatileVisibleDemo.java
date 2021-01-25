package com.idukelu.learn.java.multithread;

/**
 * 验证 volatile 重排序
 */
public class VolatileVisibleDemo {

    static boolean flag = true;

    public static void main(String[] args) throws InterruptedException {
        new Thread(VolatileVisibleDemo::read).start();
        Thread.sleep(1000);
        new Thread(VolatileVisibleDemo::write).start();
    }

    static void write() {
        flag = false;
    }

    static void read() {
        // 读不到其他线程修改的值，从而无限循环
        while (flag) {

        }
        System.err.println("read end");
    }
}