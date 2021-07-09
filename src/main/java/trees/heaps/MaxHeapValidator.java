package trees.heaps;

public class MaxHeapValidator {
    public static boolean isValidMaxHeap(BinaryHeap maxHeap) {
        boolean isValid = true;

        for (int i = 1; isValid && i <= (maxHeap.size - 1) / 2; i++) {
            int leftChildPos = maxHeap.leftChild(i);
            int rightChildPos = maxHeap.rightChild(i);

            if ((leftChildPos <= maxHeap.size && maxHeap.Heap[i] < maxHeap.Heap[leftChildPos]) ||
                    (rightChildPos <= maxHeap.size && maxHeap.Heap[i] < maxHeap.Heap[rightChildPos]))
                isValid = false;
        }

        return isValid;
    }
}
