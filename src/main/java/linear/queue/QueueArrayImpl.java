package linear.queue;

import java.util.NoSuchElementException;

/**
 * Auxiliary Space: O(N), N elements to store
 */
public class QueueArrayImpl implements Queue<Integer> {
    int front, rear, size;
    int capacity;
    int[] array;

    public QueueArrayImpl(int capacity)
    {
        this.capacity = capacity;
        front = this.size = 0;
        rear = capacity - 1;
        array = new int[this.capacity];
    }

    /**
     * Time Complexity: O(1)
     * Enqueue and item, changing rear and size "pointers".
      * @param item to enqueue
     */
    @Override
    public void add(Integer item) throws IllegalStateException {
        if (isFull()) throw new IllegalStateException("Queue overflow");

        this.rear = (this.rear + 1) % this.capacity;
        this.array[this.rear] = item;
        this.size++;

        System.out.println(item + " enqueued");
    }

    /**
     * Time Complexity: O(1)
     * Dequeue an item, changing front and size "pointers"
     * @return removed item
     */
    @Override
    public Integer remove() {
        if (isEmpty()) throw new NoSuchElementException("Queue is empty");

        Integer item = this.array[this.front];
        this.front = (this.front + 1) % this.capacity;
        this.size--;

        return item;
    }

    /**
     * Time Complexity: O(1)
     * @return next item to removed
     */
    @Override
    public Integer peek() {
        if (isEmpty()) System.out.println("Queue is empty");
        return this.array[this.front];
    }

    private boolean isFull()
    {
        return this.capacity == this.size;
    }

    private boolean isEmpty()
    {
        return this.size == 0;
    }
}
