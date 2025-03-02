package ru.academits.tugolukov.list_main;

import ru.academits.tugolukov.list.LinkedList;


public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();

        // Добавление элементов в начало списка
        list.addElementAtBegin(10);
        list.addElementAtBegin(20);
        list.addElementAtBegin(30);

        // Текущий список: 30 -> 20 -> 10
        System.out.println("Начальный список:");
        printList(list);

        // Добавление элемента по индексу
        list.addElementByIndex(1, 25);
        // Ожидаемый список: 30 -> 25 -> 20 -> 10
        System.out.println("После добавления 25 на индекс 1:");
        printList(list);

        // Получение размера списка
        System.out.println("Размер списка: " + list.getSize());

        // Получение и изменение значения по индексу
        System.out.println("Значение на индексе 2: " + list.getValueByIndex(2)); // Ожидается 20
        System.out.println("Старое значение на индексе 2: " + list.changeValueByIndex(2, 35)); // Изменение 20 на 35
        System.out.println("Новое значение на индексе 2: " + list.getValueByIndex(2)); // Ожидается 35

        // Удаление элемента по индексу
        System.out.println("Удаленное значение на индексе 1: " + list.removeElementByIndex(1)); // Удаление 25

        // Ожидаемый список: 30 -> 35 -> 10
        System.out.println("После удаления элемента на индексе 1:");
        printList(list);

        // Удаление узла по значению
        System.out.println("Удаление значения 35: " + list.removeByValue(35)); // Удаление 35

        // Ожидаемый список: 30 -> 10
        System.out.println("После удаления значения 35:");
        printList(list);

        // Удаление первого элемента
        System.out.println("Удаленное первое значение: " + list.removeFirstElement()); // Удаление 30

        // Ожидаемый список: 10
        System.out.println("После удаления первого элемента:");
        printList(list);

        // Разворот списка
        list.addElementAtBegin(40);
        list.addElementAtBegin(50);

        // Текущий список: 50 -> 40 -> 10
        System.out.println("До разворота:");
        printList(list);
        list.reverseList();

        // Ожидаемый список: 10 -> 40 -> 50
        System.out.println("После разворота:");
        printList(list);

        // Копирование списка
        LinkedList<Integer> copiedList = list.copyList();

        // Ожидаемый список: 10 -> 40 -> 50
        System.out.println("Копия списка:");
        printList(copiedList);
    }

    private static void printList(LinkedList<Integer> list) {
        for (int i = 0; i < list.getSize(); i++) {
            System.out.print(list.getValueByIndex(i) + " ");
        }
        System.out.println();
    }
}