package iut.valence.behindbars.game;

/**
 * The consumables of the game
 * 
 * @author Group BehindBars
 * @version 1.0.0
 */
public class Consumable extends Item
{
	/** The number of use of the consumable */
	private int nbOfUse;

	/**
	 * The constructor of the consumable
	 * 
	 * @param name
	 *            is the consumable's name
	 * @param description
	 *            is the consumable's description
	 * @param value
	 *            is the consumable's value
	 */
	public Consumable(String name, String description, int value, int nbOfUse)
	{
		super(name, description, value);
		this.nbOfUse = nbOfUse;
	}

}