 package com.company;

import java.util.Scanner;

public class Matrix {
    private int countOfRows;
    private int countOfStrings;
    private int[][] matrix;

    public Matrix() {
        this.countOfStrings = 5;
        this.countOfRows = 5;
        this.matrix = new int[countOfStrings][countOfRows];
    }

    public Matrix(int countOfStrings){
        this.countOfStrings = countOfStrings;
    }

    public void getCountOfRows(int countOfRows) {
        this.countOfRows = countOfRows;
        this.matrix = new int[this.countOfStrings][this.countOfRows];
    }

    public void getSize(int countOfStrings) {
        this.matrix = new int[countOfStrings][countOfStrings];
    }

    public void fillMatrix() {
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix[i].length; j++) {
                System.out.print("Введите [" + (i + 1) + "][" + (j + 1) + "] = ");
                this.matrix[i][j] = in.nextInt();
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
    public static void Dimension(Matrix matrix){

        int matrix_maxY = matrix.matrix.length - 1;
        int matrix_minY = 0;
        int matrix_maxX = matrix.matrix.length - 1;
        int matrix_minX = 0;

        for (int l = 0; l <= (matrix.matrix.length/2) + 1; l++) {
            for (int i = matrix_maxX; i >= matrix_minX; i-- ) {
                System.out.println(matrix.matrix[matrix_maxY][i]);
            }
            for (int i = matrix_maxY; i >= matrix_minY+1; i-- ) {
                System.out.println(matrix.matrix[i - 1][matrix_minY]);
            }
            for (int i = matrix_minX + 1; i <= matrix_maxX; i++ ) {
                System.out.println(matrix.matrix[matrix_minX][i]);
            }
            for (int i = matrix_minY+1; i < matrix_maxY; i++ ) {
                System.out.println(matrix.matrix[i][matrix_maxY]);
            }
            matrix_maxY--;
            matrix_maxX--;
            matrix_minX++;
            matrix_minY++;
        }
    }

    public boolean isCorrectDiagonal() {
        for (int i = 0; i < this.matrix.length - 1; i++) {
            if (this.matrix[i][i] > this.matrix[i + 1][i + 1]) {
                return false;
            }
        }
        return true;
    }
}