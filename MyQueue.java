import java.util.ArrayList;

/**
 * MyQueue class implementing the QueueInterface.
 * 
 * @author Samuella Helha
 * @param <T> Generic data type
 */
public class MyQueue<T> implements QueueInterface<T> {
    private T[] queue;
    private int front, rear, size, capacity;
    
    /**
     * Constructor with specified size
     * @param capacity the maximum size of the queue
     */
    @SuppressWarnings("unchecked")
    public MyQueue(int capacity) {
        this.capacity = capacity;
        queue = (T[]) new Object[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }
    
    /**
     * Default constructor with a default size of 10
     */
    public MyQueue() {
        this(10);
    }
    
    @Override
    /**
	 * Determine if Queue is empty
	 * @return true if Queue is empty
	 */
    public boolean isEmpty() {
        return size == 0;
    }
    
    @Override
    /**
	 * Determine of the Queue is Full
	 * @return true if Queue is full
	 */
    public boolean isFull() {
        return size == capacity;
    }
    /**
	 * Deletes and returns the element at the front of the Queue
	 * @return the element at the front of the Queue
	 * @throws QueueUnderflowException if queue is empty
	 */
    @Override
    public T dequeue() throws QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueUnderflowException();
        }
        T element = queue[front];
        front = (front + 1) % capacity;
        size--;
        return element;
    }
    /**
	 * Returns sizeof  Queue
	 * @return the number of elements in the Queue
	 */
    @Override
    public int size() {
        return size;
    }
    /**
	 * @param e the element to add to the end of the Queue
	 * @return true if the add was successful
	 * @throws QueueOverflowException if queue is full
	 */
   
    public boolean enqueue(T e) throws QueueOverflowException {
        if (isFull()) {
            throw new QueueOverflowException();
        }
        rear = (rear + 1) % capacity;
        queue[rear] = e;
        size++;
        return true;
    }
    /**
	 * Returns the string representation of the elements in the Queue 
	 * @return string representation of the Queue with elements
	 */
    @Override
    public String toString() {
        return toString("");
    }
    /**
	 * Returns the string representation of the elements in the Queue
	 * Place the delimiter between all elements of the Queue
	 * @return string representation of the Queue 
	 */
    @Override
    public String toString(String delimiter) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0, index = front; i < size; i++) {
            sb.append(queue[index]);
            if (i < size - 1) {
                sb.append(delimiter);
            }
            index = (index + 1) % capacity;
        }
        return sb.toString();
    }
    /**
	  * Fills the Queue with the elements of the ArrayList, 
	  * @param list elements to be added to the Queue
	  * @throws QueueOverflowException if queue is full
	 
	  */
    @Override
    public void fill(ArrayList<T> list) {
        for (T item : list) {
            try {
                enqueue(item);
            } catch (QueueOverflowException e) {
                break;
            }
        }
    }
}
