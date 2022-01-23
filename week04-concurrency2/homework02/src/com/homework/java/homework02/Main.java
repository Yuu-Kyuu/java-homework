package com.homework.java.homework02;

import com.homework.java.homework02.threadpoolcall.ExecutorServiceCall;

public class Main {

  public static void main(String[] args) {

    long start = System.currentTimeMillis();

    // 在这里创建一个线程或线程池，
    // 异步执行 下面方法
    // 这是得到的返回值
    //    int result = new ThreaddAnonymousCall().threadStart();
    //    int result = new SubClassExtendsThreadCall().extendThread();
    //    int result = new RunnableImplCall().threadStart();
    //    int result = new CallableImplCall().threadStart();
    //    int result = new ExecutorServiceCall().executorServiceCall();
    Object result = new ExecutorServiceCall().executorsCallableCall();
    // 确保  拿到result 并输出
    System.out.println("异步计算结果为：" + result);

    System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");

    // 然后退出main线程
  }
}
