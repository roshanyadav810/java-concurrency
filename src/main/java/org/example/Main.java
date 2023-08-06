package org.example;

import org.example.thread.RunnableDemo;
import org.example.thread.ThreadDemo;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("Main method");

//        ThreadDemo t1 = new ThreadDemo();
//
//        t1.start();
        RunnableDemo r = new RunnableDemo();
        Thread t1 = new Thread(r,"t1");

        Thread t2 = new Thread(r,"t2");

        Thread t3 = new Thread(r,"t3");

        t1.start();

        t2.start();

        t3.start();

//        t1.join();

//        for (int i = 0; i < 5; i++){
//            System.out.println(String.format("name %s , i %d",Thread.currentThread().getName(),i));
//        }

    }
}