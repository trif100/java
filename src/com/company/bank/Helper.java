package com.company.bank;

import java.util.concurrent.locks.Lock;

public class Helper {
    public static long getRandomAmountToTransfer() {
        int limit = 50000000;
        long amount = (long) (Math.random() * limit);
        return amount;
    }

    public static Account getRandomAccount() {
        Account account = DataHolder.getAccounts().get(
                (int) (Math.random() * DataHolder.getAccounts().size())
        );
        return account;
    }

    public static boolean getLocks(Lock first, Lock second) {
        while (true) {
            if (first.tryLock()) {
                if (second.tryLock()) {
                    return true;
                }
                first.unlock();
            } else {
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void createAccounts(int number) {
        for (int i = 0; i < number; i++) {
            createAccount();
        }
    }

    public static void createAccount() {
        String owner = getRandomOwner();
        Account account = new Account(owner);
        DataHolder.addAccount(account);
    }

    public static String getRandomOwner() {
        String owner = DataHolder.getOwners().get(
                (int) (Math.random() * DataHolder.getOwners().size())
        );
        return owner;
    }

    public static void createThreads(int numberThreads, int transfers) {
        for (int i = 0; i < numberThreads; i++) {
            createThread(transfers);
        }
    }

    public static void createThread(int number) {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < number; i++) {
                getTwoAccountsAndTransferMoney();
            }
        });
        thread.start();
    }

    public static void getTwoAccountsAndTransferMoney() {
        Account one = Helper.getRandomAccount();
        Account two = Helper.getRandomAccount();
        one.makeTransfer(two);
    }

    public static void printTransfers() {
        for (MoneyTransfer moneyTransfer : DataHolder.getMoneyTransfers()) {
            System.out.println(moneyTransfer);
        }
    }
}