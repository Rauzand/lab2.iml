package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("\n1 – Выполнить задание 1");
            System.out.println("2 – Выполнить задание 2");
            System.out.println("3 – Выполнить задание 3");
            System.out.println("4 – Выполнить задание 4");
            System.out.println("5 – Выйти из программы\n");

            int choice = in.nextInt();

            if (choice == 1) {
                doTaskOne();
            } else if (choice == 2) {
                doTaskTwo();
            } else if (choice == 3) {
                doTaskThree();
            } else if (choice == 4) {
                doTaskFour();
            } else {
                break;
            }
        }
        in.close();
    }

    public static void doTaskOne() {
        Scanner in = new Scanner(System.in);

        System.out.print("Введите количество строк: ");
        Matrix matrix = new Matrix(in.nextInt());

        System.out.print("\nВведите количество столбцов: ");
        matrix.countOfRows = in.nextInt();

        Matrix.fillMatrix(matrix.matrix);
        matrix.findBinaryMatrix(matrix);
    }

    public static void doTaskTwo() {
        Scanner in = new Scanner(System.in);

        System.out.print("Введите строку: ");
        String sentence = in.nextLine();
        ArrayList<Integer> numbers = new ArrayList<>();

        for (String part : sentence.split("\\s")) {
            numbers.add(Integer.parseInt(part));
        }
        System.out.print("Введите число, кратность которого нужно проверить: ");
        int number = in.nextInt();
        int countOfMultiples = 0;

        for (int digit : numbers) {
            if (digit % number == 0) {
                countOfMultiples += 1;
            }
        }
        System.out.println("Количество чисел, кратных " + number + " = " + countOfMultiples);
    }

    public static void doTaskThree() {
        Scanner in = new Scanner(System.in);

        System.out.print("Введите количество строк: ");
        int countOfStrings = in.nextInt();

        System.out.print("\nВведите количество столбцов: ");
        int countOfRows = in.nextInt();

        int[][] matrix = new int[countOfStrings][countOfRows];
        Matrix.fillMatrix(matrix);

        if (isCorrectDiagonal(matrix)) {
            System.out.println("Элементы главной диагонали упорядочены");
        } else {
            System.out.println("Элементы главной диагонали не упорядочены");
        }
    }
    public static boolean isCorrectDiagonal(int[][] matrix) {
        for (int i = 0; i < matrix.length - 1; i++) {
            if (matrix[i][i] > matrix[i + 1][i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static void doTaskFour() {
        Scanner in = new Scanner(System.in);

        System.out.print("Введите размерность массива: ");
        int size = in.nextInt();
        int[][] matrix = new int[size][size];
        Matrix.fillMatrix(matrix);
        int matrix_maxY = matrix.length - 1;
        int matrix_minY = 0;
        int matrix_maxX = matrix.length - 1;
        int matrix_minX = 0;

        for (int l = 0; l <= (matrix.length/2) + 1; l++) {
            for (int i = matrix_maxX; i >= matrix_minX; i-- ) {
                System.out.println(matrix[matrix_maxY][i]);
            }
            for (int i = matrix_maxY; i >= matrix_minY+1; i-- ) {
                System.out.println(matrix[i - 1][matrix_minY]);
            }
            for (int i = matrix_minX + 1; i <= matrix_maxX; i++ ) {
                System.out.println(matrix[matrix_minX][i]);
            }
            for (int i = matrix_minY+1; i < matrix_maxY; i++ ) {
                System.out.println(matrix[i][matrix_maxY]);
            }
            matrix_maxY--;
            matrix_maxX--;
            matrix_minX++;
            matrix_minY++;
        }
    }
}