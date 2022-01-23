package com.homework.java.homework02.threadcall;

import com.homework.java.homework02.CalculateResult;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadAnonymousCall {
  public int threadStart() {
    AtomicInteger result = new AtomicInteger();
    new Thread(
            () -> {
              result.set(CalculateResult.sum());
            })
        .start();

    while (result.get() == 0) {
      try {
        Thread.sleep(100);
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
      }
    }

    return result.get();
  }
}
