/**
 * Exception class  throws StackOverflowException
 * @author Samuella Helha
 */

public class StackOverflowException extends RuntimeException
{
	public StackOverflowException()
	{
		super("Stack is full and overflow occurred");
	}
	
	public StackOverflowException(String message)
	{
		super(message);
	}
}