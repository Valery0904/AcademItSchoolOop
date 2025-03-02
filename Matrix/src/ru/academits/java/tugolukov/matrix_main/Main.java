package ru.academits.java.tugolukov.matrix_main;

import ru.academits.java.tugolukov.matrix.Matrix;
import ru.academits.java.tugolukov.matrix.Vector;

public class Main {
    public static void main(String[] args) {
        double[][] data1 = {
                {1.0, 2.0},
                {3.0, 4.0}
        };

        double[][] data2 = {
                {5.0, 6.0},
                {7.0, 8.0}
        };

        Matrix matrix1 = new Matrix(data1);
        System.out.println("Матрица 1:");
        System.out.println(matrix1);

        Matrix matrix2 = new Matrix(data2);
        System.out.println("Матрица 2:");
        System.out.println(matrix2);

        try {
            Matrix sumMatrix = Matrix.addMatrix(matrix1, matrix2);

            System.out.println("Сумма матрицы 1 и матрицы 2:");
            System.out.println(sumMatrix);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка добавления: " + e.getMessage());
        }

        try {
            Matrix diffMatrix = Matrix.subtractMatrix(matrix1, matrix2);

            System.out.println("Разница Матрицы 1 и Матрицы 2:");
            System.out.println(diffMatrix);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка вычитания: " + e.getMessage());
        }

        double scalar = 2.0;
        Matrix scaledMatrix = matrix1.multiplyByScalar(scalar);

        System.out.println("Матрица 1, умноженная на скаляр" + scalar + ":");
        System.out.println(scaledMatrix);

        Matrix transposedMatrix = matrix1.transpose();

        System.out.println("Транспонирование матрицы 1:");
        System.out.println(transposedMatrix);

        try {
            double determinant = matrix1.determinant();

            System.out.println("Определитель матрицы 1: " + determinant);
        } catch (IllegalArgumentException e) {
            System.out.println("Определяющая ошибка: " + e.getMessage());
        }

        double[] vectorData = {1.0, 1.0};
        Vector vector = new Vector(vectorData);

        try {
            Vector resultVector = matrix1.multiplyByVector(vector);

            System.out.println("Матрица 1, умноженная на вектор" + vector + ":");
            System.out.println(resultVector);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка умножения матрицы на вектор: " + e.getMessage());
        }

        try {
            Matrix sumMatrixInstance = matrix1.addMatrix(matrix2);
            System.out.println("Сумма матрицы 1 и матрицы 2 ");
            System.out.println(sumMatrixInstance);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка добавления " + e.getMessage());
        }

        try {
            Matrix diffMatrixInstance = matrix1.subtractMatrix(matrix2);
            System.out.println("Разница матрицы 1 и матрицы 2 ");
            System.out.println(diffMatrixInstance);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка вычитания " + e.getMessage());
        }

        try {
            Matrix sumMatrixStatic = Matrix.addMatrix(matrix1, matrix2);
            System.out.println("Сумма матрицы 1 и матрицы 2: ");
            System.out.println(sumMatrixStatic);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка добавления: " + e.getMessage());
        }

        try {
            Matrix diffMatrixStatic = Matrix.subtractMatrix(matrix1, matrix2);
            System.out.println("Разница Матрицы 1 и Матрицы 2:");
            System.out.println(diffMatrixStatic);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка вычитания: " + e.getMessage());
        }

        try {
            Matrix productMatrixStatic = Matrix.multiply(matrix1, matrix2);
            System.out.println("Произведение Матрицы 1 и Матрицы 2 :");
            System.out.println(productMatrixStatic);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка умножения: " + e.getMessage());
        }
    }
}
