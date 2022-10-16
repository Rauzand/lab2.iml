package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Sentence {
    private String sentence;
    private int number;

    public Sentence() {
        this.sentence = "2 5 7 10";
        this.number = 2;
    }

    public Sentence(Sentence object) {
        this.sentence = object.sentence;
        this.number = object.number;
    }

    public void changeObject() {
        Scanner in = new Scanner(System.in);
        this.sentence = in.nextLine();
    }

    public Sentence(String sentence) {
        this.sentence = sentence;
    }

    public int getNumber() {
        return this.number;
    }

    public String getSentence() {
        return this.sentence;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public static void print(Sentence object) {
        System.out.println(object.sentence);
    }

    public ArrayList<Integer> parseSentence() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (String part : this.sentence.split("\\s")) {
            arrayList.add(Integer.parseInt(part));
        }
        return arrayList;
    }

    public int calculateCountOfMultiples() {
        int countOfMultiples = 0;
        for (int digit : parseSentence()) {
            if (digit % this.number == 0) {
                countOfMultiples += 1;
            }
        }
        return countOfMultiples;
    }

}