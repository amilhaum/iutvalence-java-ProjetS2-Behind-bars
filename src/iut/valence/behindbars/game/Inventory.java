package iut.valence.behindbars.game;

import java.util.ArrayList;

/**
 * The inventory of the player
 *
 * @author Group BehindBars
 * @version 1.0.0
 */
public class Inventory
{
	/** The objects' collection of the inventory */
	private ArrayList<Object> objects;

	/** The square's number used of the inventory */
	private int nbSquaresUsed;

	/** The square's number max of the inventory */
	private int nbMaxSquares;

	/** The inventory's constructor */
	public Inventory(int nbMaxSquares)
	{
		this.objects = new ArrayList<Object>();
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
	public boolean addObject(Object object)
	{
		if (!isFull())
		{
			this.objects.add(object);
			this.nbSquaresUsed++;
			return true;
		}
		else
		{
			return false;
		}
	}

	/**
	 * The method to remove an object in the inventory
	 *
	 * @param object
	 *            is the object removed
	 */
	public boolean removeObject(Object object)
	{
		int i = 0;
		while (i < objects.size()
				&& objects.get(i).getName() != object.getName())
		{
			i++;
		}
		if (i != objects.size())
		{
			objects.remove(i);
			this.nbSquaresUsed--;
			return true;
		}
		else
		{
			return false;
		}
	}

	/**
	 *
	 * @return he inventory's objects
	 */
	public ArrayList<Object> getObjects()
	{
		return objects;
	}

	/**
	 *
	 * @return the inventory's number of squares used
	 */
	public int getNbSquaresUsed()
	{
		return nbSquaresUsed;
	}

	/**
	 *
	 * @return the inventory's number of max squares
	 */
	public int getNbMaxSquares()
	{
		return nbMaxSquares;
	}

}