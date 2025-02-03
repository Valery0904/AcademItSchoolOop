package ru.academits.java.tugolukov.shapes;

import java.util.Objects;

public class Rectangle implements Shapes {
    public double height;
    public double width;

    public Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
    }

    @Override
    public double getWidth() {
        return width;
    }

    @Override
    public double getHeight() {
        return height;
    }

    @Override
    public double getArea() {
        return height * width;
    }

    @Override
    public double getPerimeter() {
        return 2 * (height + width);
    }

    @Override
    public String toString() {
        return "Rectangle "
                + "height: " + getHeight() + ", "
                + "width: " + getWidth() + ", "
                + "area: " + getArea() + ", "
                + "perimeter: " + getPerimeter();
    }

    @Override
    public boolean equals(Object rectangle) {
        if (!(rectangle instanceof Rectangle otherRectangle)) {
            return false;
        }

        return Double.compare(height, otherRectangle.height) == 0
                && Double.compare(width, otherRectangle.width) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(height, width);
    }
}
