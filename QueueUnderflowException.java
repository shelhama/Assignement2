/**
 * Exception class that throws QueueUnderflowException
 * @author Samuella helha
 */
@SuppressWarnings("serial")
public class QueueUnderflowException extends Exception
{
	public QueueUnderflowException()
	{
		super("Queue is empty, and Queue underflow occurred");
	}
	
	public QueueUnderflowException(String message)
	{
		super(message);
	}
}