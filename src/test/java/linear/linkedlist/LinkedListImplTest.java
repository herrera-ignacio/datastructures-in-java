package linear.linkedlist;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class LinkedListImplTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    private Object[] implementationsToTest() {
        return new Object[]{
                new CircularSinglyLinkedList<Integer>(),
                new DoublyLinkedList<Integer>()
        };
    }

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
        outputStreamCaptor.reset();
    }

    @ParameterizedTest
    @MethodSource("implementationsToTest")
    void add(LinkedList<Integer> list) {
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(1, (int) list.get(0));
        assertEquals(2, (int) list.get(1));
        assertEquals(3, (int) list.get(2));
    }

    @ParameterizedTest
    @MethodSource("implementationsToTest")
    void addFirst(LinkedList<Integer> list) {
        list.addFirst(1);
        assertEquals(1, (int) list.get(0));
    }

    @ParameterizedTest
    @MethodSource("implementationsToTest")
    void addFirstShiftsHead(LinkedList<Integer> list) {
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        assertEquals(3, (int) list.get(0));
        assertEquals(2, (int) list.get(1));
        assertEquals(1, (int) list.get(2));
    }

    @Test
    void remove() {
    }

    @Test
    void testRemove() {
    }

    @ParameterizedTest
    @MethodSource("implementationsToTest")
    void traverseAfterAddFirst(LinkedList<Integer> list) {
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.traverse();
        assertEquals("3 2 1", outputStreamCaptor.toString().trim());
    }

    @ParameterizedTest
    @MethodSource("implementationsToTest")
    void traverseAfterAdd(LinkedList<Integer> list) {
        list.add(1);
        list.add(2);
        list.add(3);
        list.traverse();
        assertEquals("1 2 3", outputStreamCaptor.toString().trim());
    }
}