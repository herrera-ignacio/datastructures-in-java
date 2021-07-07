package linear.queue;

import java.util.NoSuchElementException;

public class QueueLinkedListImpl implements Queue<Integer> {
    QNode front, rear;

    public QueueLinkedListImpl()
    {
        this.front = this.rear = null;
    }

    /**
     * Enqueue item
     * Time Complexity: O(1)
     */
    @Override
    public void add(Integer item) throws IllegalStateException {
        QNode node = new QNode(item);

        if (this.rear == null)
        {
            this.front = this.rear = node;
        }
        else
        {
            // Add the new node as the end of queue
            this.rear.next = node;
            this.rear = node;
        }

        System.out.println(item + " added to queue");
    }

    /**
     * Time Complexity: O(1)
     */
    @Override
    public Integer remove() throws NoSuchElementException {
        if (this.front == null)
            throw new NoSuchElementException("Queue is empty");

        QNode node = this.front;

        this.front = node.next;

        return node.key;
    }

    /**
     * Dequeue item
     * Time Complexity: O(1)
     */
    @Override
    public Integer peek() {
        if (this.front == null)
            throw new NoSuchElementException("Queue is empty");

        return this.front.key;
    }

    // Linked List (LL) node to store a queue entry
    private static class QNode {
        int key;
        QNode next;

        public QNode(int key)
        {
            this.key = key;
            this.next = null;
        }
    }
}
