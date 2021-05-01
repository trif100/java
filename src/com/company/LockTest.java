package com.company;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {
    public static Lock firstLock = new ReentrantLock();
    public static Lock secondLock = new ReentrantLock();

    public static void main(String[] args) {
        FirstStaticClass firstStaticClass = new FirstStaticClass();
        SecondStaticClass secondStaticClass = new SecondStaticClass();
        firstStaticClass.start();
        secondStaticClass.start();
    }

    public static class FirstStaticClass extends Thread {
        public void run() {
            for (;;) {
                if (firstLock.tryLock()) {
                    System.out.println("FirstStaticClass удерживает firstLock!");
                    try {
                        Thread.sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (secondLock.tryLock()) {
                        System.out.println("FirstStaticClass захватил оба лока!!!");
                        firstLock.unlock();
                        secondLock.unlock();
                        System.out.println("FirstStaticClass освободил оба лока!!!");
                        break;
                    } else {
                        System.out.println("secondLock занят! Освобождаем firstLock");
                        firstLock.unlock();
                        try {
                            Thread.sleep(200);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    public static class SecondStaticClass extends Thread {
        public void run() {
            for (;;) {
                if (secondLock.tryLock()) {
                    System.out.println("SecondStaticClass удерживает secondLock!");
                    try {
                        Thread.sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (firstLock.tryLock()) {
                        System.out.println("SecondStaticClass захватил оба лока!!!");
                        secondLock.unlock();
                        firstLock.unlock();
                        System.out.println("SecondStaticClass освободил оба лока!!!");
                        break;
                    } else {
                        System.out.println("firstLock занят! Освобождаем secondLock");
                        secondLock.unlock();
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}