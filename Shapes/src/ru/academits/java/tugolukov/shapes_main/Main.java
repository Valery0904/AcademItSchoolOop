package ru.academits.java.tugolukov.shapes_main;

import ru.academits.java.tugolukov.shapes.*;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Shape[] shapes = {
                new Circle(5),
                new Rectangle(4, 6),
                new Triangle(1, 0, 3, 0, 2, 4),
                new Square(4),
                new Circle(10),
                new Rectangle(2, 8),
                new Triangle(1, 1, 5, 1, 3, 5),
                new Square(8)
        };

        Shape maxAreaShape = getMaxAreaShape(shapes);
        System.out.println("Фигура с максимальной площадью: " + maxAreaShape.getArea());

        Shape secondPerimeterShape = getSecondPerimeterShape(shapes);
        System.out.println("Фигура со вторым по величине периметром: " + secondPerimeterShape.getPerimeter());
    }

    public static Shape getMaxAreaShape(Shape[] shapes) {
        Arrays.sort(shapes, new AreaComparator());

        return shapes[0];
    }

    public static Shape getSecondPerimeterShape(Shape[] shapes) {
        Arrays.sort(shapes, new PerimeterComparator());

        return shapes[1];
    }
}