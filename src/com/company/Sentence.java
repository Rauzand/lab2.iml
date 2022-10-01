package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Sentence {
    private String sentence;
    private ArrayList<Integer> arrayList;
    private int number;

    public Sentence() {
        this.sentence = "2 5 7 10";
        this.arrayList = new ArrayList<>();
        this.number = 2;
    }

    public Sentence(Sentence object) {
        Scanner in = new Scanner(System.in);
        this.sentence = in.nextLine();
        this.arrayList = new ArrayList<>();
        parseSentence(this);
        this.number = object.number;
    }

    public static void print(Sentence object) {
        System.out.println(object.sentence);
    }

    public Sentence(String sentence) {
        this.sentence = sentence;
        this.arrayList = new ArrayList<>();
    }

    public void getNumber(int number) {
        this.number = number;
    }

    public static void parseSentence(Sentence sentence) {
        for (String part : sentence.sentence.split("\\s")) {
            sentence.arrayList.add(Integer.parseInt(part));
        }
    }

    public static void calculateCountOfMultiples(Sentence sentence) {
        int countOfMultiples = 0;
        for (int digit : sentence.arrayList) {
            if (digit % sentence.number == 0) {
                countOfMultiples += 1;
            }
        }
        System.out.println("Количество чисел, кратных " + sentence.number + " = " + countOfMultiples);
    }

}