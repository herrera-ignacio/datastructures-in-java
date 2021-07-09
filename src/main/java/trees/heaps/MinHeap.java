package trees.heaps;

import java.util.NoSuchElementException;

public class MinHeap extends BinaryHeap implements IMinHeap {
    /**
     * Constructor
     * @param maxsize max nodes the heap can contain
     */
    public MinHeap(int maxsize)
    {
        super(maxsize);
        this.Heap[0] = Integer.MIN_VALUE;
    }

    public static MinHeap from(int[] elements) {
       MinHeap minHeap = new MinHeap(elements.length);
       minHeap.Heap = elements;
       minHeap.size = elements.length;

       for (int i = (minHeap.size - 1) / 2; i >= 1; i--) {
           minHeap.minHeapify(i);
       }

       return minHeap;
    }

    /**
     * Insert a node into the heap
     * @param element node
     */
    @Override
    public void insert(int element)
    {
        if (this.size >= maxsize)
            throw new IllegalStateException("Heap is full");

        Heap[++this.size] = element;

        int current = this.size;

        // "Bubble up" to appropriate position
        while (Heap[current] < Heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    /**
     *  Remove and return the minimum element from heap
     */
    @Override
    public int extractMin()
    {
        if (this.size == 0)
            throw new NoSuchElementException("Heap is empty");

        int min = Heap[FRONT];
        Heap[FRONT] = Heap[this.size--];

        minHeapify(FRONT);

        return min;
    }

    /**
     * Return minimum element from heap without removing
     * @return minimum element value
     */
    @Override
    public int peekMin()
    {
        return Heap[FRONT];
    }

    /**
     * "Heapify" the subtree rooted at pos (maintain min-heap invariant)
     * It assumes the subtree is already a correct min-heap
     * @param pos subtree's root pos
     */
    private void minHeapify(int pos)
    {
        if (pos > size) return;

        int l = leftChild(pos);
        int r = rightChild(pos);

        // If the node is a non-leaf node and greater than any of its child
        if (!isLeaf(pos))
        {
            int lowest = pos;

            if(l <= size && Heap[lowest] > Heap[l])
            {
                lowest = l;
            }

            if(r <= size && Heap[lowest] > Heap[r])
            {
                lowest = r;
            }

            if (lowest != pos)
            {
                swap(pos, lowest);
                minHeapify(lowest);
            }
        }
    }
}
