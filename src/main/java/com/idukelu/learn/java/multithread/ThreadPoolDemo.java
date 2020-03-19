package com.idukelu.learn.java.multithread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 根据阿里巴巴 P3C，尽量不要用 Executor 创建线程池，推荐使用 ThreadPoolExecutor() 构造函数创建线程池
 *  ThreadPoolExecutor() 构造函数的几个参数：
 *  - 核心线程数
 *  - 最大线程数
 *  - 空闲线程存活时间
 *  - 时间单位
 *  - 工作队列
 *  - 无空闲线程时，新任务处理策略
 *
 * 关于无空闲线程时，新任务处理策略：
 *  - ThreadPoolExecutor.DiscardPolicy()：静默丢弃当前提交的任务
 *  - ThreadPoolExecutor.AbortPolicy()：默认策略，丢弃当前提交的任务， 并抛出 RejectedExecutionException 异常
 *  - ThreadPoolExecutor.CallerRunsPolicy()：直接使用提交任务的线程执行当前提交的任务
 *  - ThreadPoolExecutor.DiscardOldestPolicy()：丢弃最老未执行的任务，执行当前提交的任务
 */
public class ThreadPoolDemo {

    public static void main(String[] args) {
        Executor executor = new ThreadPoolExecutor(5, 50, 3, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(100), new ThreadPoolExecutor.CallerRunsPolicy());
    }
}
