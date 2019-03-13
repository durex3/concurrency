package com.durex.concurrency.example.atomic;

import com.durex.concurrency.annotations.ThreadSafe;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReference;

@Slf4j
@ThreadSafe
public class AtomicExample5 {
    @Getter
    private volatile int count = 100;
    private static AtomicIntegerFieldUpdater<AtomicExample5> updater = AtomicIntegerFieldUpdater.newUpdater(AtomicExample5.class, "count");


    public static void main(String[] args) {
        AtomicExample5 atomicExample5 = new AtomicExample5();

        if (updater.compareAndSet(atomicExample5, 100, 200)) {
            log.info("update success 1, {}", atomicExample5.getCount());
        }
        if (updater.compareAndSet(atomicExample5, 100, 200)) {
            log.info("update success 2, {}", atomicExample5.getCount());
        } else {
            log.info("update failed, {}", atomicExample5.getCount());
        }
    }
}
