package ru.academits.java.tugolukov.vector;

import java.util.Arrays;

public class Vector {
    double[] components;

    // Vector(n) – размерность n, все компоненты равны 0
    public Vector(int n) {
        if (n <= 0) {
            System.out.println("Размерность вектора должна быть больше 0.");
        }

        components = new double[n];
    }

    // Vector(Vector) – конструктор копирования
    public Vector(Vector vector) {
        components = new double[vector.components.length];
        System.arraycopy(vector.components, 0, components, 0, vector.components.length);
    }

    // Vector(double[]) – заполнение вектора значениями из массива
    public Vector(double[] array) {
        if (array.length == 0) {
            System.out.println("Размерность вектора должна быть больше 0.");
        }

        components = new double[array.length];
        System.arraycopy(array, 0, components, 0, array.length);
    }

    // Vector(n, double[]) – заполнение вектора значениями из массива.
    // Если длина массива меньше n, то считать что в остальных компонентах 0
    public Vector(int n, double[] array) {
        if (n <= 0 || array.length == 0) {
            System.out.println("Размерность вектора должна быть больше 0.");
        }

        components = new double[n];
        int componentsToCopy = Math.min(array.length, n);

        System.arraycopy(array, 0, components, 0, componentsToCopy);
    }

    // Метод getSize() для получения размерности вектора
    public int getSize() {
        return components.length;
    }

    // Реализовать метод toString(), чтобы выдавал информацию о векторе
    // в формате {значения компонент через запятую} Например, {1, 2, 3}
    @Override
    public String toString() {
        return "Vector{" + Arrays.toString(components) + '}';
    }

    // Прибавление к вектору другого вектора
    public void addVector(Vector vector) {
        for (int i = 0; i < Math.min(getSize(), vector.getSize()); i++) {
            components[i] += vector.components[i];
        }
    }

    // Вычитание вектора
    public void subtractVector(Vector vector) {
        for (int i = 0; i < components.length; i++) {
            components[i] -= vector.components[i];
        }
    }

    // Умножение вектора на скаляр
    public void multiplyByScalar(double scalar) {
        for (int i = 0; i < components.length; i++) {
            components[i] *= scalar;
        }
    }

    // Разворот вектора
    public void reverseVector() {
        multiplyByScalar(-1);
    }

    // Получение длины вектора
    public double getLength() {
        double sum = 0;

        for (double component : components) {
            sum += component * component;
        }

        return Math.sqrt(sum);
    }

    // Получение компоненты по индексу
    public double getComponent(int index) {
        checkIndex(index);

        return components[index];
    }

    // Установка компоненты по индексу
    public void setComponent(int index, double value) {
        checkIndex(index);
        components[index] = value;
    }

    // Проверка индекса
    private void checkIndex(int index) {
        if (index < 0 || index > components.length) {
            throw new IndexOutOfBoundsException("Индекс выходит за пределы вектора");
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }

        Vector vector = (Vector) obj;

        return Arrays.equals(components, vector.components);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(components);
    }

    // Статическое сложение векторов
    public static Vector addVector(Vector v1, Vector v2) {
        int maxSize = Math.max(v1.getSize(), v2.getSize());
        double[] resultComponents = new double[maxSize];

        for (int i = 0; i < maxSize; i++) {
            double component1 = i < v1.getSize() ? v1.components[i] : 0;
            double component2 = i < v2.getSize() ? v2.components[i] : 0;

            resultComponents[i] = component1 + component2;
        }

        return new Vector(resultComponents);
    }

    // Статическое вычитание векторов
    public static Vector subtractVector(Vector v1, Vector v2) {
        int maxSize = Math.max(v1.getSize(), v2.getSize());
        double[] resultComponents = new double[maxSize];

        for (int i = 0; i < maxSize; i++) {
            double component1 = i < v1.getSize() ? v1.components[i] : 0;
            double component2 = i < v2.getSize() ? v2.components[i] : 0;

            resultComponents[i] = component1 - component2;
        }

        return new Vector(resultComponents);
    }

    // Статическое скалярное произведение
    public static double dotProduct(Vector v1, Vector v2) {
        int maxSize = Math.max(v1.getSize(), v2.getSize());
        double result = 0;

        for (int i = 0; i < maxSize; i++) {
            double component1 = i < v1.getSize() ? v1.components[i] : 0;
            double component2 = i < v2.getSize() ? v2.components[i] : 0;

            result = component1 * component2;
        }

        return result;
    }
}
