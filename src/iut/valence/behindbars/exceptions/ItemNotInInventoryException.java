package iut.valence.behindbars.exceptions;

/**
 * The exception's "object is not in the inventory"
 * 
 * @author Group BehindBars
 * @version 1.0.0
 */
public class ItemNotInInventoryException extends Exception
{
	public ItemNotInInventoryException(String message)
	{
		super(message);
	}

	public ItemNotInInventoryException(String message, Throwable t)
	{
		super(message, t);
	}
}
