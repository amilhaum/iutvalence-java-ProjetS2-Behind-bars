package iut.valence.behindbars.character;

import iut.valence.behindbars.windows.PositionOnScreen;

import javax.swing.ImageIcon;

/**
 * The characters of the game
 *
 * @author Group BehindBars
 * @version 1.0.0
 */
public class Character
{
	/** The character's name. */
	protected String name;
	/** The position of the character on the screen. */
	protected PositionOnScreen pos;
	/** The character's pictures.*/
	protected ImageIcon[] pictures;

	/**
	 * The character's constructor
	 *
	 * @param name is the character's name
	 */
	public Character(String name)
	{
		this.name = name;
		this.pictures = new ImageIcon[]
		{ new ImageIcon(getClass().getResource("/pictures/player.png")), 
				new ImageIcon(getClass().getResource("/pictures/prisoner1.png")),
				new ImageIcon(getClass().getResource("/pictures/prisoner2.png")),
				new ImageIcon(getClass().getResource("/pictures/prisoner3.png")),
				new ImageIcon(getClass().getResource("/pictures/prisoner4.png")), 
				new ImageIcon(getClass().getResource("/pictures/guard.png")),
				new ImageIcon(getClass().getResource("/pictures/boss.png")), 
				new ImageIcon(getClass().getResource("/pictures/john.png")) };
	}

	/**
	 * The getter of the character's name.
	 * 
	 * @return the character's name
	 */
	
	public String getName()
	{
		return this.name;
	}

	/**
	 * The getter of the character's position.
	 * 
	 * @return the character's position
	 */
	public PositionOnScreen getPos()
	{
		return pos;
	}

	/**
	 * The getter of the character's pictures.
	 * 
	 * @return the character's pictures
	 */
	public ImageIcon[] getPictures()
	{
		return pictures;
	}

}
