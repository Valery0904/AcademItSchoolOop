package ru.academits.java.tugolukov.shapes_main;

import ru.academits.java.tugolukov.shapes.*;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Shapes[] shapes = {
                new Circle(5),
                new Rectangle(4, 6),
                new Triangle(1, 0, 3, 0, 2, 4),
                new Square(4),
                new Circle(10),
                new Rectangle(2, 8),
                new Triangle(1, 1, 5, 1, 3, 5),
                new Square(8)
        };

        Shapes maxAreaShape = getMaxAreaShape(shapes);
        System.out.println("Фигура с максимальной площадью: " + maxAreaShape.getArea());

        Shapes secondPerimeterShape = getSecondPerimeterShape(shapes);
        System.out.println("Фигура со вторым по величине периметром: " + secondPerimeterShape.getPerimeter());
    }

    public static Shapes getMaxAreaShape(Shapes[] shapes) {
        Arrays.sort(shapes, Comparator
                .comparing(Shapes::getArea)
                .reversed());

        return shapes[0];
    }

    public static Shapes getSecondPerimeterShape(Shapes[] shapes) {
        Arrays.sort(shapes, Comparator
                .comparing(Shapes::getPerimeter)
                .reversed());

        return shapes[1];
    }
}