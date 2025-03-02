package ru.academits.tugolukov.list;

public class LinkedList<T> {
    private Node<T> head;
    private int size;

    public LinkedList() {
        this.head = null;
        this.size = 0;
    }

    // Получение размера списка
    public int getSize() {
        return size;
    }

    // Получение значения первого элемента
    public T getFirstElement() {
        if (head == null) {
            throw new IllegalStateException("Список пуст");
        }

        return head.value;
    }

    // Получение значения по указанному индексу
    public T getValueByIndex(int index) {
        checkIndex(index);
        Node<T> current = getNode(index);

        return current.value;
    }

    // Изменение значения по индексу, возвращает старое значение
    public T changeValueByIndex(int index, T newValue) {
        checkIndex(index);
        Node<T> current = getNode(index);
        T oldValue = current.value;
        current.value = newValue;

        return oldValue;
    }

    // Удаление элемента по индексу, возвращает значение элемента
    public T removeElementByIndex(int index) {
        checkIndex(index);
        if (index == 0) {
            return removeFirstElement();
        }

        Node<T> previous = getNode(index - 1);
        Node<T> toRemove = previous.next;
        previous.next = toRemove.next;
        size--;

        return toRemove.value;
    }

    // Вставка элемента в начало
    public void addElementAtBegin(T value) {
        Node<T> newNode = new Node<>(value);
        newNode.next = head;
        head = newNode;
        size++;
    }

    // Вставка элемента по индексу
    public void addElementByIndex(int index, T value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();

        }

        if (index == 0) {
            addElementAtBegin(value);

            return;
        }

        Node<T> previous = getNode(index - 1);
        Node<T> newNode = new Node<>(value);
        newNode.next = previous.next;
        previous.next = newNode;
        size++;
    }

    // Удаление узла по значению, возвращает true, если элемент был удален
    public boolean removeByValue(T value) {
        if (head == null) {
            return false;
        }

        if (head.value.equals(value)) {
            removeFirstElement();
            return true;
        }

        Node<T> current = head;

        while (current.next != null) {
            if (current.next.value.equals(value)) {
                current.next = current.next.next;
                size--;

                return true;
            }

            current = current.next;
        }

        return false;
    }

    // Удаление первого элемента, возвращает значение элемента
    public T removeFirstElement() {
        if (head == null) {
            throw new IllegalStateException("Список пуст");
        }

        T value = head.value;
        head = head.next;
        size--;

        return value;
    }

    // Разворот списка за линейное время
    public void reverseList() {
        Node<T> previous = null;
        Node<T> current = head;
        Node<T> next = null;

        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        head = previous;
    }

    // Копирование списка
    public LinkedList<T> copyList() {
        LinkedList<T> newList = new LinkedList<>();
        if (head == null) {
            return newList;
        }

        Node<T> current = head;
        newList.addElementAtBegin(current.value);
        Node<T> newCurrent = newList.head;

        while (current.next != null) {
            current = current.next;
            newCurrent.next = new Node<>(current.value);
            newCurrent = newCurrent.next;
        }

        newList.size = size;

        return newList;
    }

    private Node<T> getNode(int index) {
        Node<T> current = head;

        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }
}
