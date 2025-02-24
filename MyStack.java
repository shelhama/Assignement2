import java.util.ArrayList;
import java.util.Arrays;

/**
 * MyStack class implementing the StackInterface.
 * @author Samuella Helha
 * @param <T> the data type of elements in the stack
 */
public class MyStack<T> implements StackInterface<T> {
    private static final int DEFAULT_SIZE = 60;
	private T[] stack;
    private int top;
    private int capacity;

    /**
     * Constructor to create the stack with a specific capacity.
     * @param capacity the maximum size of the stack
     */
    @SuppressWarnings("unchecked")
    public MyStack(int size)
	{
		T[] tempStack = (T[]) new Object[size];
		stack = tempStack;
		top = -1;
		this.capacity = size;
	}
    /**
     * Default constructor with a default size of 60.
     */
	@SuppressWarnings("unchecked")
	public MyStack()
	{
		T[] tempStack = (T[]) new Object[DEFAULT_SIZE];
		stack = tempStack;
		top = -1;
		this.capacity = DEFAULT_SIZE;
	}

    /**
     * Adds an element to the top of the Stack.
     * @param e the element to add to the top of the Stack
     * @return true if the add was successful, false if not
     * @throws StackOverflowException if stack is full
     */
 // Updated push method
    public boolean push(T e) throws StackOverflowException
	{
		if (isFull())
		{
			throw new StackOverflowException();
		}
		top++;
		stack[top] = e;
		if (stack[top] == e)
		{
			return true;
		}
		else
		{
			return false;
		}
	}


    /**
     * Deletes and returns the element at the top of the Stack.
     * @return the element at the top of the Stack
     * @throws StackUnderflowException if stack is empty
     */
    public T pop() throws StackUnderflowException {
        if (isEmpty()) {
            throw new StackUnderflowException("Stack is empty");
        }
        return stack[top--];
    }


    /**
     * Returns the element at the top of the Stack, does not pop it off the Stack.
     * @return the element at the top of the Stack
     * @throws StackUnderflowException if stack is empty
     */
    public T top() throws StackUnderflowException {
        if (isEmpty()) {
            throw new StackUnderflowException("Stack is empty");
        }
        return stack[top];
    }

    /**
     * Determines if Stack is empty.
     * @return true if Stack is empty, false if not
     */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * Determines if Stack is full.
     * @return true if Stack is full, false if not
     */
    public boolean isFull() {
        return top == capacity - 1;
    }

    /**
     * Number of elements in the Stack.
     * @return the number of elements in the Stack
     */
    public int size() {
        return top + 1;
    }

    /**
     * Returns a string representation of the Stack from bottom to top.
     * @return string representation of the Stack from bottom to top
     */
    @Override
    public String toString() 
	{
		if (isEmpty())
		{
			return "";
		}
		
		StringBuilder result = new StringBuilder();
		
		for (int i = 0; i <= top; i++)
		{
			result.append(stack[i].toString());
			if (i < top)
			{
				result.append("");
			}
		}
		
		return result.toString();
	}

    /**
     * Returns the string representation of the elements in the Stack, 
     * the beginning of the string is the bottom of the stack with elements separated by a delimiter.
     * @return string representation of the Stack from bottom to top with elements separated by the delimiter
     */
    @Override
    public String toString(String delimiter) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= top; i++) {
            sb.append(stack[i]);
            if (i < top) sb.append(delimiter);
        }
        return sb.toString();
    }

    /**
     * Fills the Stack with the elements of the ArrayList, 
     * First element in the ArrayList is the first bottom element of the Stack.
     * @param list elements to be added to the Stack from bottom to top
     * @throws StackOverflowException if stack gets full
     */
    @Override
    public void fill(ArrayList<T> list) throws StackOverflowException {
        // Ensure to copy the list and fill the stack
        for (T element : list) {
            push(element);
        }
    }
}
