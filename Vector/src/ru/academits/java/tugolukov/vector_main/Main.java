package ru.academits.java.tugolukov.vector_main;

import ru.academits.java.tugolukov.vector.Vector;

public class Main {
    public static void main(String[] args) {
        Vector vector = new Vector(new double[]{2.2, 3.1, 4.0, 5.2});

        System.out.println(vector);
        System.out.println(vector.getSize());
    }
}