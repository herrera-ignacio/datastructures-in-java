package trees.heaps;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import trees.heaps.MaxHeapValidator;

import static org.junit.jupiter.api.Assertions.*;

class MaxHeapTest {

    private static final int MAX_ELEMENT = 100;

    private MaxHeap getTestableMaxHeap() {
        MaxHeap maxHeap = new MaxHeap(8);

        maxHeap.insert(13);
        maxHeap.insert(16);
        maxHeap.insert(51);
        maxHeap.insert(41);
        maxHeap.insert(31);
        maxHeap.insert(41);
        maxHeap.insert(MAX_ELEMENT);

        return maxHeap;
    }



    @Test
    void from() {
        MaxHeap maxHeap = MaxHeap.from(new int[]{5, 31, 23, 55});
        assertTrue(MaxHeapValidator.isValidMaxHeap(maxHeap));
    }

    @Test
    void insert() {
        MaxHeap maxHeap = getTestableMaxHeap();
        maxHeap.insert(30);

        assertTrue(MaxHeapValidator.isValidMaxHeap(maxHeap));

        Integer[] heapElements = new Integer[maxHeap.Heap.length];
        Arrays.setAll(heapElements, i -> maxHeap.Heap[i]);

        assertTrue(Arrays.asList(heapElements).contains(30));
    }

    @Test
    void extractMax() {
        int extracted = getTestableMaxHeap().extractMax();
        assertEquals(extracted, MAX_ELEMENT);
    }

    @Test
    void peekMax() {
        int peeked = getTestableMaxHeap().peekMax();
        assertEquals(peeked, MAX_ELEMENT);
    }
}