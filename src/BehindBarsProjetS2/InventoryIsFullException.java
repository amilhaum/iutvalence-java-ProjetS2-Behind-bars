package BehindBarsProjetS2;

/**
 * The exception's "object is not in the inventory"
 * 
 * @author Group BehindBars
 * @version 1.0.0
 */
public class InventoryIsFullException extends Exception
{
	public InventoryIsFullException(String message)
	{
		super(message);
	}

	public InventoryIsFullException(String message, Throwable t)
	{
		super(message, t);
	}
}
