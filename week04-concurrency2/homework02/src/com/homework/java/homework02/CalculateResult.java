package com.homework.java.homework02;

/**
 * 线程计算结果
 *
 * @author qiuch
 */
public class CalculateResult {

  public static int sum() {
    return fib(36);
  }

  private static int fib(int index) {
    if (index < 2) {
      return 1;
    }
    return fib(index - 1) + fib(index - 2);
  }
}
