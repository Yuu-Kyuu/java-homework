package com.homework.java.homework02.threadcall;

import com.homework.java.homework02.CalculateResult;

import java.util.concurrent.atomic.AtomicInteger;

public class RunnableImplCall {
  public int threadStart() {
    AtomicInteger result = new AtomicInteger();
    new Thread(new RunnableImpl(result)).start();
    while (result.get() == 0) {
      try {
        Thread.sleep(100);
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
      }
    }

    return result.get();
  }

  class RunnableImpl implements Runnable {
    AtomicInteger result;

    public RunnableImpl(AtomicInteger result) {
      this.result = result;
    }

    @Override
    public void run() {
      result.set(CalculateResult.sum());
    }
  }
}
