package org.example.domain;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    private final Lock lock;

    public Lock getLock() {
        return lock;
    }

    public int getBalance() {
        return balance;
    }

    private int balance;

    public BankAccount() {
        this.balance = 0;
        this.lock = new ReentrantLock();
    }

    public BankAccount(int balance,boolean fairness) {
        this.balance = balance;
        this.lock = new ReentrantLock(fairness);
    }

    public void debit(int amount){
        this.balance = this.balance - amount;
    }

    public void credit(int amount){
        this.balance = this.balance + amount;
    }

}
