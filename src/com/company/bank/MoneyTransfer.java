package com.company.bank;


import java.util.Calendar;
import java.util.GregorianCalendar;

public class MoneyTransfer {
    private static long countTransfers = 0;

    private final long uniqueNumber;
    private final Account one;
    private final Account two;
    private final long moneyAmount;
    private final Calendar calendar;

    public MoneyTransfer(Account one, Account two, long moneyAmount) {
        uniqueNumber = setNumber();
        this.one = one;
        this.two = two;
        this.moneyAmount = moneyAmount;
        calendar = new GregorianCalendar();
    }

    public static long setNumber() {
        countTransfers += 1;
        return countTransfers;
    }

    @Override
    public String toString() {
        return "Transfer no." + uniqueNumber +
                " from " + one + " to " + two +
                " of " + moneyAmount + " carried out on " + calendar.getTime();
    }
}