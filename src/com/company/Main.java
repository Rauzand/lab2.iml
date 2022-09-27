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
        matrix.getCountOfRows(in.nextInt());

        Matrix.fillMatrix(matrix);
        matrix.findBinaryMatrix(matrix);
    }

    public static void doTaskTwo() {
        Scanner in = new Scanner(System.in);

        System.out.print("Введите строку: ");
        Sentence sentence = new Sentence(in.nextLine());

        System.out.print("Введите число, кратность которого нужно проверить: ");
        sentence.getNumber(in.nextInt());

       Sentence.parseSentence(sentence);
       Sentence.calculateCountOfMultiples(sentence);
    }

    public static void doTaskThree() {
        Scanner in = new Scanner(System.in);

        System.out.print("Введите количество строк: ");
        Matrix matrix = new Matrix(in.nextInt());

        System.out.print("\nВведите количество столбцов: ");
        matrix.getCountOfRows(in.nextInt());
        Matrix.fillMatrix(matrix);

        Matrix.isCorrectDiagonal(matrix);
    }

    public static void doTaskFour() {
        Scanner in = new Scanner(System.in);
        Matrix matrix = new Matrix();

        System.out.print("Введите размерность массива: ");
        matrix.getSize(in.nextInt());

        Matrix.fillMatrix(matrix);
        Matrix.Dimension(matrix);
    }
}