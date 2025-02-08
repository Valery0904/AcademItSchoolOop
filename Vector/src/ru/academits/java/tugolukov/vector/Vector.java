package ru.academits.java.tugolukov.vector;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Vector {
    double[] components;

    // Vector(n) – размерность n, все компоненты равны 0
    public Vector(int n) {
        if (n <= 0) {
            System.out.println("Размерность вектора должна быть больше 0.");
        }

        this.components = new double[n];
    }

    // Vector(Vector) – конструктор копирования
    public Vector (Vector vector) {
        this.components = new double[vector.components.length];
        System.arraycopy(vector.components, 0, this.components, 0, vector.components.length);
    }

    // Vector(double[]) – заполнение вектора значениями из массива
    public Vector(double[] array) {
        if (array.length == 0) {
            System.out.println("Размерность вектора должна быть больше 0.");
        }

        this.components = new double[array.length];
        System.arraycopy(array, 0, this.components, 0, array.length);
    }

    // Vector(n, double[]) – заполнение вектора значениями из массива.
    // Если длина массива меньше n, то считать что в остальных компонентах 0
    public Vector(int n, double[] array) {
        if (n <= 0 || array.length == 0) {
            System.out.println("Размерность вектора должна быть больше 0.");
        }

        this.components = new double[n];
        int componentsToCopy = Math.min(array.length, n);

        System.arraycopy(array, 0, this.components, 0, componentsToCopy);
    }

    // Метод getSize() для получения размерности вектора
    public int getSize(){
        return components.length;
    }

    // Реализовать метод toString(), чтобы выдавал информацию о векторе
    // в  формате { значения компонент через запятую } Например, {1, 2, 3}
    @Override
    public String toString() {
        return "Vector{" + Arrays.toString(components) + '}';
    }


}
