package ru.academits.java.tugolukov.matrix;

import java.util.Arrays;

public class Vector {
    double[] components;

    public Vector(int n) {
        if (n <= 0) {
            System.out.println("Размерность вектора должна быть больше 0.");
        }

        components = new double[n];
    }

    public Vector(double[] array) {
        if (array.length == 0) {
            System.out.println("Размерность вектора должна быть больше 0.");
        }

        components = new double[array.length];
        System.arraycopy(array, 0, components, 0, array.length);
    }

    public int getSize() {
        return components.length;
    }

    public double getComponent(int index) {
        checkIndex(index);

        return components[index];
    }

    public void setComponent(int index, double value) {
        checkIndex(index);
        components[index] = value;
    }

    private void checkIndex(int index) {
        if (index < 0 || index > components.length) {
            throw new IndexOutOfBoundsException("Индекс выходит за пределы вектора");
        }
    }

    @Override
    public String toString() {
        return "Vector{" + Arrays.toString(components) + '}';
    }
}
