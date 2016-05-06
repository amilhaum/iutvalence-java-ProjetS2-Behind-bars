package BehindBarsProjetS2;

/**
 * The Non-Players Characters of the game
 * 
 * @author Group BehindBars
 * @version 1.0.0
 */
public class NPC extends Character
{

	/** Default square number of the inventory */
	private static final int	DEFAULT_MAX_SQUARES_INVENTORY	= 1000;

	/** Default NPC's money */
	private static final int	DEFAULT_MONEY					= 100;

	/**
	 * The NPC's constructor
	 * 
	 * @param name
	 *            is the NPC's name
	 */
	public NPC(String name)
	{
		super(name);
		this.money = DEFAULT_MONEY;
		this.inventory = new Inventory(DEFAULT_MAX_SQUARES_INVENTORY);
	}

	/**
	 * The method to give an object
	 * 
	 * @param object
	 *            is the object gave
	 * @param player
	 *            is the player
	 */
	public boolean giveObject(Object object, Player player)
	{
		if (player.takeObject(object))
		{
			this.inventory.removeObject(object);
			return true;
		}

		else
			return false;
	}

}