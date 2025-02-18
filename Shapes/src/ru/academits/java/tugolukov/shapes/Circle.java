package ru.academits.java.tugolukov.shapes;

import java.util.Objects;

public class Circle implements Shape {
    public double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getWidth() {
        return 2 * radius;
    }

    @Override
    public double getHeight() {
        return 2 * radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
        return "Circle "
                + "radius: " + radius + ", "
                + "area: " + getArea() + ", "
                + "perimeter: " + getPerimeter();
    }

    @Override
    public boolean equals(Object circle) {
        if (!(circle instanceof Circle otherCircle)) return false;
        return Double.compare(radius, otherCircle.radius) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(radius);
    }
}
