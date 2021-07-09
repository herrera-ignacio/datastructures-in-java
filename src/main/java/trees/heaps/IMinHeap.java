package trees.heaps;

public interface IMinHeap {
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
     *  Remove and return the minimum element from heap
     */
    public int extractMin();

    /**
     * Return minimum element from heap without removing
     * @return minimum element value
     */
    public int peekMin();
}
