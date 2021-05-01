package com.company;

public class DiagonalDiff {

    public static void main(String[] args) {
        System.out.println(diff(new int[][]{
                        {5, 0},
                        {0, 5}
                })
        );

        System.out.println(diff(new int[][]{
                        {5, 0, 9},
                        {0, 2, 0},
                        {9, 0, 5}
                })
        );

        System.out.println(diff(new int[][]{
                        {1, 0, 0, 9},
                        {0, 1, 9, 0},
                        {0, 9, 1, 0},
                        {9, 0, 0, 1}
                })
        );
    }

    public static int diff(int[][] array) {
        int mainSum = 0;
        int secondarySum = 0;

        for (int i = 0; i < array.length; i++)
        {
            for (int j = 0; j < array.length; j++)
            {
                if (i == j) {
                    mainSum += array[i][j];
                }
                if (i == array.length - j - 1) {
                    secondarySum += array[i][j];
                }
            }
        }
        return Math.abs(mainSum - secondarySum);
    }
}