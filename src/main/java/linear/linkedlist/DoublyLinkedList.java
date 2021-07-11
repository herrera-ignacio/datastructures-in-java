package linear.linkedlist;

import java.util.NoSuchElementException;

public class DoublyLinkedList<T> implements LinkedList<T> {
    Node<T> head;
    Node<T> tail;

    static class Node<T> {
        T data;
        Node<T> prev;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    /**
     * Appends the specified element to the end of this list
     *
     * @param elem to append
     */
    @Override
    public void add(T elem) {
        Node<T> node = new Node<T>(elem);

        // Make node the tail
        node.prev = this.tail;

        if (this.tail != null) {
            this.tail.next = node;
        }

        this.tail = node;

        // If list was empty, make it the head too
        if (this.head == null) {
            this.head = node;
        }
    }

    /**
     * Push the specified element to the beginning of this list
     *
     * @param elem to push
     */
    @Override
    public void addFirst(T elem) {
        Node<T> node = new Node<T>(elem);

        // Make node the new head
        node.next = this.head;

        if (this.head != null) {
            this.head.prev = node;
        }

        this.head = node;

        // If list was empty, make it the tail too
        if (this.tail == null) {
            this.tail = node;
        }
    }

    /**
     * Removes the element at the specified position
     *
     * @param index position to remove
     */
    @Override
    public void remove(int index) {

    }

    /**
     * Removes the first occurrence of the specified element from this list
     *
     * @param elem to remove
     */
    @Override
    public void remove(T elem) {

    }

    /**
     * Traverse the list and print all its elements
     */
    @Override
    public void traverse() {
        Node<T> current = this.head;

        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }

    /**
     * Get element at a given position
     *
     * @return node
     * @throws NoSuchElementException if not element at the position
     */
    @Override
    public T get(int index) throws NoSuchElementException {
        Node<T> node = this.head;
        int currentPosition = 0;

        while (node != null && currentPosition < index) {
            node = node.next;
            index--;
        }

        if (node == null) throw new NoSuchElementException("Index out of range");
        else return node.data;
    }
}
