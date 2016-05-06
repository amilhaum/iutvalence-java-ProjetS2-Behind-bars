package BehindBarsProjetS2;

/**
 * The characters of the game
 * 
 * @author Group BehindBars
 * @version 1.0.0
 */
public class Character
{
	/** The character's name */
	protected String	name;

	/** The character's money */
	protected int		money;

	/** The character's inventory */
	protected Inventory	inventory;

	/**
	 * The character's constructor
	 * 
	 * @param name
	 *            is the character's name
	 */
	public Character(String name)
	{
		this.name = name;
	}

	/**
	 * 
	 * @param amount
	 * @param name
	 *            is the name of the player who receives the money
	 */
	public boolean giveMoney(int amount, Character character)
	{
		if (!(this.money < amount))
		{
			this.money -= amount;
			character.money += amount;
			return true;
		}

		else
			return false;
	}

	/**
	 * 
	 * @param dialogue
	 */
	public Dialogue speak(Dialogue dialogue)
	{
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @return the character's name
	 */
	public String getName()
	{
		return this.name;
	}

	/**
	 * 
	 * @return the character's money
	 */
	public int getMoney()
	{
		return this.money;
	}

	/**
	 * 
	 * @return the character's inventory
	 */
	public Inventory getInventory()
	{
		return this.inventory;
	}

}