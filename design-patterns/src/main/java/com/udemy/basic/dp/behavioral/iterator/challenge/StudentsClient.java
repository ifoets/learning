package com.udemy.basic.dp.behavioral.iterator.challenge;

public class StudentsClient {
    public static void print(StudentsIterator iterator) {
        while (!iterator.isDone()) {
            System.out.println(iterator.next());
        }
    }
}
