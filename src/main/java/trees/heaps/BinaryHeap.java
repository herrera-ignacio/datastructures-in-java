package trees.heaps;

public class BinaryHeap {
    protected int[] Heap;
    protected int size;
    protected final int maxsize;
    protected static final int FRONT = 1;

    public BinaryHeap(int maxsize)
    {
        this.maxsize = maxsize;
        this.size = 0;
        this.Heap = new int[this.maxsize + 1];
    }

    /**
     *
     * @param pos node position
     * @return parent node
     */
    public int parent(int pos)
    {
        return pos / 2;
    }

    /**
     *
     * @param pos node position
     * @return left child node
     */
    public int leftChild(int pos)
    {
        return (2 * pos);
    }

    /**
     *
     * @param pos node position
     * @return right child node
     */
    public int rightChild(int pos)
    {
        return (2 * pos) + 1;
    }

    /**
     *
     * @param pos node position
     * @return node is leaf (last tree level)
     */
    public boolean isLeaf(int pos)
    {
        return pos >= (size / 2) + 1 && pos <= size;
    }

    /**
     * Swap two nodes in the tree
     * @param fpos first node position
     * @param spos second node position
     */
    public void swap(int fpos, int spos)
    {
        int tmp;
        tmp = Heap[fpos];
        Heap[fpos] = Heap[spos];
        Heap[spos] = tmp;
    }

    /**
     * Print the contents of the heap
     */
    public void print()
    {
        for (int i = 1; i <= this.size / 2; i++) {
            System.out.print(" NODE: " + Heap[i]
                    + " LEFT CHILD : " + Heap[leftChild(i)]
                    + " RIGHT CHILD : " + Heap[rightChild(i)]);
            System.out.println();
        }
    }
}
