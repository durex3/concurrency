package com.durex.concurrency.example.singleton;

import com.durex.concurrency.annotations.NotThreadSafe;

/**
 * 懒汉模式
 * 在第一次使用时创建
 */
@NotThreadSafe
public class SingletonExample4 {

    private SingletonExample4() {}

    private static SingletonExample4 instance = null;

    public static SingletonExample4 getInstance() {
        if (instance == null) {
            synchronized (SingletonExample4.class) {
                if (instance == null) {
                    instance = new SingletonExample4();
                }
            }
        }
        return instance;
    }
}
