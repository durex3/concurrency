package com.durex.concurrency.example.singleton;

import com.durex.concurrency.annotations.NotRecommend;
import com.durex.concurrency.annotations.ThreadSafe;

/**
 * 懒汉模式
 * 在第一次使用时创建
 */
@ThreadSafe
@NotRecommend
public class SingletonExample3 {

    private SingletonExample3() {}

    private static SingletonExample3 instance = null;

    public static synchronized SingletonExample3 getInstance() {
        if (instance == null) {
            instance = new SingletonExample3();
        }
        return instance;
    }
}
