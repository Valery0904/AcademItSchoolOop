package ru.academits.java.tugolukov.vector_main;

import ru.academits.java.tugolukov.vector.Vector;

public class Main {
    public static void main(String[] args) {
        Vector v1 = new Vector(3);
        Vector v2 = new Vector(new double[]{1.0, 2.0, 3.0});
        Vector v3 = new Vector(4, new double[]{1.0, 2.0});

        System.out.println("v1: " + v1);
        System.out.println("v2: " + v2);
        System.out.println("v3: " + v3);

        v1.addVector(v2);
        System.out.println("v1 после прибавления v2: " + v1);

        v1.subtractVector(v3);
        System.out.println("v1 после вычитания v3: " + v1);

        v1.multiplyByScalar(2);
        System.out.println("v1 после умножения на скаляр 2: " + v1);

        v1.reverseVector();
        System.out.println("v1 после разворота: " + v1);

        System.out.println("Длина v1: " + v1.getLength());

        System.out.println("Компонента v2[1]: " + v2.getComponent(1));
        v2.setComponent(1, 5.0);
        System.out.println("v2 после изменения компоненты: " + v2);

        Vector v4 = Vector.addVector(v2, v3);
        System.out.println("Сложение v2 и v3: " + v4);

        Vector v5 = Vector.subtractVector(v2, v3);
        System.out.println("Вычитание v3 из v2: " + v5);

        double dotProduct = Vector.dotProduct(v2, v3);
        System.out.println("Скалярное произведение v2 и v3: " + dotProduct);
    }
}