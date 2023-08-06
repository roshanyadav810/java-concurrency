package org.example.thread;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {

    private static CountDownLatch countDownLatch = new CountDownLatch(1);

    private static int number;
    public static void main(String[] args) throws InterruptedException {
        Thread t1 =  new Thread(()->{
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            number = new Random().nextInt();
            System.out.println(String.format("thread name %s is running , number : %d",Thread.currentThread().getName(),number));
            countDownLatch.countDown();
        } , "Initializer");

        t1.start();

        System.out.println(String.format("thread name %s is running number : %d",Thread.currentThread().getName(),number));

        countDownLatch.await();

        System.out.println(String.format("thread name %s is running number : %d",Thread.currentThread().getName(),number));

    }
}
