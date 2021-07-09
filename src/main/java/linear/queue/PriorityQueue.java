package linear.queue;

// https://www.geeksforgeeks.org/priority-queue-using-binary-heap/

import trees.heaps.IMaxHeap;

public interface PriorityQueue extends IMaxHeap {
    /**
     * Change priority of given element
     *
     * @param i        identifier of the node to be changed
     * @param priority new priority
     */
    public void changePriority(int i, int priority);
}
