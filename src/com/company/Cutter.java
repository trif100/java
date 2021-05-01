package com.company;

public class Cutter {
    public static void main(String[] args) {
        printStrings(divide("ILoveJavaProgramming"));
        printStrings(divide("предлоЖеНиЕНАРусскомЯЗыКе"));
    }

    private static String[] divide(String string) {
        while (string.length() > 0 && Character.isLowerCase(string.charAt(0))) {
            string = string.substring(1);
        }
        String[] result = string.split("(?=\\p{javaUpperCase})");
        return result;
    }

    private static void printStrings(String[] s) {
        for (int i = 0; i < s.length; i++) {
            System.out.println(s[i]);
        }
        System.out.println();
    }
}
