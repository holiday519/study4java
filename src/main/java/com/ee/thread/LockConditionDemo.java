package com.ee.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockConditionDemo {

    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void sharedMethod(String name) {
        lock.lock();
        for (int i=0; i<15; i++) {
            System.out.println("ThreadName=" + name
                    + ", i=" + i);
            try {
                if ("ningyu".equals(name) && i==5) {
                    condition.await();
                }
                if ("zhanglu".equals(name) && i==9) {
                    condition.signal();
                    condition.await();
                }
                if ("ningyu".equals(name) && i==14) {
                    condition.signal();
                }
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        lock.unlock();
    }

    public static void main(String[] args) throws InterruptedException {
        LockConditionDemo demo = new LockConditionDemo();
        new Thread(() -> {
            demo.sharedMethod("ningyu");
        }).start();

        Thread.sleep(1000);

        new Thread(() -> {
            demo.sharedMethod("zhanglu");
        }).start();
    }
}
