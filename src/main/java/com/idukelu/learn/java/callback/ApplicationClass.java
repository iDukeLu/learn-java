package com.idukelu.learn.java.callback;

public class ApplicationClass {

    /**
     * 起始函数
     */
    public void startMethod() {
        // 调用系统层的中间函数，并将回调函数传入，系统的中间函数便会调用这个传入的函数
        new SystemClass().middleMethod(() -> System.err.println("调用回调函数成功！！！"));
    }

    public static void main(String[] args) {

        // 1. 起始函数（应用层）：startMethod()
        // 2. 中间函数（系统层）：middleMethod(callbackMethod())
        // 3. 回调函数（应用层）：callbackMethod()
        // 调用链说明：
        // startMethod() -------------|
        //                     middleMethod(callbackMethod())
        // callbackMethod() ----------|
        new ApplicationClass().startMethod();
    }
}
