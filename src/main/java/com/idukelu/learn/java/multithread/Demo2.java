package com.idukelu.learn.java.multithread;

public class Demo2 {

    private static int ticket = 100;

    public static void sell() {
        while (ticket > 0) {
            int i = ticket--;
            System.err.println(Thread.currentThread().getName() + ": " + i);
        }
    }

    public static void main(String[] args) {
        Thread seller1 = new Thread(Demo2::sell);
        Thread seller2 = new Thread(Demo2::sell);
        seller1.start();
        seller2.start();
    }
}
