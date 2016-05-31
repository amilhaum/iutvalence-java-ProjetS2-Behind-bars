package iut.valence.behindbars.character;

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
	protected String name;

	/** The character's money */
	protected int money;

	/** The character's inventory */
	protected Inventory inventory;

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
	 * method use for all change about money.
	 * @param money
	 */
	public void setMoney(int money)
	{
		this.money = money;
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