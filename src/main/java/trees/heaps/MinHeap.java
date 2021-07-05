package trees.heaps;

public class MinHeap implements IMinHeap {
    private int[] Heap;
    private int size;
    private final int maxsize;

    private static final int FRONT = 1;
    /**
     * Constructor
     * @param maxsize max nodes the heap can contain
     */
    public MinHeap(int maxsize)
    {
        this.maxsize = maxsize;
        this.size = 0;
        this.Heap = new int[this.maxsize + 1];
        this.Heap[0] = Integer.MIN_VALUE;
    }

    @Override
    public IMinHeap from(int[] elements) {
       MinHeap minHeap = new MinHeap(elements.length);
       minHeap.Heap = elements;
       minHeap.size = elements.length;

       for (int i = (size - 1) / 2; i >= 1; i--) {
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
        if (size >= maxsize) {
            System.out.println("[INFO] Heap is full, failed to insert: " + element);
            return;
        }

        Heap[++size] = element;

        int current = size;

        // "Bubble up" the min
        while (Heap[current] < Heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    /**
     * Print the contents of the heap
     */
    @Override
    public void print()
    {
        for (int i = 1; i <= size / 2; i++) {
            System.out.print(" NODE: " + Heap[i]
            + " LEFT CHILD : " + Heap[leftChild(i)]
            + " RIGHT CHILD : " + Heap[rightChild(i)]);
            System.out.println();
        }
    }

    /**
     *  Remove and return the minimum element from heap
     */
    @Override
    public int extractMin()
    {
        int min = Heap[FRONT];
        Heap[FRONT] = Heap[size--];
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
     * "Heapify" the subtree rooted at pos (maintain heap invariant)
     * It assumes the subtree is already a correct heap
     * @param pos subtree's root pos
     */
    private void minHeapify(int pos)
    {
        int l = leftChild(pos);
        int r = rightChild(pos);

        // If the node is a non-leaf node and greater than any of its child
        if (!isLeaf(pos))
        {
            int largest = pos;

            if(Heap[pos] > Heap[l])
            {
                largest = l;
            }

            if(Heap[r] > Heap[largest])
            {
               largest = r;
            }

            swap(pos, largest);
            minHeapify(largest);
        }
    }

    /**
     *
     * @param pos node position
     * @return parent node
     */
    private int parent(int pos)
    {
        return pos / 2;
    }

    /**
     *
     * @param pos node position
     * @return left child node
     */
    private int leftChild(int pos)
    {
        return (2 * pos);
    }

    /**
     *
     * @param pos node position
     * @return right child node
     */
    private int rightChild(int pos)
    {
        return (2 * pos) + 1;
    }

    /**
     *
     * @param pos node position
     * @return node is leaf (last tree level)
     */
    private boolean isLeaf(int pos)
    {
        return pos >= (size / 2) && pos <= size;
    }

    /**
     * Swap two nodes in the tree
     * @param fpos first node position
     * @param spos second node position
     */
    private void swap(int fpos, int spos)
    {
        int tmp;
        tmp = Heap[fpos];
        Heap[fpos] = Heap[spos];
        Heap[spos] = tmp;
    }
}
