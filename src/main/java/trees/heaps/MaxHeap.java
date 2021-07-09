package trees.heaps;

import java.util.NoSuchElementException;

public class MaxHeap extends BinaryHeap implements IMaxHeap {

    public MaxHeap(int maxSize)
    {
        super(maxSize);
        this.Heap[0] = Integer.MAX_VALUE;
    }

    /**
     * Factory from array
     *
     * @param elements nodes
     * @return heap
     */
    public static MaxHeap from(int[] elements) {
        MaxHeap maxHeap = new MaxHeap(elements.length);
        maxHeap.Heap = elements;
        maxHeap.size = elements.length;

        for (int i = (maxHeap.size - 1) / 2; i >= 1; i--)
            maxHeap.maxHeapify(i);

        return maxHeap;
    }

    /**
     * Insert a node into the heap
     *
     * @param element node
     */
    @Override
    public void insert(int element) {
        if (this.size >= maxsize)
            throw new IllegalStateException("Heap is full");

        Heap[++this.size] = element;

        int current = this.size;

        // "Bubble up" to appropriate position
        while (Heap[current] > Heap[parent(current)])
        {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    /**
     * Remove and return the max element from heap
     */
    @Override
    public int extractMax() {
        if (this.size == 0)
                throw new NoSuchElementException("Heap is empty");

        int max = Heap[FRONT];
        Heap[FRONT] = Heap[this.size--];

        maxHeapify(FRONT);

        return max;
    }

    /**
     * Return max element from heap without removing
     *
     * @return max element value
     */
    @Override
    public int peekMax() {
        return Heap[FRONT];
    }

    /**
     * "Heapify" the subtree rooted at pos (maintain max-heap invariant)
     * It assumes the subtree is already a correct max-heap
     * @param pos subtree's root pos
     */
    private void maxHeapify(int pos)
    {
        if (pos > size) return;

        int l = leftChild(pos);
        int r = rightChild(pos);

        if (!isLeaf(pos))
        {
            int highest = pos;

            if (l <= size && Heap[highest] < Heap[l])
                highest = l;

            if (r <= size && Heap[highest] < Heap[r])
                highest = r;

            if (highest != pos)
            {
                swap(pos, highest);
                maxHeapify(highest);
            }
        }
    }
}
