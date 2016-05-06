package BehindBarsProjetS2;

import java.util.Collection;

/**
 * The inventory of the player
 * 
 * @author Group BehindBars
 * @version 1.0.0
 */
public class Inventory
{
	/** Default square number of the inventory */
	private final static int	DEFAULT_MAX_SQUARE_INVENTORY	= 10;

	/** The objects' collection of the inventory */
	private Collection<Object>	objects;

	/** The square's number used of the inventory */
	private int					nbSquaresUsed;

	/** The inventory's constructor */
	public Inventory()
	{
		this.nbSquaresUsed = 0;
	}

	/**
	 * @return if inventory if full or not
	 */
	public boolean isFull()
	{
		return !(nbSquaresUsed < DEFAULT_MAX_SQUARE_INVENTORY);
	}

}