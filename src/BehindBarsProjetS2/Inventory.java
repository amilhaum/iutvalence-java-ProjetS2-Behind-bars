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
	/** The objects' collection of the inventory */
	private Collection<Object>	objects;

	/** The square's number used of the inventory */
	private int					nbSquaresUsed;

	/** The square's number max of the inventory */
	private int					nbMaxSquares;

	/** The inventory's constructor */
	public Inventory(int nbMaxSquares)
	{
		this.nbMaxSquares = nbMaxSquares;
		this.nbSquaresUsed = 0;
	}

	/**
	 * @return if inventory if full or not
	 */
	public boolean isFull()
	{
		return !(nbSquaresUsed < nbMaxSquares);
	}

	/**
	 * The method to add an object in the inventory
	 * 
	 * @param object
	 *            is the object added
	 */
	public void addObject(Object object)
	{
		// TODO add object in objects
		this.nbSquaresUsed++;
	}

	/**
	 * The method to remove an object in the inventory
	 * 
	 * @param object
	 *            is the object removed
	 */
	public void removeObject(Object object)
	{
		// TODO remove object in objects
		this.nbSquaresUsed--;
	}

}