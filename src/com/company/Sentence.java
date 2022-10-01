package com.company;

import java.util.ArrayList;

public class Sentence {
    private final String sentence;
    private final ArrayList<Integer> arrayList;
    private int number;

    public  Sentence(String sentence) {
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