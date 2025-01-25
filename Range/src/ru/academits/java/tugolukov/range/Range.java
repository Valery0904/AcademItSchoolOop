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
        return number - from > 0 && number - to < 0;
    }

    public Range getIntersection(Range range) {
        double maxFrom = Math.max(this.from, range.from);
        double minTo = Math.min(this.to, range.to);

        if (maxFrom >= minTo) {
            return null;
        }

        return new Range(maxFrom, minTo);
    }

    public Range[] getUnion(Range otherRange) {
        if (this.to < otherRange.from || this.from > otherRange.to) {
            return new Range[]{this, otherRange};
        }

        double minFrom = Math.min(this.from, otherRange.from);
        double maxTo = Math.max(this.to, otherRange.to);

        return new Range[]{new Range(minFrom, maxTo)};
    }

    public Range[] getDifference(Range otherRange) {
        if (this.to <= otherRange.from || this.from >= otherRange.to) { // range2 не пересекается с range1
            return new Range[]{this};
        }

        if (this.from < otherRange.from && this.to > otherRange.to) { // range2 внутри range1
            return new Range[] {
                    new Range(this.from, otherRange.from),
                    new Range(otherRange.to, this.to)
            };
        }

        if (this.from < otherRange.from) {
            return new Range[]{new Range(this.from, otherRange.from)}; // Начало range2 внутри range1
        }

        if (this.to > otherRange.to) {
            return new Range[]{new Range(otherRange.to, this.to)}; // Конец range2 внутри range1
        }

        return new Range[]{}; // Границы интервалов равны (range1 == range2)
    }
}
