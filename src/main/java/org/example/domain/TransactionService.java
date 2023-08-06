package org.example.domain;

public class TransactionService {
    private static final long maxTransactionTime = 100*1000;
    public boolean transfer(BankAccount fromAccount , BankAccount toAccount , int amount) throws InterruptedException {
        System.out.println("transfer amount is running");

        long currentTime =  System.currentTimeMillis();

        long tryTime = currentTime+maxTransactionTime;

        while (System.currentTimeMillis() < tryTime){
            if(fromAccount.getLock().tryLock()){
                try{
                    if(toAccount.getLock().tryLock()){
                        try {
                            if(fromAccount.getBalance() - amount < 0){
                                throw new RuntimeException("Insufficient balance");
                            }
                            fromAccount.debit(amount);
                            toAccount.credit(amount);
                            return true;
                        }
                        finally {
                            toAccount.getLock().unlock();
                        }
                    }
                }
                finally {
                    fromAccount.getLock().unlock();
                }
            }
            Thread.sleep(10);
        }
        return false;
    }
}
