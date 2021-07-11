package linear.linkedlist;

import java.util.NoSuchElementException;

/**
 * In real development, you should use `java.util.LinkedList` which implements the following interfaces:
 * - java.util.List
 * - java.util.Deque
 */

public interface LinkedList<T> {
    /**
     * Appends the specified element to the end of this list
     *
     * @param elem to append
     */
    void add(T elem);

    /**
     * Push the specified element to the beginning of this list
     *
     * @param elem to push
     */
    void addFirst(T elem);

    /**
     * Removes the element at the specified position
     *
     * @param index position to remove
     */
    void remove(int index);

    /**
     * Removes the first occurrence of the specified element from this list
     *
     * @param elem to remove
     */
    void remove(T elem);

    /**
     * Traverse the list and print all its elements
     */
    void traverse();

    /**
     * Get element at a given position
     *
     * @return node
     * @throws NoSuchElementException if not element at the position
     */
    T get(int index) throws NoSuchElementException;
}
