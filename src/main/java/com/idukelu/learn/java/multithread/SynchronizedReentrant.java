package com.idukelu.learn.java.multithread;

import org.junit.jupiter.api.Test;

/**
 * synchronized 锁重入：获取锁的线程可以在不释放锁的情况下，再次获取自己拿到的锁
 * 锁重入：
 *  线程 X 执行 methodA 获取了对象锁 S
 *  调用 methodB 时，线程 X 再次获取已将持有的锁 S 即可，调用 methodB 时也是如此
 *
 * 无锁重入：（形成死锁、阻塞）
 *  如果没有锁重入，线程 X 执行 methodA 获取了对象锁 S
 *  调用 methodB 时还需要锁 S，这时就会导致线程 X 无法再次获取锁 S，最终造成死锁和阻塞
 */
public class SynchronizedReentrant {

    @Test
    public synchronized void methodA() {
        System.err.println("methodA 执行了。。。");
        methodB();
    }

    public synchronized void methodB() {
        System.err.println("methodB 执行了。。。");
        methodC();
    }

    public synchronized void methodC() {
        System.err.println("methodC 执行了。。。");
    }
}
