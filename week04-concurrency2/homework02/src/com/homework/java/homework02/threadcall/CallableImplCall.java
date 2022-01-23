package com.homework.java.homework02.threadcall;

import com.homework.java.homework02.CalculateResult;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicInteger;

public class CallableImplCall {
  public int threadStart() {
    Callable<Integer> callable = new CallableImpl();
    FutureTask<Integer> futureTask = new FutureTask<>(callable);
    new Thread(futureTask).start();
    try {
      return futureTask.get();
    } catch (InterruptedException | ExecutionException e) {
      e.printStackTrace();
      return 0;
    }
  }

  class CallableImpl implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
      return CalculateResult.sum();
    }
  }
}
