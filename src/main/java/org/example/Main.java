package org.example;

public class Main {
    public static void main(String[] args) {
        testMyArrayList();
        testMyLinkedList();
        testMyStack();
        testMyQueue();
        testMyMinHeap();
    }

    private static void testMyArrayList() {
        System.out.println("=== Testing MyArrayList ===");
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(1, 15);
        System.out.println("Element at index 2: " + list.get(2));
        System.out.println("Size: " + list.size());
        System.out.println("Contains 20? " + list.contains(20));

        list.remove(2);
        System.out.println("After removal:");
        for (Integer num : list) {
            System.out.println(num);
        }
        System.out.println();
    }

    private static void testMyLinkedList() {
        System.out.println("=== Testing MyLinkedList ===");
        MyLinkedList<String> linkedList = new MyLinkedList<>();
        linkedList.add("Apple");
        linkedList.add("Banana");
        linkedList.add(1, "Mango");

        System.out.println("Element at index 0: " + linkedList.get(0));
        System.out.println("Size: " + linkedList.size());
        linkedList.remove(0);
        System.out.println("After removal:");
        for (String fruit : linkedList) {
            System.out.println(fruit);
        }
        System.out.println();
    }

    private static void testMyStack() {
        System.out.println("=== Testing MyStack ===");
        MyStack<Integer> stack = new MyStack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Top element: " + stack.peek());
        System.out.println("Stack size: " + stack.size());
        System.out.println("Popped: " + stack.pop());
        System.out.println("Now top: " + stack.peek());
        System.out.println();
    }

    private static void testMyQueue() {
        System.out.println("=== Testing MyQueue ===");
        MyQueue<String> queue = new MyQueue<>();
        queue.enqueue("Alice");
        queue.enqueue("Bob");
        queue.enqueue("Charlie");

        System.out.println("Front: " + queue.peek());
        System.out.println("Queue size: " + queue.size());

        System.out.println("Dequeued: " + queue.dequeue());
        System.out.println("New front: " + queue.peek());
        System.out.println();
    }

    private static void testMyMinHeap() {
        System.out.println("=== Testing MyMinHeap ===");
        MyMinHeap<Integer> minHeap = new MyMinHeap<>();
        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(8);
        minHeap.insert(1);

        System.out.println("Min element: " + minHeap.getMin());
        System.out.println("Extracted min: " + minHeap.extractMin());
        System.out.println("New min: " + minHeap.getMin());
        minHeap.insert(2);
        System.out.println("After inserting 2, min: " + minHeap.getMin());
        System.out.println();
    }
}