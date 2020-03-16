## 什么是回调函数？
这里参考了[知乎上 no.body 提供回答](https://www.zhihu.com/question/19801131/answer/27459821)，很好的为我们解答了关于回调函数的问题。

1. 编程分类：
- 系统编程（system programming）
- 应用编程（application programming）

2. 理解回调
回调：即 应用层方法 调用 系统层方法，系统层方法 又调用 应用层方法。这种形式的调用链的就像一个钩子，故回调函数也被称为钩子函数，简称钩子。

3. 回调函数：
- 起始方法：应用程序中的方法 appMethodA()
- 中间方法：系统程序中的方法 appMethodB()
- 回调方法：应用程序中的方法 appMethodC()

appMethodA() 调用 appMethodB() 时，将 appMethodC() 作为参数，则 appMethodC() 便为回调函数
回调函数由用户提供，是一种定制化的体现

4. 回调函数分类
根据调用回调函数时，调用方式的不同，可分为：
- 同步回调（阻塞回调）；整个调用过程同一个线程完成，即同步完成每个函数的调用
- 异步回调（延迟回调）：整个调用过程多个线程完成，即在中间方法调用回调函数的时候，开启一个新的线程去执行调用

即划分原则为：调用回调函数时，是同步调用还是异步调用
