package BehindBarsProjetS2;

public class Character
{

	protected String	name;
	protected int		money;

	public String getName()
	{
		return this.name;
	}

	public int getMoney()
	{
		return this.money;
	}

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

}