package com.idukelu.learn.java.multithread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Demo3 {

    public static void main(String[] args) {
        new ThreadPoolExecutor(5, 50, 3, TimeUnit.SECONDS, new ArrayBlockingQueue(100), new ThreadPoolExecutor.CallerRunsPolicy());
    }
}
