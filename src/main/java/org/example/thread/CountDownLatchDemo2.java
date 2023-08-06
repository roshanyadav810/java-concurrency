package org.example.thread;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo2 {

    private static CountDownLatch usercountDownLatch = new CountDownLatch(1);

    private static CountDownLatch forexcountDownLatch = new CountDownLatch(1);

    private static String userName;

    private static String forexData;
    public static void main(String[] args) throws InterruptedException {
        Thread t1 =  new Thread(()->{
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            userName = "U1"+String.valueOf(new Random().nextInt());
            System.out.println(String.format("thread name %s is running , userName : %s",Thread.currentThread().getName(),userName));
            usercountDownLatch.countDown();
        } , "User");

        Thread t2 =  new Thread(()->{
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            forexData = "Forex"+String.valueOf(new Random().nextInt());
            System.out.println(String.format("thread name %s is running , userName : %s",Thread.currentThread().getName(),forexData));
            forexcountDownLatch.countDown();
        } , "Forex");

        t1.start();

        t2.start();

        System.out.println(String.format("thread name %s is running number : %d",Thread.currentThread().getName(),number));

        forexcountDownLatch.await();

        System.out.println(String.format("thread name %s is running number : %d",Thread.currentThread().getName(),number));

    }
}
