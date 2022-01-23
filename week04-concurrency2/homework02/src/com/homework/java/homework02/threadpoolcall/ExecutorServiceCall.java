package com.homework.java.homework02.threadpoolcall;

import com.homework.java.homework02.CalculateResult;

import java.security.PrivilegedExceptionAction;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Executors 线程池的各种创建以及runable的各种实现不再组合
 *
 * @author qiuch
 */
public class ExecutorServiceCall {

  //    Executors e = Executors.callable()
  ExecutorService executorService = Executors.newFixedThreadPool(1);

  public int executorServiceCall() {
    AtomicInteger result = new AtomicInteger();
    executorService.execute(() -> result.set(CalculateResult.sum()));
    executorService.shutdown();
    try {
      while (!executorService.awaitTermination(100, TimeUnit.MILLISECONDS)) {}

    } catch (InterruptedException e) {
      executorService.shutdownNow();
    }
    return result.get();
  }

  public Object executorsCallableCall() {

    Future<Object> future =
        executorService.submit(
            Executors.callable((PrivilegedExceptionAction) CalculateResult::sum));
    try {
      return future.get(1000, TimeUnit.MILLISECONDS);
    } catch (InterruptedException | TimeoutException | ExecutionException e) {
      return 0;
    }
  }
}
