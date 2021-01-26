package com.idukelu.learn.java.multithread;

/**
 * 验证重排序
 *
 * @author luhongyu
 * @date 2021.01.25
 */
public class VolatileReorderDemo {

    static int a = 0;
    static int b = 0;
    static int c = 0;
    static int d = 0;
    static int e = 0;
    static int f = 0;
    static int g = 0;
    static int h = 0;
    static int i = 0;
    static int j = 0;
    static int k = 0;
    static int l = 0;
    static int m = 0;
    static int n = 0;

    public static void main(String[] args) throws InterruptedException {
        while (true) {
            Thread thread1 = new Thread(VolatileReorderDemo::write);
            Thread thread2 = new Thread(VolatileReorderDemo::read);

            thread1.start();
            thread2.start();

            thread1.join();
            thread2.join();

            restore();
        }
    }

    static void restore() {
        a = 0;
        b = 0;
        c = 0;
        d = 0;
        e = 0;
        f = 0;
        g = 0;
        h = 0;
        i = 0;
        j = 0;
        k = 0;
        l = 0;
        m = 0;
        n = 0;
    }

    static void write() {
        a = 1;
        b = 1;
        c = 1;
        d = 1;
        e = 1;
        f = 1;
        g = 1;
        h = 1;
        i = 1;
        j = 1;
        k = 1;
        l = 1;
        m = 1;
        n = 1;
    }

    static void read() {
        if (b == 1 && a == 0) {
            System.err.println("b=1");
        }
        if (c == 1 && (a ==0 || b ==0)) {
            System.err.println("c=1");
        }
        if (d == 1 && (a ==0 || b ==0 || c ==0)) {
            System.err.println("d=1");
        }
        if (e == 1 && (a ==0 || b ==0 || c ==0 || d ==0)) {
            System.err.println("e=1");
        }
        if (f == 1 && (a ==0 || b ==0 || c ==0 || d ==0)) {
            System.err.println("f=1");
        }
        if (g == 1 && (a ==0 || b ==0 || c ==0 || d ==0 || e ==0 || f ==0)) {
            System.err.println("g=1");
        }
        if (h == 1 && (a ==0 || b ==0 || c ==0 || d ==0 || e ==0 || f ==0 || g ==0 )) {
            System.err.println("h=1");
        }
        if (i == 1 && (a ==0 || b ==0 || c ==0 || d ==0 || e ==0 || f ==0 || g ==0 || h ==0)) {
            System.err.println("i=1");
        }
        if (j == 1 && (a ==0 || b ==0 || c ==0 || d ==0 || e ==0 || f ==0 || g ==0 || h ==0 || i ==0)) {
            System.err.println("j=1");
        }
        if (k == 1 && (a ==0 || b ==0 || c ==0 || d ==0 || e ==0 || f ==0 || g ==0 || h ==0 || i ==0 || j ==0)) {
            System.err.println("k=1");
        }
        if (l == 1 && (a ==0 || b ==0 || c ==0 || d ==0 || e ==0 || f ==0 || g ==0 || h ==0 || i ==0 || j ==0 || k ==0)) {
            System.err.println("l=1");
        }
        if (m == 1 && (a ==0 || b ==0 || c ==0 || d ==0 || e ==0 || f ==0 || g ==0 || h ==0 || i ==0 || j ==0 || k ==0 || l ==0)) {
            System.err.println("m=1");
        }
        if (n == 1 && (a ==0 || b ==0 || c ==0 || d ==0 || e ==0 || f ==0 || g ==0 || h ==0 || i ==0 || j ==0 || k ==0 || l ==0 || m ==0)) {
            System.err.println("n=1");
        }
    }
}
