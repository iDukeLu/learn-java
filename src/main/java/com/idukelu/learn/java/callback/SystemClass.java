package com.idukelu.learn.java.callback;

public class SystemClass {

    /**
     * 中间函数
     * @param callback 回调函数接口
     */
    public void middleMethod(Callback callback) {
        callback.callbackMethod();
    }
}
