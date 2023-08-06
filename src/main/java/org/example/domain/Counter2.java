package org.example.domain;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter2 {
    private int value = 0;
    private final Lock lock = new ReentrantLock(Boolean.TRUE);

    public void increament(){
        lock.lock();
        try{
            value++;
        }finally {
            lock.unlock();
        }

    }

    public int getValue(){
        return value;
    }
}
