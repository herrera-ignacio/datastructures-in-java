package linear.linkedlist;

import java.util.NoSuchElementException;

public class CircularSinglyLinkedList<T> implements LinkedList<T> {
    Node<T> head;

    static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    /**
     * Appends the specified element to the end of this list
     *
     * @param elem to append
     */
    @Override
    public void add(T elem) {
        Node<T> newHead = new Node<T>(elem);
        Node<T> current = this.head;

        newHead.next = this.head;

        if (current == null) {
            // If list was empty
            this.head = newHead;
            this.head.next = newHead;
        } else {
            // List had at least one element
            while (current.next != this.head) {
                current = current.next;
            }

            current.next = newHead;
        }
    }

    /**
     * Push the specified element to the beginning of this list
     *
     * @param elem to push
     */
    @Override
    public void addFirst(T elem) {
        Node<T> newHead = new Node<T>(elem);
        Node<T> oldHead = this.head;

        // Add as new head
        this.head = newHead;
        newHead.next = oldHead;

        if (oldHead != null && oldHead.next == oldHead) {
            // If there was only one item
            oldHead.next = newHead;
        } else if (oldHead == null) {
            // If list was empty
            newHead.next = newHead;
        } else {
            // There was more than one item
            Node<T> current = oldHead.next;

            while (current.next != oldHead) {
                current = current.next;
            }

            current.next = newHead;
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
        if (this.head != null) {
            Node<T> node = this.head;
            do {
                System.out.print(node.data + " ");
                node = node.next;
            } while (node != this.head);
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
