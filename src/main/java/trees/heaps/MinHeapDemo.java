package trees.heaps;

public class MinHeapDemo {
    public static void main(String[] args)
    {
        MinHeap minHeap = new MinHeap(7);
        minHeap.insert(13);
        minHeap.insert(16);
        minHeap.insert(51);
        minHeap.insert(41);

        System.out.println("Printing heap...");
        minHeap.print();

        minHeap.insert(31);
        minHeap.insert(41);
        minHeap.insert(100);
        minHeap.insert(123);

        System.out.println("Printing heap...");

        minHeap.print();

        System.out.println("Peeking min: " + minHeap.peekMin());

        System.out.println("Extracting min: " + minHeap.extractMin());
    }
}
