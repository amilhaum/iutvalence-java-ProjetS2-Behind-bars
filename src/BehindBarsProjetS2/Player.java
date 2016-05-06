package BehindBarsProjetS2;

/**
 * The player of the game
 * 
 * @author Group BehindBars
 * @version 1.0.0
 */
public class Player extends Character
{

	/** The player's inventory */
	private Inventory			inventory;

	private static final int	DEFAULT_MONEY	= 100;

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
	public void giveObject(Object object, Character character)
	{
		throw new UnsupportedOperationException();
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