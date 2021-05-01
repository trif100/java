package com.company;

public class Zadanie1 {
    public static void main(String[] args) {
        stairway(10);
        stairway(-10);
        stairway(0);
        stairway(100);
        stairway(99);
    }

    private static void stairway(int number) {
        System.out.println("Результаты для числа " + number + ":");
        if (number < 1 || number >= 100) {
            System.out.println("Необходимо число больше 0 и меньше 100!");
            System.out.println();
            return;
        }

        for (int i = 1; i <= number; i++) {
            System.out.printf("%2d - ", i);
            for (int j = 1; j <= number - i; j++) {
                System.out.print(" ");
            }
            for (int j = number - i + 1; j <= number; j++) {
                System.out.print('#');
            }
            System.out.println();
        }
        System.out.println();
    }
}