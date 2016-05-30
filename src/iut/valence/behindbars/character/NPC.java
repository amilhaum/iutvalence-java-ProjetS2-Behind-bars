package iut.valence.behindbars.character;

import iut.valence.behindbars.exceptions.InventoryIsFullException;
import iut.valence.behindbars.exceptions.ItemNotInInventoryException;
import iut.valence.behindbars.game.Inventory;
import iut.valence.behindbars.game.Item;

/**
 * The Non-Players Characters of the game.
 *
 * @author Group BehindBars
 * @version 1.0.0
 */
public class NPC extends Character
{
	// 18 NPC 3 guards and 15 prisoners

	/** Default square number of the inventory. */
	private static final int DEFAULT_MAX_SQUARES_INVENTORY = 1000;

	/** Default NPC's money */
	private static final int DEFAULT_MONEY = 100;

	/** The NPC's state. */
	public final StateOfCharacter state;

	/**
	 * The NPC's constructor
	 *
	 * @param name
	 *            is the NPC's name
	 */
	public NPC(String name, StateOfCharacter state)
	{
		super(name);
		this.money = DEFAULT_MONEY;
		this.inventory = new Inventory(DEFAULT_MAX_SQUARES_INVENTORY);
		this.state = state;
	}

	/**
	 * The method to give an object
	 *
	 * @param item
	 *            is the object gave
	 * @param player
	 *            is the player
	 * @throws ItemNotInInventoryException
	 * @throws InventoryIsFullException
	 */
	public boolean giveItem(Item item, Player player) throws ItemNotInInventoryException, InventoryIsFullException
	{
		if (!this.inventory.getItems().contains(item))
		{
			throw new ItemNotInInventoryException("This object isn't in the inventory");
		}

		if (player.takeObject(item))
		{
			this.inventory.removeItem(item);
			return true;
		}

		else
		{
			throw new InventoryIsFullException("The inventory is full");
		}
	}

}