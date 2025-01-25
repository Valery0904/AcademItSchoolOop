package ru.academits.java.tugolukov.range_main;

import ru.academits.java.tugolukov.range.Range;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите начало числового диапазона Range: ");
        double rangeFrom = scanner.nextDouble();

        System.out.print("Введите конец числового диапазона Range: ");
        double rangeTo = scanner.nextDouble();

        System.out.print("Введите начало числового диапазона Range: ");
        double otherRangeFrom = scanner.nextDouble();

        System.out.print("Введите конец числового диапазона Range: ");
        double otherRangeTo = scanner.nextDouble();

        System.out.print("Введите число которое хотите проверить: ");
        double number = scanner.nextDouble();

        Range range = new Range(rangeFrom, rangeTo);
        Range otherRange = new Range(otherRangeFrom, otherRangeTo);

        System.out.printf("Длина числового диапазона от %.2f до %.2f = %.2f%n", range.getFrom(), range.getTo(), range.getLength());

        if (range.isInside(number)) {
            System.out.printf("Число %.2f принадлежит диапазону", number);
        } else {
            System.out.printf("Число %.2f не принадлежит диапазону", number);
        }

        System.out.println();

        Range intersection = range.getIntersection(otherRange);
        System.out.println(intersection != null ?
                "Пересечение: " + intersection.getFrom() + ", " + intersection.getTo() : "Нет пересечения");

        Range[] rangeUnion = range.getUnion(otherRange);
        System.out.println("Объедененный диапазон: ");

        for (Range r : rangeUnion) {
            System.out.println("[" + r.getFrom() + ", " + r.getTo() + "]");
        }

        Range[] rangeDifference = range.getDifference(otherRange);
        if (rangeDifference.length == 0) {
            System.out.println("У интревалов нет разности");
        } else {
            System.out.println("Разность: ");

            for (Range r : rangeDifference) {
                System.out.println("[" + r.getFrom() + ", " + r.getTo() + "]");
            }
        }
    }
}
