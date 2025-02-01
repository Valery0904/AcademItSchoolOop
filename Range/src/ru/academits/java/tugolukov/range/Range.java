package ru.academits.java.tugolukov.range;

public class Range {
    private double from;
    private double to;

    public Range(double from, double to) {
        this.from = from;
        this.to = to;
    }

    public double getFrom() {
        return from;
    }

    public void setFrom(double from) {
        this.from = from;
    }

    public double getTo() {
        return to;
    }

    public void setTo(double to) {
        this.to = to;
    }

    public double getLength() {
        return to - from;
    }

    public boolean isInside(double number) {
        return number >= from && number <= to;
    }

    public Range getIntersection(Range range) {
        double maxFrom = Math.max(from, range.from);
        double minTo = Math.min(to, range.to);

        if (maxFrom >= minTo) {
            return null;
        }

        return new Range(maxFrom, minTo);
    }

    public Range[] getUnion(Range range) {
        if (to < range.from || from > range.to) {
            return new Range[]{
                    new Range(from, to),
                    new Range(range.from, range.to)
            };
        }

        double minFrom = Math.min(from, range.from);
        double maxTo = Math.max(to, range.to);

        return new Range[]{new Range(minFrom, maxTo)};
    }

    public Range[] getDifference(Range range) {
        if (to <= range.from || from >= range.to) { // range2 не пересекается с range1
            return new Range[]{new Range(from, to)};
        }

        if (from < range.from && to > range.to) { // range2 внутри range1
            return new Range[]{
                    new Range(from, range.from),
                    new Range(range.to, to)
            };
        }

        if (from < range.from) {
            return new Range[]{new Range(from, range.from)}; // Начало range2 внутри range1
        }

        if (to > range.to) {
            return new Range[]{new Range(range.to, to)}; // Конец range2 внутри range1
        }

        return new Range[]{}; // Границы интервалов равны (range1 == range2)
    }
}
