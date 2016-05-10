package iut.valence.behindbars.character;

import iut.valence.behindbars.exceptions.NotEnoughMoneyException;
import iut.valence.behindbars.game.Dialogue;
import iut.valence.behindbars.game.Inventory;

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
	 * @throws NotEnoughMoneyException
	 */
	public boolean giveMoney(int amount, Character character) throws NotEnoughMoneyException
	{
		if (!(this.money < amount))
		{
			this.money -= amount;
			character.money += amount;
			return true;
		}

		else
			throw new NotEnoughMoneyException("Not enough money !");
	}

	/**
	 * 
	 * @param dialogue
	 *            is the choice
	 * @return dialogue
	 */
	public Dialogue speak(Dialogue dialogue)
	{
		System.out.printf("%s : " + dialogue + "\n", this.name);
		return dialogue;
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