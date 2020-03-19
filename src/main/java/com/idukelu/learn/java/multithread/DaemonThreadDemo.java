package com.idukelu.learn.java.multithread;

/**
 * 守护线程演示：
 *  1. 主线程：模拟基础线程，循环不停止
 *  2. 线程 U：用户线程，处理一些业务
 *  3. 线程 D：守护线程，清理一些内存垃圾
 *  当所有非守护线程销毁停止后，守护线程会自动的进行销毁停止
 *  这里主要有两个非守护线程 主线程 TheadM 和 自定义的用户线程 ThreadU，一个守护线程 ThreadD，
 *  仅当 TheadM、ThreadU 均停止了，ThreadD 才会停止
 */
public class DaemonThreadDemo {

    public static void main(String[] args) throws InterruptedException {

        // 主线程 M
        Thread threadM = Thread.currentThread();

        // 用户线程 U
        Thread threadU = new Thread(
                () -> {
                    for (int i = 0; i < 10; i++) { // 打印 10 条，保证用户线程比守护线程先停止
                        System.err.println(i + ": 我是用户线程 U，正在疯狂处理业务逻辑。。。");
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                },
                "User-Thread-U");

        // 守护线程 D
        Thread threadD = new Thread(
                () -> {
                    for (int i = 0; i < 100; i++) { // 打印 100 条，保证守护线程比用户线程后停止
                        System.err.println(i + ": 我是守护线程 D，帮助用户线程清理一些内存垃圾。。。"
                                + "用户线程状态：（" + threadM.getName() + ": " + threadM.isAlive() + "；"
                                + threadU.getName() + ": " + threadU.isAlive() + "）");
                        System.err.println();
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                },
                "Daemon-Tread-D");

        // 启动线程
        threadD.setDaemon(true);
        threadD.start();
        threadU.start();
    }
}
