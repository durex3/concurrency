package com.durex.concurrency.example.singleton;

import com.durex.concurrency.annotations.ThreadSafe;

/**
 * 饿汉模式
 * 类装载时创建
 */
@ThreadSafe
public class SingletonExample6 {

    private SingletonExample6() {}

    private static SingletonExample6 instance = null;

    static {
        instance = new SingletonExample6();
    }

    public static SingletonExample6 getInstance() {
        return instance;
    }
}
