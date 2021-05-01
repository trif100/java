package com.company.bank;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account implements Transfer {
    private static final long LIMIT = 50000000;
    private static int count = 0;
    Lock lock = new ReentrantLock();
    private final String accountOwner;
    private final long accountNumber;
    private long amount;

    public Account(String accountOwner) {
        this.accountOwner = accountOwner;
        accountNumber = setAccountNumber();
        amount = (long) (Math.random() * LIMIT) + LIMIT;
    }

    public static long setAccountNumber() {
        return ++count;
    }

    @Override
    public void makeTransfer(Account account) {
        long transferAmount = Helper.getRandomAmountToTransfer();
        try {
            if (Helper.getLocks(this.lock, account.getLock())) {
                MoneyTransfer moneyTransfer = new MoneyTransfer(this, account, transferAmount);
                DataHolder.addTransfer(moneyTransfer);
                if (transferAmount <= amount && transferAmount > 0) {
                    amount -= transferAmount;
                    account.setAmount(getAmount() + transferAmount);
                    System.out.println("Transfer carried out successfully");
                } else {
                    System.out.println("Transfer FAILED!");
                }
                this.lock.unlock();
                account.getLock().unlock();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public Lock getLock() {
        return lock;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber=" + accountNumber +
                ", accountOwner='" + accountOwner + '\'' +
                ", amount=" + amount +
                '}';
    }
}