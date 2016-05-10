package iut.valence.behindbars.character;

import iut.valence.behindbars.game.Dialogue;
import iut.valence.behindbars.game.Inventory;
import iut.valence.behindbars.game.Object;

/**
 * The player of the game
 * 
 * @author Group BehindBars
 * @version 1.0.0
 */
public class Player extends Character
{
	/** Default player's money */
	private static final int	DEFAULT_MONEY					= 100;

	/** Default square number of the inventory */
	private static final int	DEFAULT_MAX_SQUARES_INVENTORY	= 10;

	/**
	 * The constructor of the player
	 * 
	 * @param name
	 *            is the player's name
	 */
	public Player(String name)
	{
		super(name);
		this.money = DEFAULT_MONEY;
		this.inventory = new Inventory(DEFAULT_MAX_SQUARES_INVENTORY);
	}

	/**
	 * The method to use an object
	 * 
	 * @param object
	 *            is the object used
	 */
	public void useObject(Object object)
	{
		throw new UnsupportedOperationException();
	}

	/**
	 * The method to give an object to a npc
	 * 
	 * @param object
	 *            is the object gave to the npc
	 * @param character
	 *            is the npc
	 */
	public boolean giveObject(Object object, NPC npc)
	{
		if (inventory.getObjects().contains(object))
		{
			npc.getInventory().addObject(object);
			this.inventory.removeObject(object);
			return true;
		}

		else
			return false;
	}

	/**
	 * The method to take an object
	 * 
	 * @param object
	 *            is the object took
	 */
	public boolean takeObject(Object object)
	{
		if (!inventory.isFull())
		{
			this.inventory.addObject(object);
			return true;
		}

		else
			return false;
	}

	/**
	 * The method to take a decision
	 * 
	 * @param dialogue
	 *            is the player's decision
	 */
	public boolean takeDecision(Dialogue dialogue)
	{
		throw new UnsupportedOperationException();
	}

}