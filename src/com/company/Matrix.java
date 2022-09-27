package com.company;

import java.util.Scanner;

public class Matrix {

    int countOfRows;
    int countOfStrings;
    int[][] matrix;

    public Matrix(int countOfStrings){
        this.countOfStrings = countOfStrings;
    }

    public static void fillMatrix(int[][] emptyMatrix) {
        Scanner in = new Scanner(System.in);

        for (int i = 0; i < emptyMatrix.length; i++) {
            for (int j = 0; j < emptyMatrix[i].length; j++)
            {
                System.out.print("Введите [" + (i + 1) + "][" + (j + 1) + "] = ");
                emptyMatrix[i][j] = in.nextInt();
            }
        }
    }
    public static void printMatrix(int[][] matrix) {
        System.out.println();
        for (int[] row : matrix) {
            for (int column : row) {
                System.out.print(column + " ");
            }
            System.out.println();
        }
    }
    public void findBinaryMatrix(Matrix matrix)
    {

        if (matrix.countOfStrings > 5 && matrix.countOfRows > 5) {
            System.out.println("\nЧисло строк и число столбцов больше пяти!");
            return;
        }

        this.matrix = new int[matrix.countOfStrings][matrix.countOfRows];

        int countOfBinaryMatrix = 0;
        for (int i = 0; i < matrix.countOfStrings - 1; i ++) {
            for (int j = 0; j < matrix.countOfRows - 1; j ++) {
                int[][] binary = new int[2][2];
                binary[0][0] = matrix.matrix[i][j];
                binary[0][1] = matrix.matrix[i][j + 1];
                binary[1][0] = matrix.matrix[i + 1][j];
                binary[1][1] = matrix.matrix[i + 1][j + 1];
                countOfBinaryMatrix += 1;

                printMatrix(binary);
            }
        }
        System.out.println("\nКоличество возможных двумерных матриц = " + countOfBinaryMatrix);
    }
}
