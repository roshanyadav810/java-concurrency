package org.example.thread;

import org.example.domain.Counter;
import org.example.domain.Counter2;

public class ReentrantLockDemo {
    public static void  main(String[] args) throws InterruptedException {
        System.out.println("ReentrantLockDemo");

        Counter2 counter = new Counter2();

        Runnable r  =  ()->{
            for (int i = 0; i < 1000; i++){
                System.out.println(String.format(" name : %s , i : %d",Thread.currentThread().getName(),i));
                counter.increament();
//                System.out.println(String.format(" name : %s , i : %d",Thread.currentThread().getName(),;));
            }
        };

        Thread t1 = new Thread(r, "T1");

        Thread t2 = new Thread(r, "T2");

        Thread t3 = new Thread(r, "T3");

        t1.start();

//

        t2.start();

//

        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println("counter : "+counter.getValue());
    }
}
