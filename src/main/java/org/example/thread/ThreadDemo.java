package org.example.thread;

public class ThreadDemo extends Thread{

    @Override
    public void run() {
        System.out.println("thread  run");
        for (int i = 0; i < 20; i++){
            try {
                Thread.sleep(1000);
                System.out.println("i : "+i);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
