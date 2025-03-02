package tugolukov.matrix;

import java.util.Arrays;

public class Matrix {
    private final Vector[] rows;

    // Matrix(n, m) – матрица нулей размера nxm
    public Matrix(int n, int m) {
        rows = new Vector[n];

        for (int i = 0; i < n; i++) {
            rows[i] = new Vector(m);
        }
    }

    // Matrix(Matrix) – конструктор копирования
    public Matrix(Matrix matrix) {
        int n = matrix.getRowsCount();
        int m = matrix.getColumnCount();

        rows = new Vector[n];

        for (int i = 0; i < n; i++) {
            rows[i] = new Vector(matrix.getRow(i).components);
        }
    }

    // Matrix(double[][]) – из двумерного массива
    public Matrix(double[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        rows = new Vector[n];

        for (int i = 0; i < n; i++) {
            rows[i] = new Vector(Arrays.copyOf(matrix[i], m));
        }
    }

    // Matrix(Vector[]) – из массива векторов-строк
    public Matrix(Vector[] vectors) {
        int n = vectors.length;
        int m = vectors[0].getSize();

        rows = new Vector[n];

        for (int i = 0; i < n; i++) {
            if (vectors[i].getSize() != m) {
                throw new IllegalArgumentException("Все векторы должны иметь одинаковый размер");
            }

            rows[i] = new Vector(vectors[i].components);
        }
    }

    // Получение кол-ва строк в матрице
    public int getRowsCount() {
        return rows.length;
    }

    // Получение кол-ва столбцов в матрице
    public int getColumnCount() {
        return rows[0].getSize();
    }

    // Получение вектора - строки по индексу
    public Vector getRow(int index) {
        if (index < 0 || index >= getRowsCount()) {
            throw new IndexOutOfBoundsException("Индекс выходит за пределы вектора");
        }

        return rows[index];
    }

    // Установка вектора - строки по индексу
    public void setRow(int index, Vector vector) {
        if (index < 0 || index >= getRowsCount() || vector.getSize() != getColumnCount()) {
            throw new IllegalArgumentException("Недопустимый размер строки или вектора");
        }

        rows[index] = new Vector(vector.components);
    }

    // Получение вектора - столбца по индексу
    public Vector getColumn(int index) {
        if (index < 0 || index >= getColumnCount()) {
            throw new IllegalArgumentException("Неверный индекс столбца");
        }

        double[] column = new double[getRowsCount()];
        for (int i = 0; i < getRowsCount(); i++) {
            column[i] = rows[i].getComponent(index);
        }

        return new Vector(column);
    }

    // Транспонирование матрицы
    public Matrix transpose() {
        int n = getRowsCount();
        int m = getColumnCount();

        Matrix transposed = new Matrix(m, n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                transposed.rows[j].setComponent(i, rows[i].getComponent(j));
            }
        }
        return transposed;
    }

    // Умножение на скаляр
    public Matrix multiplyByScalar(double scalar) {
        int n = getRowsCount();
        int m = getColumnCount();

        Matrix result = new Matrix(n, m);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result.rows[i].setComponent(j, rows[i].getComponent(j) * scalar);
            }
        }

        return result;
    }

    // Вычисление определителя матрицы
    public double determinant() {
        int n = getRowsCount();
        int m = getColumnCount();

        if (n != m) {
            throw new IllegalArgumentException("Matrix must be square to calculate determinant.");
        }

        if (n == 1) {
            return rows[0].getComponent(0);
        }

        if (n == 2) {
            return rows[0].getComponent(0) * rows[1].getComponent(1) - rows[0].getComponent(1)
                    * rows[1].getComponent(0);
        }

        double determinant = 0;

        for (int i = 0; i < n; i++) {
            Matrix minor = new Matrix(n - 1, n - 1);

            for (int j = 1; j < n; j++) {
                int minorColumnIndex = 0;

                for (int k = 0; k < n; k++) {
                    if (k == i) {
                        continue;
                    }

                    minor.rows[j - 1].setComponent(minorColumnIndex++, rows[j].getComponent(k));
                }
            }

            determinant += Math.pow(-1, i) * rows[0].getComponent(i) * minor.determinant();
        }

        return determinant;
    }

    // Возвращает строковое представление матрицы
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");

        for (int i = 0; i < getRowsCount(); i++) {
            sb.append(rows[i].toString());

            if (i < getRowsCount() - 1) {
                sb.append(", ");
            }
        }

        sb.append("}");

        return sb.toString();
    }

    // умножение матрицы на вектор
    public Vector multiplyByVector(Vector vector) {
        if (vector.getSize() != getColumnCount()) {
            throw new IllegalArgumentException("Размер вектора должен соответствовать количеству столбцов матрицы.");
        }

        double[] result = new double[getRowsCount()];

        for (int i = 0; i < getRowsCount(); i++) {
            double sum = 0;

            for (int j = 0; j < getColumnCount(); j++) {
                sum += rows[i].getComponent(j) * vector.getComponent(j);
            }

            result[i] = sum;
        }

        return new Vector(result);
    }

    // Сложение матриц
    public Matrix addMatrix(Matrix other) {
        if (getRowsCount() != other.getRowsCount() || getColumnCount() != other.getColumnCount()) {
            throw new IllegalArgumentException("Для сложения матрицы должны иметь одинаковые размеры.");
        }

        int n = getRowsCount();
        int m = getColumnCount();

        Matrix result = new Matrix(n, m);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result.rows[i].setComponent(j, rows[i].getComponent(j) + other.rows[i].getComponent(j));
            }
        }

        return result;
    }

    // Вычитание матриц
    public Matrix subtractMatrix(Matrix other) {
        if (getRowsCount() != other.getRowsCount() || getColumnCount() != other.getColumnCount()) {
            throw new IllegalArgumentException("Матрицы должны иметь одинаковые размеры для вычитания.");
        }

        int n = getRowsCount();
        int m = getColumnCount();
        Matrix result = new Matrix(n, m);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result.rows[i].setComponent(j, rows[i].getComponent(j) - other.rows[i].getComponent(j));
            }
        }

        return result;
    }

    public static Matrix addMatrix(Matrix a, Matrix b) {
        if (a.getRowsCount() != b.getRowsCount() || a.getColumnCount() != b.getColumnCount()) {
            throw new IllegalArgumentException("Для сложения матрицы должны иметь одинаковые размеры.");
        }

        int n = a.getRowsCount();
        int m = a.getColumnCount();
        Matrix result = new Matrix(n, m);

        // Выполнение сложения матриц
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                double sum = a.rows[i].getComponent(j) + b.rows[i].getComponent(j);
                result.rows[i].setComponent(j, sum);
            }
        }

        return result;
    }

    public static Matrix subtractMatrix(Matrix a, Matrix b) {

        if (a.getRowsCount() != b.getRowsCount() || a.getColumnCount() != b.getColumnCount()) {
            throw new IllegalArgumentException("Матрицы должны иметь одинаковые размеры для вычитания.");
        }

        int n = a.getRowsCount();
        int m = a.getColumnCount();
        Matrix result = new Matrix(n, m);

        // Выполнение вычитания матриц
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                double difference = a.rows[i].getComponent(j) - b.rows[i].getComponent(j);
                result.rows[i].setComponent(j, difference);
            }
        }

        return result;
    }


    // Статический метод для умножения двух матриц
    public static Matrix multiply(Matrix a, Matrix b) {
        if (a.getColumnCount() != b.getRowsCount()) {
            throw new IllegalArgumentException("Количество столбцов в первой матрице должно равняться количеству строк во второй матрице.");
        }

        int n = a.getRowsCount();
        int m = b.getColumnCount();
        int p = a.getColumnCount();

        Matrix result = new Matrix(n, m);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                double sum = 0;

                for (int k = 0; k < p; k++) {
                    sum += a.rows[i].getComponent(k) * b.rows[k].getComponent(j);
                }

                result.rows[i].setComponent(j, sum);
            }
        }

        return result;
    }
}
