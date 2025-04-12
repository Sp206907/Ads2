package org.example;

import java.util.Iterator;

public interface MyList<E> extends Iterable<E> {
    void add(E element);
    void add(int index, E element);
    E get(int index);
    E remove(int index);
    int size();
    void clear();
    boolean contains(Object o);
    int indexOf(Object o);
    int lastIndexOf(Object o);
    E set(int index, E element);
    Iterator<E> iterator();
}