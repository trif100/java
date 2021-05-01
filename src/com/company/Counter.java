package com.company;

public class Counter {
    public static void main(String[] args) {
        System.out.println(countMaxNumEntry(new int[] {1, 0, 1, 1, -9, 0, -5}));
        System.out.println(countMaxNumEntry(new int[] {1, 2, 3, 2, 1, 0, 1, 2}));
        System.out.println(countMaxNumEntry(new int[] {-19, -14, -2, -3, -2, -2, -8}));
    }

    public static int countMaxNumEntry(int[] array) {
        int maxValue = Integer.MIN_VALUE;
        for (int value : array) {
            maxValue = Math.max(maxValue, value);
        }

        int count = 0;
        for (int number : array) {
            if (number == maxValue) {
                count++;
            }
        }
        return count;
    }
}