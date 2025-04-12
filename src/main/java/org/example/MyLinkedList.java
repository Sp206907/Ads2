package org.example;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<E> implements MyList<E> {
    private static class MyNode<E> {
        E element;
        MyNode<E> prev;
        MyNode<E> next;

        MyNode(E element, MyNode<E> prev, MyNode<E> next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }
    }

    private MyNode<E> head;
    private MyNode<E> tail;
    private int size;

    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public void add(E element) {
        addLast(element);
    }

    @Override
    public void add(int index, E element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        if (index == size) {
            addLast(element);
        } else {
            MyNode<E> node = getNode(index);
            addBefore(element, node);
        }
    }

    @Override
    public E get(int index) {
        return getNode(index).element;
    }

    @Override
    public E remove(int index) {
        MyNode<E> node = getNode(index);
        return removeNode(node);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    @Override
    public int indexOf(Object o) {
        int index = 0;
        for (MyNode<E> node = head; node != null; node = node.next) {
            if (o.equals(node.element)) {
                return index;
            }
            index++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        int index = size - 1;
        for (MyNode<E> node = tail; node != null; node = node.prev) {
            if (o.equals(node.element)) {
                return index;
            }
            index--;
        }
        return -1;
    }

    @Override
    public E set(int index, E element) {
        MyNode<E> node = getNode(index);
        E oldElement = node.element;
        node.element = element;
        return oldElement;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private MyNode<E> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                E element = current.element;
                current = current.next;
                return element;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    private void addLast(E element) {
        MyNode<E> newNode = new MyNode<>(element, tail, null);
        if (tail == null) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        size++;
    }

    private void addBefore(E element, MyNode<E> node) {
        MyNode<E> prev = node.prev;
        MyNode<E> newNode = new MyNode<>(element, prev, node);
        node.prev = newNode;
        if (prev == null) {
            head = newNode;
        } else {
            prev.next = newNode;
        }
        size++;
    }

    private E removeNode(MyNode<E> node) {
        E element = node.element;
        MyNode<E> prev = node.prev;
        MyNode<E> next = node.next;

        if (prev == null) {
            head = next;
        } else {
            prev.next = next;
        }

        if (next == null) {
            tail = prev;
        } else {
            next.prev = prev;
        }

        node.prev = null;
        node.next = null;
        size--;
        return element;
    }

    private MyNode<E> getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        MyNode<E> current;
        if (index < (size >> 1)) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
        }
        return current;
    }
}
