package linear.queue;

// import java.util.Queue;
// We use this minimal Queue interface instead of java.util.Queue
// to avoid extending java.util.Collection interface

import java.util.NoSuchElementException;

public interface Queue<T> {
    // Enqueue
    public boolean add(T item) throws IllegalStateException;

    // Dequeue
    public T remove() throws NoSuchElementException;

    // See next item to dequeue if any
    public T peek();
}