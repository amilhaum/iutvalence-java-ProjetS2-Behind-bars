package iut.valence.behindbars.character;

import iut.valence.behindbars.game.Dialogue;
import iut.valence.behindbars.game.Inventory;
import iut.valence.behindbars.game.Item;

/**
 * The player of the game.
 *
 * @author Group BehindBars
 * @version 1.0.0
 */
public class Player extends Character
{
	/** Default player's money */
	private static final int DEFAULT_MONEY = 100;

	/** Default square number of the inventory (player) */
	private static final int DEFAULT_MAX_SQUARES_INVENTORY = 10;

	private static final int DEFAULT_PENALTY = 0;

	private int penalty;

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
		this.penalty = DEFAULT_PENALTY;
	}

	/**
	 * The method to use an object
	 *
	 * @param item
	 *            is the object used
	 */
	public void useItem(Item item)
	{
		throw new UnsupportedOperationException();
	}

	/**
	 * The method to give an object to a npc
	 *
	 * @param item
	 *            is the object gave to the npc
	 * @param character
	 *            is the npc
	 */
	public boolean giveItem(Item item, NPC npc)
	{
		if (inventory.getItems().contains(item))
		{
			npc.getInventory().addItem(item);
			this.inventory.removeItem(item);
			return true;
		}
		else
		{
			return false;
		}
	}

	/**
	 * The method to take an object
	 *
	 * @param object
	 *            is the object took
	 */
	public boolean takeObject(Item object)
	{
		if (!inventory.isFull())
		{
			this.inventory.addItem(object);
			return true;
		}
		else
		{
			return false;
		}
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

	public int getPenalty()
	{
		return penalty;
	}

	public void setPenalty(int penalty)
	{
		this.penalty = penalty;
	}

}