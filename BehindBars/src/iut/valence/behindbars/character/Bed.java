package iut.valence.behindbars.character;

import iut.valence.behindbars.windows.PositionOnScreen;

/**
 * The bed of the game.
 * 
 * @author Group BehindBars
 * @version 1.0.0
 */
public class Bed {

	/** The bed's name. */
	protected String name;
	/** The bed's position. */
	protected PositionOnScreen pos;
	
	/**
	 * The constructor of bed
	 * @param name is the bed's name
	 * @param pos0 is the bed's position
	 */
	public Bed(String name, PositionOnScreen pos0)
	{
		this.name = name;
		this.pos = pos0;
	}
	/**
	 * The getter of bed's name.
	 * 
	 * @return the bed's name
	 */
	public String getName() {
		return name;
	}
	/**
	 * The getter of bed's position.
	 * 
	 * @return the bed's position
	 */
	public PositionOnScreen getPos() {
		return pos;
	}

	

}
