package BehindBarsProjetS2;

/**
 * The exception's "object is not in the inventory"
 * 
 * @author Group BehindBars
 * @version 1.0.0
 */
public class ObjectNotInInventoryException extends Exception
{
	public ObjectNotInInventoryException(String message)
	{
		super(message);
	}

	public ObjectNotInInventoryException(String message, Throwable t)
	{
		super(message, t);
	}
}
