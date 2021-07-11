package linear.queue;

import trees.heaps.MaxHeap;

import java.util.NoSuchElementException;

public class PriorityQueueHeapImpl extends MaxHeap implements PriorityQueue {

    public PriorityQueueHeapImpl(int maxSize) {
        super(maxSize);
    }

    /**
     * Change priority of given element
     *
     * @param i        identifier of the node to be changed
     * @param priority new priority
     */
    @Override
    public void changePriority(int i, int priority) {
        if (i > this.size) throw new NoSuchElementException("Invalid element");

        int oldPriority = this.Heap[i];

        this.Heap[i] = priority;

        if (priority > oldPriority) {
            this.shiftUp(i);
        }

        if (priority < oldPriority) {
            this.maxHeapify(i);
        }
    }

    protected void shiftUp(int pos) {
        if (pos > this.size)
            throw new NoSuchElementException("Invalid element");

        if (this.Heap[this.parent(pos)] >= this.Heap[pos]) {
            System.out.println(this.Heap[this.parent(pos)] + " is greatest");
            throw new IllegalStateException("Cannot shift up this element");
        } else if (pos == FRONT) {
            throw new IllegalStateException("Cannot shift up this element");
        }

        swap(this.parent(pos), pos);
        maxHeapify(pos);
    }
}
