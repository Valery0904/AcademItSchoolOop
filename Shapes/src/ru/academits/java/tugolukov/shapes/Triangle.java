package ru.academits.java.tugolukov.shapes;

import java.util.Objects;

public class Triangle implements Shapes {
    double x1;
    double x2;
    double x3;
    double y1;
    double y2;
    double y3;

    public Triangle(double x1, double x2, double x3, double y1, double y2, double y3) {
        this.x1 = x1;
        this.x2 = x2;
        this.x3 = x3;
        this.y1 = y1;
        this.y2 = y2;
        this.y3 = y3;
    }

    @Override
    public double getWidth() {
        return Math.max(Math.max(x1, x2), x3) - Math.min(Math.min(x1, x2), x3);
    }

    @Override
    public double getHeight() {
        return Math.max(Math.max(y1, y2), y3) - Math.min(Math.min(y1, y2), y3);
    }

    @Override
    public double getArea() {
        double cutAbLength = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        double cutBcLength = Math.sqrt(Math.pow(x3 - x2, 2) + Math.pow(y3 - y2, 2));
        double cutCaLength = Math.sqrt(Math.pow(x1 - x3, 2) + Math.pow(y1 - y3, 2));

        double halfPerimeter = (cutAbLength + cutBcLength + cutCaLength) / 2;

        return Math.sqrt(halfPerimeter * (halfPerimeter - cutAbLength) *
                (halfPerimeter - cutBcLength) * (halfPerimeter - cutCaLength));
    }

    @Override
    public double getPerimeter() {
        double cutAbLength = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        double cutBcLength = Math.sqrt(Math.pow(x3 - x2, 2) + Math.pow(y3 - y2, 2));
        double cutCaLength = Math.sqrt(Math.pow(x1 - x3, 2) + Math.pow(y1 - y3, 2));

        return cutAbLength + cutBcLength + cutCaLength;
    }

    @Override
    public String toString() {
        return "Triangle "
                + "height: " + getHeight() + ", "
                + "width: " + getWidth() + ", "
                + "area: " + getArea() + ", "
                + "perimeter: " + getPerimeter();
    }

    @Override
    public boolean equals(Object triangle) {
        if (!(triangle instanceof Triangle otherTriangle)) {
            return false;
        }

        return Double.compare(x1, otherTriangle.x1) == 0 && Double.compare(x2, otherTriangle.x2) == 0
                && Double.compare(x3, otherTriangle.x3) == 0 && Double.compare(y1, otherTriangle.y1) == 0
                && Double.compare(y2, otherTriangle.y2) == 0 && Double.compare(y3, otherTriangle.y3) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x1, x2, x3, y1, y2, y3);
    }
}
