package com.durex.concurrency.example.singleton;

import com.durex.concurrency.annotations.ThreadSafe;

/**
 * 懒汉模式
 * 在第一次使用时创建
 */
@ThreadSafe
public class SingletonExample5 {

    private SingletonExample5() {}

    // 禁止指令重排序
    private volatile static SingletonExample5 instance = null;

    public static SingletonExample5 getInstance() {
        if (instance == null) {
            synchronized (SingletonExample5.class) {
                if (instance == null) {
                    instance = new SingletonExample5();
                }
            }
        }
        return instance;
    }
}
