package ru.academits.java.tugolukov.shapes;

import java.util.Objects;

public class Square implements Shape {
    public double sideLength;

    public Square(double sideLength) {
        this.sideLength = sideLength;
    }

    public double getSideLength() {
        return sideLength;
    }

    public void setSideLength(double sideLength) {
        this.sideLength = sideLength;
    }

    @Override
    public double getWidth() {
        return sideLength;
    }

    @Override
    public double getHeight() {
        return sideLength;
    }

    @Override
    public double getArea() {
        return sideLength * sideLength;
    }

    @Override
    public double getPerimeter() {
        return sideLength * 4;
    }

    @Override
    public String toString() {
        return "Square "
                + "side: " + sideLength + ", "
                + "area: " + getArea() + ", "
                + "perimeter: " + getPerimeter();
    }

    @Override
    public boolean equals(Object square) {
        if (!(square instanceof Square otherSquare)) {
            return false;
        }

        return Double.compare(sideLength, otherSquare.sideLength) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(sideLength);
    }
}
