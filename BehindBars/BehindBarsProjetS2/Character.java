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

	/**
	 * 
	 * @param amount
	 * @param name
	 *            is the name of the player who receives the money
	 */
	public void giveMoney(int amount, Character name)
	{

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

}