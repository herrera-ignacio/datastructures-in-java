package linear.queue;

import org.junit.jupiter.api.Test;
import trees.heaps.MaxHeapValidator;

import static org.junit.jupiter.api.Assertions.*;


class PriorityQueueHeapImplTest {

    private PriorityQueueHeapImpl getTestablePQ() {
        return new PriorityQueueHeapImpl(10);
    }

    @Test
    void changePriority() {
        PriorityQueueHeapImpl pq = getTestablePQ();
        pq.insert(1);
        pq.insert(2);
        pq.insert(3);
        pq.insert(4);
        pq.changePriority(3, 10);
        assertTrue(MaxHeapValidator.isValidMaxHeap(pq));
    }
}