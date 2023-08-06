package org.example.thread;

public class RunnableDemo implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++){
            Thread.yield();
            System.out.println(String.format("name %s , i %d",Thread.currentThread().getName(),i));
        }
    }
}
