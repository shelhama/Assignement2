
/**
 * Exception class that throws QueueOverflowException
 * @author Samuella Helha
 */
@SuppressWarnings("serial")
public class QueueOverflowException extends Exception 
{
	public QueueOverflowException()
	{
		super("Queue is full, and Queue overflow occurred");
	}
	
	public QueueOverflowException(String message)
	{
		super(message);
	}
}
