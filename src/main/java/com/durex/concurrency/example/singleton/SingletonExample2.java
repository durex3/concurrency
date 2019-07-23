package com.durex.concurrency.example.singleton;

import com.durex.concurrency.annotations.ThreadSafe;

/**
 * 饿汉模式
 * 类装载时创建
 */
@ThreadSafe
public class SingletonExample2 {

    private SingletonExample2() {}

    private static SingletonExample2 instance = new SingletonExample2();

    public static SingletonExample2 getInstance() {
        return instance;
    }
}
