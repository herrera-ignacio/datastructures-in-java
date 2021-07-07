package trees.heaps;

public interface IMaxHeap {
    /**
     * Factory from array
     * @param elements nodes
     * @return heap
     */
    public IMaxHeap from(int[] elements);

    /**
     * Insert a node into the heap
     * @param element node
     */
    public void insert(int element);

    /**
     * Print the contents of the heap
     */
    public void print();

    /**
     *  Remove and return the max element from heap
     */
    public int extractMax();

    /**
     * Return max element from heap without removing
     * @return max element value
     */
    public int peekMax();
}
