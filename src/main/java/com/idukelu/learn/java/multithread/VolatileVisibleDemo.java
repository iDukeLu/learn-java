package com.idukelu.learn.java.multithread;

/**
 * 验证 volatile 重排序
 */
public class VolatileVisibleDemo {

    static int a = 0;
    static int b = 0;
    static int c = 0;

    public static void main(String[] args) {
        while (true) {
            new Thread(VolatileVisibleDemo::write).start();
            new Thread(VolatileVisibleDemo::read).start();
            a = 0;
            b = 0;
            c = 0;
        }
    }

    static void write() {
        a = 1;
        b = 1;
        c = 1;
    }

    static void read() {
        if (b == 1 && a == 0) {
            System.err.println("b=1");
        }
        if (c == 1 && (a ==0 || b ==0)) {
            System.err.println("c=1");
        }
    }
}