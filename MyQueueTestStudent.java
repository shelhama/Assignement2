import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

/**
 * Unit tests for the MyQueue class.
 * 
 * @author Samuella Helha
 */
public class MyQueueTestStudent {

    private MyQueue<Integer> queue;

    /**
     * Set up the queue before each test.
     */
    @BeforeEach
    public void setUp() {
        queue = new MyQueue<>(5); // Create a queue with capacity 5
    }

    /**
     * Test enqueue method and size of the queue.
     */
    @Test
    public void testEnqueue() throws QueueOverflowException {
        // Enqueue elements
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        // Verify the size of the queue
        assertEquals(3, queue.size(), "Size should be 3 after enqueueing 3 elements.");
        assertFalse(queue.isEmpty(), "Queue should not be empty.");
    }

    /**
     * Test dequeue method and size of the queue.
     */
    @Test
    public void testDequeue() throws QueueOverflowException, QueueUnderflowException {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        // Dequeue an element and check the size
        assertEquals(1, queue.dequeue(), "First dequeued element should be 1.");
        assertEquals(2, queue.size(), "Size should be 2 after dequeuing 1 element.");

        // Dequeue the next element
        assertEquals(2, queue.dequeue(), "Second dequeued element should be 2.");
        assertEquals(1, queue.size(), "Size should be 1 after dequeuing another element.");

        // Dequeue the last element
        assertEquals(3, queue.dequeue(), "Last dequeued element should be 3.");
        assertTrue(queue.isEmpty(), "Queue should be empty after dequeuing all elements.");
    }

    /**
     * Test isEmpty method when queue is empty and not empty.
     */
    @Test
    public void testIsEmpty() throws QueueOverflowException {
        // Initially, the queue should be empty
        assertTrue(queue.isEmpty(), "Queue should be empty initially.");

        // Enqueue an element
        queue.enqueue(1);
        assertFalse(queue.isEmpty(), "Queue should not be empty after enqueueing an element.");
    }

    /**
     * Test isFull method for the queue.
     */
    @Test
    public void testIsFull() throws QueueOverflowException {
        // Enqueue elements to fill the queue to its capacity
        for (int i = 0; i < 5; i++) {
            queue.enqueue(i);
        }

        // The queue should be full now
        assertTrue(queue.isFull(), "Queue should be full after enqueueing 5 elements.");
    }

    /**
     * Test enqueueing when the queue is full.
     */
    @Test
    public void testEnqueueFullQueue() throws QueueOverflowException {
        // Fill the queue
        for (int i = 0; i < 5; i++) {
            queue.enqueue(i);
        }

        // Enqueueing another element should throw QueueOverflowException
        assertThrows(QueueOverflowException.class, () -> queue.enqueue(6), "Enqueueing should throw QueueOverflowException when the queue is full.");
    }

    /**
     * Test dequeue from an empty queue.
     */
    @Test
    public void testDequeueEmptyQueue() {
        // Dequeuing from an empty queue should throw QueueUnderflowException
        assertThrows(QueueUnderflowException.class, () -> queue.dequeue(), "Dequeuing should throw QueueUnderflowException when the queue is empty.");
    }

    /**
     * Test toString method to get a string representation of the queue.
     */
    @Test
    public void testToString() throws QueueOverflowException {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        // Verify the string representation
        assertEquals("1 2 3", queue.toString(" "), "toString should return the correct string representation of the queue.");
    }

    /**
     * Test fill method to add elements from ArrayList to the queue.
     */
    @Test
    public void testFill() throws QueueOverflowException {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        queue.fill(list);

        // Verify that elements were added to the queue
        assertEquals(3, queue.size(), "Size should be 3 after filling the queue with elements.");
        assertEquals("1 2 3", queue.toString(" "), "toString should return the correct string representation after filling the queue.");
    }

    /**
     * Test fill method when the queue is full.
     */
    @Test
    public void testFillFullQueue() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        queue.fill(list);

        // Verify the queue size should be 5, as the queue's capacity is 5
        assertEquals(5, queue.size(), "Queue should be filled to its capacity of 5.");
        assertTrue(queue.isFull(), "Queue should be full after trying to fill more than its capacity.");
    }
}
