package com.ee.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {
    private static Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        lock.tryLock();
    }
}
