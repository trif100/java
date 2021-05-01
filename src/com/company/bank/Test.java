package com.company.bank;

public class Test {
    public static void main(String[] args) {
        Helper.createAccounts(5);
        Helper.createThreads(3, 6);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Helper.printTransfers();
    }
}