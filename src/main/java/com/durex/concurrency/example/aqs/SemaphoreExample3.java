package com.durex.concurrency.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

@Slf4j
public class SemaphoreExample3 {

    private static int threadCount = 20;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i < threadCount; i++) {
            final int threadNum = i;
            executorService.execute(() -> {
                try {
                    // 尝试获取一个许可
                    if (semaphore.tryAcquire()) {
                        test(threadNum);
                        // 释放一个许可
                        semaphore.release();
                    }
                } catch (InterruptedException e) {
                   log.error("exception", e);
                }
            });
        }
        executorService.shutdown();
    }

    private static void test(int threadCount) throws InterruptedException {
        log.info("{}", threadCount);
        Thread.sleep(1000);
    }
}
