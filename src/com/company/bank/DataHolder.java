package com.company.bank;

import java.util.ArrayList;
import java.util.List;

public class DataHolder {
    private static final List<String> owners = initOwners();
    private static final List<Account> accounts = new ArrayList<>();
    private static final List<MoneyTransfer> moneyTransfers = new ArrayList<>();

    private static List<String> initOwners() {
        List<String> list = new ArrayList<>();
        list.add("One");
        list.add("Two");
        list.add("Three");
        list.add("Four");
        list.add("Five");
        list.add("Six");
        list.add("Seven");
        list.add("Eight");
        list.add("Nine");
        list.add("Ten");
        list.add("Eleven");
        list.add("Twelve");
        list.add("Thirteen");
        list.add("Fourteen");
        list.add("Fifteen");
        return list;
    }

    public static List<String> getOwners() {
        return owners;
    }

    public static void addAccount(Account account) {
        accounts.add(account);
    }

    public static List<Account> getAccounts() {
        return accounts;
    }

    public static void addTransfer(MoneyTransfer transfer) {
        moneyTransfers.add(transfer);
    }

    public static List<MoneyTransfer> getMoneyTransfers() {
        return moneyTransfers;
    }
}