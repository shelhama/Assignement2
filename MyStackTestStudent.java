import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

/**
 * Unit tests for the {@link MyStack} class.
 * <p>
 * This class tests various functionalities and behaviors of the {@link MyStack} class such as:
 * - Constructor functionality with specific and default capacity
 * - Push and pop operations
 * - Stack overflow and underflow exceptions
 * - Stack size, top element, and empty/full checks
 * - The {@code toString} method and its behavior with a delimiter
 * - The {@code fill} method with an ArrayList
 * </p>
 * The tests use JUnit 5 annotations like {@code @Test}, {@code assertTrue}, {@code assertFalse}, 
 * {@code assertEquals}, and {@code assertThrows} to validate the expected behavior of the stack
 * under different scenarios.
 * 
 * @author Samuella Helha
 */
public class MyStackTestStudent {

    /**
     * Tests the constructor of the {@link MyStack} class with a specified capacity.
     * Ensures that the stack is empty, not full, and has size 0 upon initialization.
     */
    @Test
    public void testConstructorWithCapacity() {
        MyStack<Integer> stack = new MyStack<>(5);
        assertTrue(stack.isEmpty()); // stack should be empty initially
        assertFalse(stack.isFull()); // stack shouldn't be full
        assertEquals(0, stack.size()); // stack size should be 0
    }

    /**
     * Tests the constructor of the {@link MyStack} class with the default capacity.
     * Ensures that the stack is empty, not full, and has size 0 upon initialization.
     */
    @Test
    public void testConstructorWithDefaultCapacity() {
        MyStack<Integer> stack = new MyStack<>();
        assertTrue(stack.isEmpty()); // stack should be empty initially
        assertFalse(stack.isFull()); // stack shouldn't be full
        assertEquals(0, stack.size()); // stack size should be 0
    }

    /**
     * Tests the {@link MyStack#push} method by pushing elements onto the stack and verifying that the stack becomes full.
     * @throws StackOverflowException if the stack overflows
     */
    @Test
    public void testPush() throws StackOverflowException {
        MyStack<Integer> stack = new MyStack<>(3);
        assertTrue(stack.push(1)); // pushing element to stack
        assertTrue(stack.push(2)); // pushing element to stack
        assertTrue(stack.push(3)); // pushing element to stack
        
        assertTrue(stack.isFull()); // stack should be full
    }

    /**
     * Tests the {@link MyStack#pop} method by popping elements from the stack and verifying the expected return value.
     * Verifies that a {@link StackUnderflowException} is thrown when attempting to pop from an empty stack.
     * @throws StackOverflowException if the stack overflows
     * @throws StackUnderflowException if the stack underflows
     */
    @Test
    public void testPop() throws StackOverflowException, StackUnderflowException {
        MyStack<Integer> stack = new MyStack<>(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertEquals(3, stack.pop()); // popping element from stack
        assertEquals(2, stack.pop()); // popping element from stack
        assertEquals(1, stack.pop()); // popping element from stack

        // Pop operation on empty stack should throw StackUnderflowException
        assertThrows(StackUnderflowException.class, () -> {
            stack.pop();
        });
    }

    /**
     * Tests the {@link MyStack#top} method by verifying the top element after multiple pushes and pops.
     * @throws StackOverflowException if the stack overflows
     * @throws StackUnderflowException if the stack underflows
     */
    @Test
    public void testTop() throws StackOverflowException, StackUnderflowException {
        MyStack<Integer> stack = new MyStack<>(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertEquals(3, stack.top()); // top should be 3
        stack.pop();
        assertEquals(2, stack.top()); // top should be 2
        stack.pop();
        assertEquals(1, stack.top()); // top should be 1
    }

    /**
     * Tests the {@link MyStack#isEmpty} method by checking if the stack is empty at various stages.
     * @throws StackOverflowException if the stack overflows
     * @throws StackUnderflowException if the stack underflows
     */
    @Test
    public void testIsEmpty() throws StackOverflowException, StackUnderflowException {
        MyStack<Integer> stack = new MyStack<>(3);
        assertTrue(stack.isEmpty()); // stack should be empty initially

        stack.push(1);
        assertFalse(stack.isEmpty()); // stack shouldn't be empty after push

        stack.pop();
        assertTrue(stack.isEmpty()); // stack should be empty after pop
    }

    /**
     * Tests the {@link MyStack#isFull} method by checking if the stack is full at various stages.
     * @throws StackOverflowException if the stack overflows
     */
    @Test
    public void testIsFull() throws StackOverflowException {
        MyStack<Integer> stack = new MyStack<>(3);
        assertFalse(stack.isFull()); // stack shouldn't be full initially

        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertTrue(stack.isFull()); // stack should be full after pushing 3 elements
    }

    /**
     * Tests the {@link MyStack#size} method by verifying the stack size at various stages.
     * @throws StackOverflowException if the stack overflows
     * @throws StackUnderflowException if the stack underflows
     */
    @Test
    public void testSize() throws StackOverflowException, StackUnderflowException {
        MyStack<Integer> stack = new MyStack<>(3);
        assertEquals(0, stack.size()); // stack size should be 0 initially

        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.size()); // stack size should be 2 after two pushes

        stack.pop();
        assertEquals(1, stack.size()); // stack size should be 1 after one pop
    }

    /**
     * Tests the {@link MyStack#toString} method by verifying the stack's string representation.
     * @throws StackOverflowException if the stack overflows
     */
    @Test
    public void testToString() throws StackOverflowException {
        MyStack<Integer> stack = new MyStack<>(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        // Additional assertions for the toString method can be added here
    }

    /**
     * Tests the {@link MyStack#toString(String)} method with a delimiter to verify the stack's string representation
     * using the specified delimiter.
     * @throws StackOverflowException if the stack overflows
     */
    @Test
    public void testToStringWithDelimiter() throws StackOverflowException {
        MyStack<Integer> stack = new MyStack<>(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertEquals("1,2,3", stack.toString(",")); // should return stack as "1,2,3"
    }

    /**
     * Tests the {@link MyStack#fill} method by filling the stack with elements from an {@link ArrayList}.
     * @throws StackOverflowException if the stack overflows
     */
    @Test
    public void testFill() throws StackOverflowException {
        MyStack<Integer> stack = new MyStack<>(3);
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        stack.fill(list); // filling stack with ArrayList
        // Additional assertions for the fill method can be added here
    }

    /**
     * Tests the {@link MyStack#push} method to verify that a {@link StackOverflowException} is thrown when
     * attempting to push onto a full stack.
     */
    @Test
    public void testPushStackOverflow() {
        MyStack<Integer> stack = new MyStack<>(2);
        assertDoesNotThrow(() -> stack.push(1)); // push should work
        assertDoesNotThrow(() -> stack.push(2)); // push should work

        // Push operation on full stack should throw StackOverflowException
        assertThrows(StackOverflowException.class, () -> stack.push(3));
    }

    /**
     * Tests the {@link MyStack#pop} method to verify that a {@link StackUnderflowException} is thrown when
     * attempting to pop from an empty stack.
     */
    @Test
    public void testPopStackUnderflow() {
        MyStack<Integer> stack = new MyStack<>(2);

        // Pop operation on empty stack should throw StackUnderflowException
        assertThrows(StackUnderflowException.class, () -> stack.pop());
    }

    /**
     * Tests the {@link MyStack#top} method to verify that a {@link StackUnderflowException} is thrown when
     * attempting to get the top element from an empty stack.
     */
    @Test
    public void testTopStackUnderflow() {
        MyStack<Integer> stack = new MyStack<>(2);

        // Top operation on empty stack should throw StackUnderflowException
        assertThrows(StackUnderflowException.class, () -> stack.top());
    }
}
