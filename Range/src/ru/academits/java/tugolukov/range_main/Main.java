package ru.academits.java.tugolukov.range_main;

import ru.academits.java.tugolukov.range.Range;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите начало числового диапазона Range1: ");
        double range1From = scanner.nextDouble();

        System.out.print("Введите конец числового диапазона Range1: ");
        double range1To = scanner.nextDouble();

        System.out.print("Введите начало числового диапазона Range2: ");
        double range2From = scanner.nextDouble();

        System.out.print("Введите конец числового диапазона Range2: ");
        double range2To = scanner.nextDouble();

        System.out.print("Введите число которое хотите проверить: ");
        double number = scanner.nextDouble();

        Range range1 = new Range(range1From, range1To);
        Range range2 = new Range(range2From, range2To);

        System.out.printf("Длина числового диапазона от %.2f до %.2f = %.2f%n", range1.getFrom(), range1.getTo(), range1.getLength());

        if (range1.isInside(number)) {
            System.out.printf("Число %.2f принадлежит диапазону", number);
        } else {
            System.out.printf("Число %.2f не принадлежит диапазону", number);
        }

        System.out.println();

        Range intersection = range1.getIntersection(range2);
        System.out.println(intersection != null
                ? "Пересечение: " + intersection.getFrom() + ", " + intersection.getTo()
                : "Нет пересечения");

        Range[] rangeUnion = range1.getUnion(range2);
        System.out.println("Объединенный диапазон:");

        for (Range rangeNumber : rangeUnion) {
            System.out.println("[" + rangeNumber.getFrom() + ", " + rangeNumber.getTo() + "]");
        }

        Range[] rangeDifference = range1.getDifference(range2);

        if (rangeDifference.length == 0) {
            System.out.println("У интервалов нет разности");
        } else {
            System.out.println("Разность:");

            for (Range rangeNumber : rangeDifference) {
                System.out.println("[" + rangeNumber.getFrom() + ", " + rangeNumber.getTo() + "]");
            }
        }
    }
}
