/**
 * Exception class  throws StackUnderflowException
 * @author Samuella helha
 */
public class StackUnderflowException extends Exception
{
	public StackUnderflowException()
	{
		super("Stack is empty, and underflow occurred");
	}
	
	public StackUnderflowException(String message)
	{
		super(message);
	}
}
