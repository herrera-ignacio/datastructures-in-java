package linear.queue;

import java.util.NoSuchElementException;

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
     * Enqueue and item, changing rear and size "pointers".
      * @param item to enqueue
     * @return true if succeeded
     */
    @Override
    public boolean add(Integer item) throws IllegalStateException {
        if (isFull()) throw new IllegalStateException("Queue overflow");

        this.rear = (this.rear + 1) % this.capacity;
        this.array[this.rear] = item;
        this.size++;

        System.out.println(item + " enqueued");

        return true;
    }

    /**
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
