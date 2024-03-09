package tests.java;

import main.java.Queue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestQueue {

    Queue<Integer> queue;

    @BeforeEach
    public void setup() {
        queue = new Queue<>();
    }

    @Test
    @Order(1)
    public void testEmptyQueue() {
        assertTrue(queue.isEmpty(), "New Queue should be empty");
        assertThrows(IllegalArgumentException.class, () -> queue.head(), "Getting head of empty Queue should throw an exception");
    }

    @Test
    @Order(2)
    public void testEnqueue() {
        queue.enqueue(128);
        assertFalse(queue.isEmpty(), "Queue should not be empty after enqueueing an element");
        assertEquals(128, queue.head(), "Enqueued element should be at the head of the Queue");
    }

    @Test
    @Order(3)
    public void testDequeue() {
        queue.enqueue(128);
        queue.enqueue(256);

        assertEquals(128, queue.dequeue(), "Dequeued element should be the first element added");
        assertEquals(256, queue.head(), "Head of Queue should be updated after dequeue");
        assertFalse(queue.isEmpty(), "Queue should not be empty after dequeue");
    }

    @Test
    @Order(4)
    public void testEnqueueDequeueSequence() {
        queue.enqueue(128);
        queue.enqueue(256);
        queue.enqueue(512);

        assertEquals(128, queue.dequeue(), "Dequeued element should be the first element added");
        assertEquals(256, queue.head(), "Head of Queue should be updated after dequeue");
        assertFalse(queue.isEmpty(), "Queue should not be empty after dequeue");

        queue.enqueue(1024);
        assertEquals(256, queue.dequeue(), "Dequeued element should be the second element added after the enqueue");
        assertEquals(512, queue.head(), "Head of Queue should be updated after dequeue and enqueue");
    }
}
