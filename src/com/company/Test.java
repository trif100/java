package com.company;

public class Test {
    public static void main(String[] args) {
        String s1 = "aaaaaaaaaaaaa";
        String s2 = "-------------";

        int length = s1.length();
        int insert = length / 2;

        String temp = s1.substring(0, insert);
        temp = temp + s2;
        String result = temp + s1.substring(insert);

        System.out.println(result);
    }
}
