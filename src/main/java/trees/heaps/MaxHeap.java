package trees.heaps;

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
    @Override
    public IMaxHeap from(int[] elements) {
        MaxHeap maxHeap = new MaxHeap(elements.length);
        maxHeap.Heap = elements;
        maxHeap.size = elements.length;

        for (int i = (size - 1) / 2; i >= 1; i--)
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

    }

    /**
     * Remove and return the max element from heap
     */
    @Override
    public int extractMax() {
        return 0;
    }

    /**
     * Return max element from heap without removing
     *
     * @return max element value
     */
    @Override
    public int peekMax() {
        return 0;
    }

    /**
     * "Heapify" the subtree rooted at pos (maintain max-heap invariant)
     * It assumes the subtree is already a correct max-heap
     * @param pos subtree's root pos
     */
    private void maxHeapify(int pos)
    {

    }
}
