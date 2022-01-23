package com.homework.java.homework02.threadcall;

import com.homework.java.homework02.CalculateResult;

import java.util.concurrent.atomic.AtomicInteger;

public class SubClassExtendsThreadCall {
  public int threadStart() {
    AtomicInteger result = new AtomicInteger();
    new MyThread(result).start();
    return result.get();
  }

  static class MyThread extends Thread {
    AtomicInteger result;

    public MyThread(AtomicInteger result) {
      this.result = result;
    }

    @Override
    public void run() {
      result.set(CalculateResult.sum());
    }
  }
}
