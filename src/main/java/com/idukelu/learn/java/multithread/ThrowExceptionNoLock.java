package com.idukelu.learn.java.multithread;

import org.junit.jupiter.api.Test;

/**
 *
 */
public class ThrowExceptionNoLock {

    @Test
    public void test() throws InterruptedException {
        ThrowExceptionNoLock throwExceptionNoLock = new ThrowExceptionNoLock();
        Thread threadA = new Thread(throwExceptionNoLock::methodA, "Thread-A");
        Thread threadB = new Thread(throwExceptionNoLock::methodA, "Thread-B");

        threadA.start();

        // 确保线程 B 后启动，保证线程 A 先抢到锁
        Thread.sleep(500);
        threadB.start();
        while (true) {
            // test 线程和 main 线程不一样，
            // test 线程退出后，其他线程也跟着退出了
            // test 线程退出后，其他线程执行完后才会退出
        }
    }

    private synchronized void methodA() {
        if ("Thread-A".equals(Thread.currentThread().getName())) {
            for (int i = 0; i < 1000; i++) {
                System.err.println(Thread.currentThread().getName() + " is running....");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // 5 s 后抛出异常，迫使线程释放锁
                if (i == 50) {
                    int j = 1/0;
                }
            }
        } else {
            for (int i = 0; i < 100; i++) {
                System.err.println(Thread.currentThread().getName() + " is running....");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
