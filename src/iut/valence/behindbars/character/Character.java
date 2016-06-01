package iut.valence.behindbars.character;

import javax.swing.ImageIcon;

import iut.valence.behindbars.game.Inventory;
import iut.valence.behindbars.windows.PositionOnScreen;

/**
 * The characters of the game
 *
 * @author Group BehindBars
 * @version 1.0.0
 */
public class Character
{
	/** The character's name */
	protected String			name;

	/** The character's inventory */
	protected Inventory			inventory;

	protected PositionOnScreen	pos;

	protected ImageIcon[]		pictures;

	/**
	 * The character's constructor
	 *
	 * @param name is the character's name
	 */
	public Character(String name)
	{
		this.name = name;
		this.pictures = new ImageIcon[]
		{
				new ImageIcon(getClass().getResource("/pictures/player.png")), new ImageIcon(getClass().getResource("/pictures/prisoner1.png")), new ImageIcon(getClass().getResource("/pictures/prisoner2.png")), new ImageIcon(getClass().getResource("/pictures/prisoner3.png")), new ImageIcon(getClass().getResource("/pictures/prisoner4.png")),
				new ImageIcon(getClass().getResource("/pictures/guard.png")), new ImageIcon(getClass().getResource("/pictures/boss.png")), new ImageIcon(getClass().getResource("/pictures/john.png"))
		};
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
	 * @return the character's inventory
	 */
	public Inventory getInventory()
	{
		return this.inventory;
	}

	public PositionOnScreen getPos()
	{
		return pos;
	}

	public ImageIcon[] getPictures()
	{
		return pictures;
	}

}
