package iut.valence.behindbars.game;

import java.util.ArrayList;

/**
 * The inventory of the player.
 *
 * @author Group BehindBars
 * @version 1.0.0
 */
public class Inventory
{
	/** The objects' collection of the inventory */
	private ArrayList<Item> items;

	/** The square's number used of the inventory */
	private int nbSquaresUsed;

	/** The square's number max of the inventory */
	private int nbMaxSquares;

	/** The inventory's constructor */
	public Inventory(int nbMaxSquares)
	{
		this.items = new ArrayList<Item>();
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
	 * @param item
	 *            is the object added
	 */
	public boolean addItem(Item item)
	{
		if (!isFull())
		{
			this.items.add(item);
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
	 * @param item is the object removed
	 */
	public boolean removeItem(Item item)
	{
		int i = 0;
		while (i < items.size() && items.get(i).getName() != item.getName())
		{
			i++;
		}
		if (i != items.size())
		{
			items.remove(i);
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
	 * @param inventory
	 * @param item
	 * @return
	 */
	public boolean isInInventory(Inventory inventory, String item)
	{
		for (Item obj : inventory.getItems())
		{
			if (obj.getName() == item)
			{
				return true;
			}
		}
		return false;
	}

	/**
	 *
	 * @return he inventory's objects
	 */
	public ArrayList<Item> getItems()
	{
		return items;
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