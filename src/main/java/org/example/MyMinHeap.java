package org.example;

import java.util.NoSuchElementException;

public class MyMinHeap<E extends Comparable<E>> {
    private MyArrayList<E> list;

    public MyMinHeap() {
        list = new MyArrayList<>();
    }

    public void insert(E element) {
        list.add(element);
        int currentIndex = list.size() - 1;
        while (currentIndex > 0) {
            int parentIndex = (currentIndex - 1) / 2;
            E current = list.get(currentIndex);
            E parent = list.get(parentIndex);
            if (current.compareTo(parent) >= 0) {
                break;
            }
            swap(currentIndex, parentIndex);
            currentIndex = parentIndex;
        }
    }

    public E extractMin() {
        if (isEmpty()) {
            throw new NoSuchElementException("Heap is empty");
        }
        E min = list.get(0);
        E last = list.remove(list.size() - 1);
        if (!isEmpty()) {
            list.set(0, last);
            heapify(0);
        }
        return min;
    }

    public E getMin() {
        if (isEmpty()) {
            throw new NoSuchElementException("Heap is empty");
        }
        return list.get(0);
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

    public int size() {
        return list.size();
    }

    private void heapify(int index) {
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        int smallest = index;

        if (left < list.size() && list.get(left).compareTo(list.get(smallest)) < 0) {
            smallest = left;
        }
        if (right < list.size() && list.get(right).compareTo(list.get(smallest)) < 0) {
            smallest = right;
        }
        if (smallest != index) {
            swap(index, smallest);
            heapify(smallest);
        }
    }

    private void swap(int i, int j) {
        E temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
}