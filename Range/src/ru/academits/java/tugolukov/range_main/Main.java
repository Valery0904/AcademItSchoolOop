package ru.academits.java.tugolukov.range_main;

import ru.academits.java.tugolukov.range.Range;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите начало числового диапазона: ");
        double from = scanner.nextDouble();

        System.out.print("Введите конец числового диапазона: ");
        double to = scanner.nextDouble();

        System.out.print("Введите число которое хотите проверить: ");
        double number = scanner.nextDouble();

        Range range = new Range(from, to);

        System.out.printf("Длина числового диапазона от %.2f до %.2f = %.2f%n", range.getFrom(), range.getTo(), range.getLength());

        if (range.isInside(number)) {
            System.out.printf("Число %.2f принадлежит диапазону", number);
        } else {
            System.out.printf("Число %.2f не принадлежит диапазону", number);
        }
    }
}
