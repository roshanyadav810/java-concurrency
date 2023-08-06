package org.example.thread;

import org.example.domain.BankAccount;
import org.example.domain.Counter2;
import org.example.domain.TransactionService;

public class ReentrantLockDemoWithTryLock {

    public static void  main(String[] args) throws InterruptedException {
        System.out.println("ReentrantLockDemoWithTryLock");
        BankAccount fromAccount = new BankAccount(1000000,true);

        BankAccount toAccount = new BankAccount(10,true);

        TransactionService transactionService = new TransactionService();

        Runnable r  =  ()->{
            try {
                System.out.println(String.format("Thread name : %s",Thread.currentThread().getName()));
                transactionService.transfer(fromAccount,toAccount,100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        Thread t1 = new Thread(r, "T1");

        Thread t2 = new Thread(r, "T2");

        Thread t3 = new Thread(r, "T3");

        t1.start();

        t2.start();

        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println("fromAccount  balance: "+fromAccount.getBalance());

        System.out.println("to Account  balance: "+toAccount.getBalance());
    }
}
